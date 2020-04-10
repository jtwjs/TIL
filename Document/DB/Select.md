## Select 문
> 데이터 검색,칼럼을 가공 처리하여 조회 가능<br>컬럼은 대소문자를 구분하지 않는다.<br>컬럼의 중복도 상관 없다.<br>칼럼을 이용한 연산이 가능하다.<br>(기존테이블에는 영향이없다.->값을 꺼낸후 연산)
- 테이블의 전체 조회  
    - select * <br>from 테이블명;
- 테이블내의 몇가지 칼럼 조회 
    - select 칼럼1,칼럼2 <br>from 테이블명;
- 테이블 내의 몇가지 칼럼중 특정 데이터만 조회 
    - select 칼럼1,칼럼2<br>from 테이블명<br> where 칼럼3="값";
- 칼럼에 별칭(alias)를 붙여 조회
    - select 칼럼1 "별칭", 칼럼2 as "별칭2", 카럼 별칭3 <br> from 테이블명;
- [distinct] 중복된 값 제거하고 조회
    - select DISTINCT 칼럼1,칼럼2 from 테이블명;
    - **반드시 select 옆에 위치해야 하며, 모든 칼럼에 적용되니 성능저하에 주의**
- [ || ] 연결 연산자로 칼럼 붙여서 조회
    - select 칼럼1 || 칼럼2 <br> from 테이블명;
- [order by] 정렬기능
    - 제일 마지막에 order by 칼럼명1 [asc/desc]
    - [asc]: 오름차순 생략가능(기본)
        - 숫자 : 작은 값부터 정렬
        - 문자 : 사전 순서로 정렬
        - 날짜 : 빠른 날짜 순서로 정렬
        - NULL : 가장 마지막에 나옴
    - [desc] : 내림차순
        - 숫자 : 큰 값부터 정렬
        - 문자 : 사전 반대 순서로 정렬
        - 날짜 : 늦은 날짜 순서로 정렬
        - NULL : 가장 먼저 나온다.

- nvl(column,value) : null 값을 value 값으로 바꾼다. 
    - Select nvl(칼럼1,value)<br>from 테이블명;
    - null 값 : 알수없는 값
- [group by] 특정 칼럼을 기준으로 한 그룹으로 묶어 합게,평균 등을 조회
    - select 칼럼1, 칼럼2, 칼럼3 <br>from 테이블<br>group by 칼럼1;
    - ex:) select seq,avg(seq),sum(sal) <br>from emp<br>group by seq;
        - seq를 기준으로 emp 테이블의 평균과 합계를 그룹으로 묶어 조회
- [having] 그룹으로 묶인 기준 칼럼이나 함수에 조건을 걸어 조회
    - select 칼럼1,칼럼2,칼럼3<br>from emp<br>group by 칼럼1 having 칼럼2<값;
    - ex:) select seq,avg,sum <br>from emp<br>group by seq having sum>3000;
        - seq를 기준으로 그룹이 된 값들 중에 합계가 3000이상인것을 조회

### WHERE 조건문

```
SELECT *[컬럼1,컬럼2,컬럼3,...]
FROM 테이블명
WHERE 조건절;
-- 조건절의 구성-> WHERE SAL   >=   3000;
                        ▲컬럼 ▲연산자 ▲비교대상값 
```
- 문자열은 단일 따옴표('')안에 기술한다. 대소문자를 구분한다.
- 날짜 데이터도 문자열과 마찬가지로 단일 따옴표 안에 기술한다.
    - ex:) WHERE HIRDEATE<='1982/01/01';
- 논리 연산자
    - AND : 두가지 조건 모두 만족해야만 검색 가능
    - OR  : 두가지 조건중 하나만 만족하더라도 검색 가능
    - NOT : 조건에 만족하지 못하는것만 검색
    - BETWEEN AND : 특정 벙뮈의 값을 조회할때 사용
        - ex:) WHERE SAL BETWEEN 2000 AND 3000
        - SAL 에서 2000 와 3000사이의 값을 만족하는 것만 검색
        - NOT 연산자와 함께 사용가능 
    - IN : 동일한 필드가 여러 개의 값중 하나인 경우인지 확인
        - ex:) WHERE COMM IN(300,500,1400);
        - 특정 필드의 값이 300이거나 500이거나 1400중에 어느하나만 만족하더라도 출력하도록하는 표현이다.
        - NOT 연산자와 함께 사용가능
    - LIKE : 검색하고자 하는값을 모를경우 검색을 도와줌
        - LIKE 다음에는 pattern을 기술해야 한다.
        - **%** : 문자가 없거나, 하나 이상의 문자가 어떤 값이 와도 상관없음
        - **_** : 하나의 문자가 어떤 값이 와도 상관없다.
    - IS NULL : 조건 값이 NULL인 경우들만 검색
    - IS NOT NULL : 조건 값이 NULL이 아닌경우들만 검색


