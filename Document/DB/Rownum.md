## ROWNUM
> 오라클에서 지원하는 가상칼럼으로 쿼리의 결과에 1부터 하나씩 증가하여 붙는 컬럼
### 사용용도
- 주로 여러개의 결과를 출력하는 쿼리문을 실행 후 결과의 개수를 제한하여 가져오는데 쓰임

### 유의점
- ORDER BY 절의 실행 순서가 WHERE 절의 실행 후 이기 때문에 ORDER BY와는 관계없이 ROWNUM에 맞는 결과를 출력한 뒤 ORDER BY절을 수행해야한다.
- 따라서 순서를 바꾸기위해 ORDER BY절을 내부쿼리에서 실행한다.
```
-- 조회된 순서대로 순번을 매긴다.
SELECT ROWNUM
        , A.*
   FROM SCOTT.EMP A
  ORDER BY A.ENAME

-- ORDER BY를 사용하면 순번이 뒤섞이므로 정렬된 서브쿼리 결과에 ROWNUM을 매긴다.
SELECT ROWNUM
        ,X.*
    FROM(SELECT A.*
            FROM SCOTT.EMP A
            ORDER BY A.NAME
        )

-- 상위값 차례대로 구하는것이아닌 범위값을 구할 때
SELECT *
    FROM (SELECT ROWNUM NUM,EMPNO,ENAME,HIREDATE --정렬된 테이블의 결과에 ROWNUM을 매김
        FROM(SELECT EMPNO,ENAME,HIREDATE  
            FROM EMP                    -- 테이블정렬 
                ORDER BY HIREDATE))  
    WHERE NUM BETWEEN 6 AND 10; --범위 값 설정
```

### ROW_NUMBER() 함수
- ORDER BY 된 결과에 순번을 매길때에는 ROWNUM보다 ROW_NUMBER()함수가 더편하다.
```
SELECT ROW_NUMBER() OVER(ORDER BY A.JOB,A.ENAME) NUM
    , A.*
   FROM SCOTT.EMP A
   ORDER BY A.JOB, A.ENAME
```
- 그룹별(PARTITION)로 순번을 따로 부여
```
SELECTION ROW_NUMBER() OVER(PARTITION BY A.JOB ORDER BY A.JOB, A.ENAME) NUM
    , A.*
    FROM SCOTT.EMP A
    ORDER BY A.JOB, A.ENAME
```