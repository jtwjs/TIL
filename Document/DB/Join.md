## JOIN
>JOIN은 2개의 테이블에 대해 연관된 튜플들을 결합하여 하나의 새로운 릴레이션을 반환한다. 
- JOIN은 크게 INNER JOIN, OUTER JOIN으로 구분된다.
- JOIN은 일반적으로 FROM절에 기술하지만, 릴레이션이 사용되는 어느곳에서나 사용할 수 있다.

### JOIN의 기본사용방법
- 두개의 테이블에 하나라도 같은 컬럼이 있어야한다.
- 두 컬럼의 값은 공유 되어야한다.
- 보통 조인을 위해 기본키(Primary Key)와 외래키(Foreign Key)를 활용한다.


|종류|설명|
|:---|:---|
|Equi Join<br>(Inner Join),(Natural Join)|동일 칼럼을 기준으로 조인|
|Non-Equi Join|동일 칼럼이 없이 다른 조건을 사용하여 조인|
|Outer Join|조인 조건에 만족하지 않는 행도 나타낸다|
|Self Join|한 테이블 내에서 조인|

### INNER JOIN
>INNER JOIN은 일반적으로 EQUI JOIN과 NON-EQUI JOIN 으로 구분된다.
- **EQUI 조인**
    - JOIN 대상 테이블에서 공통속성을 기준으로 '='비교에 의해 같은 값을 가지는 행을 연결하여 결과를 생성하는 JOIN 방법
    - **NATURAL JOIN**
        - JOIN 조건이 '='일 때 동일한 속성이 두번 나타나게 되는데 이 중 중복된 속성을 제거하여 같은 속성을 한번만 표기하는것
    - EQUI JOIN 에서 연결 고리가 되는 공통 속성을 JOIN 속성이라고 한다.
    - **WHERE 절을 이용한 EQUI JOIN의 표기형식** [**실무에서 가장많이 사용**]
        ```
        SELECT [테이블명1.]속성명,[테이블명2.]속성명, ···
        FROM 테이블명1, 테이블명2,···
        WHERE 테이블명1.속성명 = 테이블명2.속성명;
        ```
    - **NATURAL JOIN을 이용한 EQUI JOIN의 표기형식**
        ```
        SELECT [테이블명1.]속성명,[테이블명2.]속성명,···
        FROM 테이블명1 NATURAL JOIN 테이블명2;
        ```
    - **JOIN ~ USING절을 이용한 EQUI JOIN의 표기 형식**
        ```
        SELECT [테이블명1.]속성명,[테이블명2.]속성명,···
        FROM 테이블명1 JOIN 테이블명2 USING(속성명);
        ```
- **NON-EQUI JOIN**
    - JOIN 조건에 '=' 조건이 아닌 나머지 비교 연산자, 즉>,<,<>,>=,<= 연산자를 사용하는 JOIN 방법
        - between A and B : A 와 B 사이 값
        - is null : 값이 null 인 조건
        - is not null : 값이 null이 아닌 조건
        - in(A,B): A또는 B를 포함한 값
    - **표기형식**
        ```
        SELECT [테이블명1.]속성명,[테이블명2.]속성명,···
        FROM 테이블명1,테이블명2,···
        WHERE (NON-EQUI JOIN 조건);
        ```
### OUTER JOIN
>OUTER JOIN은 릴레이션에서 JOIN 조건에 만족하지 않는 튜플도 결과로 출력하기 위한 JOIN 방법
<BR> LEFT OUTER JOIN, RIGHT OUTER JOIN, FULL OUTER JOIN 등이 있다.
- **LEFT OUTER JOIN** : 
    - INNER JOIN의 결과를 구한 후, 우측 항 릴레이션의 어떤 튜플과도 맞지 않는 <BR>좌측 항의 릴레이션에 있는 튜플들에 NULL 값을 붙여서 INNER JOIN의 결과에 추가한다.
    - **표기형식**
        - **ANSI SQL 표준방식**
        ```
        SELECT [테이블명1.]속성명,[테이블명2.]속성명,···
        FROM 테이블명1 LEFT OUTER JOIN 테이블명2
        ON 테이블명1.속성명 = 테이블명2.속성명;
        ```
        - **오라클 방식**
        ```
        SELECT [테이블명1.]속성명,[테이블명2.]속성명,···
        FROM 테이블명1,테이블명2
        WHERE 테이블명1.속성명 = 테이블명2.속성명(+);
        ```
- **RIGHT OUTER JOIN**
    - INNER JOIN의 결과를 구한 후, 좌측 항 릴레이션의 어떤 튜플과도 맞지 않는<bR> 우측 항의 릴레이션에 있는 튜플들에 NULL값을 붙여서 INER JOIN의 결과에 추가한다.
    - **표기형식**
        - **ANSI SQL 표준방식**
        ```
        SELECT [테이블명1.]속성명,[테이블명2.]속성명,···
        FROM 테이블명1 RIGHT OUTER JOIN 테이블명2
        ON 테이블명1.속성명 = 테이블명2.속성명;
        ```
        - **오라클 방식**
        ```
        SELECT [테이블명1.]속성명,[테이블명2.]속성명,···
        FROM 테이블명1,테이블명2
        WHERE 테이블명1.속성명(+) = 테이블명2.속성명;
        ```
- **FULL OUTER JOIN**
    - LEFT OUTER JOIN과 RIGHT OUTER JOIN을 합쳐 놓은 것
    - **표기형식**
        - **ANSI SQL 표준방식**
        ```
        SELECT [테이블명1.]속성명,[테이블명2.]속성명,···
        FROM 테이블명1 FULL OUTER JOIN 테이블명2
        ON 테이블명1.속성명 = 테이블명2.속성명;
        ```

### SELF JOIN(셀프 조인)
>같은 테이블에서 2개의 속성을 연결하여 EQUI JOIN을하는 JOIN 방법
- JOIN 대상이 나와 또다른 나 이다.
- 자기자신과 조인하기 때문에 컬럼명이 같아서 꼭 별칭(ALIAS)를 명시해주어야 함
- **표기형식**
    ```
    SELECT [별칭1.]속성명,[별칭1.]속성명,···
    FROM 테이블명1 [AS] 별칭1 JOIN 테이블명1 [AS] 별칭2
    ON 별칭1.속성명 = 별칭2.속성명;

    //HWERE 절을 이용한 방법
    SELECT [별칭1.]속성명,[별칭1.]속성명,···
    FROM 테이블명1 [AS] 별칭1, 테이블명2 [AS] 별칭2
    WHERE 별칭1.속성명 = 별칭2.속성명;
    ```


