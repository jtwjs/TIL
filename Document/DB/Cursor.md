## Cursor (커서)
> Context Area에 있는 데이터를 사람이 접근할수 있도록 연결해주는 일종의 연결통로(포인터)<BR> - Context Area : SQL문 실행할 때마다 처리하기 위해 SQL내부에서 사용하는 개별적인 메모리 공간
- SQL 커서는 ORACLE 서버에서 할당한 전용 메모리 영역에 대한 포인터
- 질의의 결과로 얻어진 여러 행이 저장된 메모리상의 위치
- 커서는 SELECT문의 결과 집합을 처리하는데 사용됨

![커서](https://user-images.githubusercontent.com/60641307/80049555-2dc43c80-854e-11ea-82c8-0f7e48dd0c38.jpg)

1. 사용자가 요청하는 데이터를 데이터베이스 버퍼 캐쉬에서 PL/SQL이 사용하는 개별적인 메모리 공간으로<br> 복사 해 온 후(복사 한 데이터: Active Set)
2. 커서를 통해서 Context Area에 있는 Active Set 중에서 원하는 데이터에 접근한 후 필요한 데이터를 추출(Fech)하여 
3. PL/SQL 변수에 담고 후속 작업을 하게 된다는 뜻
- **표기형식**
    ```sql
    DECLARE
    -- 커서선언
    CURSOR 커서_명 IS statment;
    BEGIN
    -- 커서열기
    OPEN 커서_명
    -- 커서로부터 데이터를 읽어와 변수에 저장
    FETCH 커서_명 INTO 변수_명;
    -- 커서닫기
    CLOSE 커서_명
    END;
    ```
- 커서의 상태
    - **%NOTFOUND** : 커서 영역의 자료가 **모두 FETCH됐었다면 TRUE**
    - %FOUND : 커서 영역에 FETCH 되지 않은 자료가 있다면 TRUE
    - %ISOPEN : 커서가 OPEN된 상태이면 TRUE
    - %ROWCOUNT : 커서가 얻어 온 레코드의 개수

### 커서 종류
- 묵시적 커서(Implicit Cursor) 
    > **오라클에서 자동으로 선언해주는 SQL 커서**로, 사용자 입장에서는 생성 유무를 알 수 없다.
    - 기본적으로 PL/SQL 블록 내에서의 **SELECT문,DML문이 실행될 때마다 암시적커서가 선언된다.**
    - 암시적커서의 경우 세션 내에 단 **한개만이 선언**되어 사용되었다가 **문장이 종료됨과 동시에 정리된다**.
    - 암시적커서의 저장되는 데이터는 1행만 가능하며, **여러행을 지정해서 작업해야 할 경우 사용할수 없다**.
    - 묵시적 커서 속성
        - SQL%**FOUND** : 해당 SQL문에 의해 반환된 총 행수가 1개 이상일 경우 TRUE
        - SQL%**NOTFOUND** : 해당 SQL문에 의해 반환된 총 행수가 없을 경우 TRUE
        - SQL%**ISOPEN** : 항상 FALSE, 묵시적 커서가 열려있는지의 여부 검색
            - PL/SQL은 실행 후 바로 묵시적 커서를 닫기 때문에 항상 FALSE
        - SQL%**ROWCOUNT** : 해당 SQL문에 의해 반환된 총 행수, 가장 최근 수행된 SQL문에 의해 영향을 받은 행의 개수
    - EX:)
    ```SQL
    SET SERVEROUTPUT ON;
    DECLARE
        BEGIN
        DELETE FROM EMP WHERE DEPTNO = 10;
        DBMS_OUTPUT.PUT_LINE('처리 건수 : ' || TO_CHAR(SQL%ROWCOUNT)|| '건');
        END;
    /*결과
    처리 건수: 21건
    PL/SQL 처리가 정상적으로 완료되었습니다. */

    ```
#### 명시적 커서(Explicit Cursor)
    > **사용자가 선언하여 생성 후 사용하는 SQL 커서**로 **주로 여러개의 행을 처리하고자** 할 경우 사용
    - 만약 여러건을 검색하는 SELECT문장의 경우 묵시적 커서를 사용할 경우 오라클은 예외사항을 발생시킴
        - 예외사항 -> (TOO_MANY_ROWS)
    - 여러개가 선언될 수 있으므로, 커서 속성 변수는 '커서명%'을 커서 속성 변수의 접두어로 붙여서 사용한다.
        - 묵시적 커서는 커서가 하나밖에 없기에 접두어로 SQL을 사용
    - 명시적 커서 속성
        - 커서명%**ROWCOUNT** : FETCH문에 의해 읽혀진 데이터의 총 행수
            - **가장 마지막에 처리된 행**이 몇 번째 인지 를 반환
        - 커서명%**FOUND** : FETCH문이 수행되었을 경우, **읽혀진(FETCH)행이 있을 경우 TRUE**값 반환
        - 커서명%**NOTFOUND** : FETCH문이 수행되었을 경우, **읽혀진(FETCH)행이 없을 경우 TRUE**값 반환
        - 커서명%**ISOPEN** : 명시적 커서가 메모리에 **확보(선언)되어 있을 경우 TRUE**값을 반환
- **명시적 커서(Explicit Cursor) 처리 단계**

    ![140327344F8BF93505](https://user-images.githubusercontent.com/60641307/80052544-e2159100-8555-11ea-8602-490377d7288e.jpg)

    1. 명시적 커서 선언(Declaration)
    >해당 커서를 사용하겠다고 PL/SQL에 알려주는 역할만 하며, 실제 메모리 할당 X
    ```SQL
    CURSOR 커서_명
    IS
     커서에 담고 싶은 내용을 가져오는 서브쿼리
    ```
    2. 명시적 커서 열기(OPEN)
    >커서 선언시 기술했던 서브쿼리를 수행해서 데이터를 커서로 가져온다.<BR> 이때 메모리에 실제커서가 사용할 메모리 공간이 할당이 된다.<BR>명시적 커서 영역에 자리잡은 데이터의 첫번째 행에 커서 포인터가 설정되고<BR> 바로 **이 포인터의 위치의 데이터 행을 다음단계인 FETCH에서 읽는다**.
    ```SQL
    OPEN 커서_명;
    ```
    3. 명시적 **커서**로부터 **데이터 읽어서 변수로 할당하기(FETCH)**
    >명시적 커서의 데이터들(Active Set)로부터 데이터를 한 건씩 읽어 변수를 할당<br>이때 읽게되는 데이터 행은 포인터에 의해서 지정되며 한 행이 FETCH되면 자동적으로 포인터는 다음 행으로 이동<BR>명시적 커서에 FETCH문은 반복문과 함께 사용하는 경우가 많다.<BR>FETCH문도 FETCH 후에 변수에 값을 할당하기 위해 INTO절을 사용
    ```SQL
    FETCH 커서_명 INTO 변수
    -- 커서명은 반드시 OPEN 되어있어야 FETCH 가능 
    /* 명시적 커서로부터 읽어온(FETCH) 데이터 행(레코드)을 
    PL/SQL 블록내에서 처리하기 위해서는 변수에 저장해서 사용한다. */
    ```
    4. 명시적 커서 닫기(CLOSE)
    >작업이 끝난 메모리 공간을 반환하고 정리 (명시적 커서의 정리(Clen-up)하는 작업명령)<br>닫기를 하지 않게되면 메모리가 크게 낭비되고 다른 PL/SQL BLOCK에서 동일한 이름의 커서를 사용할 경우 에러난다.
    ```SQL
    CLOSE 커서_명;
    ```
- **명시적 커서와 Cursor For Loop 문 활용하기**
>명시적 커서는 일반적으로 여러 건 데이터가 들어있으므로 이를 반복문을 사용한다.<br>그 중 가장 많이 사용되는 것이 For 문장<BR> PL/SQL 에서는 FOR 반복문과 커서를 결합하여 CURSOR FOR 반복 기능을 제공한다.
- 표기형식
    ```SQL
    FOR 레코드_명 IN 커서_명 LOOP -- 명시적 커서의 OPEN, FETCH가 자동으로 수행됨
        statement1;
        statement2;
    ...
    END LOOP; --루프문을 빠져 나갈 때 자동적으로 커서가 CLOSE 됨
    ```
- **파라미터 Explicit Cursor**
>파라미터 커서 : 명시적 커서를 선언한 후 OPEN할 때 값을 바꾸어서 수행해야 할 경우 <BR> 이때 커서를 OPEN 할때 필요한 값만 파라미터로 전달해서 반복 수행 할수있는 방법
- 표기형식
    ```SQL
    CURSOR 커서_명
    [ (파라미터_명 데이터타입, ···)]
    IS
        SELECT-statement; 
    ```
    - EX:)
    ```SQL
    DECLARE
        CURSOR prof_cur(v_deptno IN NUMBER)
        IS 
            SELECT *
            FROM professor
            WHERE deptno = v_deptno;
        v_prof professor%ROWTYPE;
    BEGIN 
        DBMS_OUTPUT.PUT_LINE('101번 학과 교수님 번호와 이름 출력');
        DBMS_OUTPUT.PUT_LINE('---------------------------------')

        OPEN prof_cur(101);
            LOOP
                FETCH prof_cur INTO v_prof;
                EXIT WHEN prof_cur%NOTFOUND;
                DBMS_OUTPUT.PUT_LINE(v_prof.profno||'번 교수님 이름은 '||
                                    v_prof.name||'입니다.');
            END LOOP;
        CLOSE prof_cur;
        DBMS_OUTPUT.PUT_LINE('============================');
        DBMS_OUTPUT.PUT_LINE('101번 학과 교수님 번호와 이름 출력');
        DBMS_OUTPUT.PUT_LINE('---------------------------------')
        OPEN prof_cur(102);
            LOOP
                FETCH prof_cur INTO v_prof;
                EXIT WHEN prof_cur%NOTFOUND;
                DBMS_OUTPUT.PUT_LINE(v_prof.profno||'번 교수님 이름은 '||
                                    v_prof.name||'입니다.');
            END LOOP;
        CLOSE prof_cur;
    END;
    /
    ```

- **Cursor 와 SELECT...FOR UPDATE 문장**
>명시적 커서를 선언해서 데이터를 조회한 후 변경을 하려는 중에 <BR>다른 세션에서 현 세션이 작업하는 내용을 변경 할 수 있는데<BR> 이때 커서를 선언할 때 커서에 있는 행들에 대해 잠금(LOCK)을 수행할 수 있다.
- SELECT 문장의 가장 마지막 부분에 SELECT... FOR UPDATE문장을 사용하면 된다.
- **Ref Cursor**
>Cursor를 선언하는 시점에서 SQL을 지정하지 않고 **Cursor가 OPEN이 되는 시점에 SQL 문장을 지정**할 수 있다.<BR>-> Ref Cursor는 동적(Danymic) Cursor라고 부른다.