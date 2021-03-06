## Table Space (테이블 스페이스)
>데이터 논리적 저장 단위 중 가장 상위에 있는 단위<br> 데이터블록 -> 익스텐트 -> 세그먼트 -> 테이블 스페이스

### 테이블 스페이스 생성
- **표기형식**
    ```SQL
    CREATE TABLESPACE [테이블 스페이스명]
    DETAFILE '파일경로' 
    SIZE 10M  --초기데이터 파일 크기 설정
    AUTOEXTEND ON NEXT 10M --초기 크기 공간을 모두 사용하는 경우 자동으로 파일의 크기가 커지는 기능
    MAXSIZE 100M --데이터파일이 최대로 커질 수 있는 크기 지정 기본값 = UNLIMITED
    UNIFORM SIZE 1M -- EXTENT 한개의 크기를 설정
    ```

### 전체 테이블 스페이스 조회
- **표기형식** : ``` SELECT * FROM DBA_TABLESPACES; ```

### 테이블의 테이블 스페이스 변경
- **표기형식** : ``` ALTER TABLE [테이블명] MOVE TABLESPACE [테이블 스페이스명] ```

### 테이블 스페이스 속성 변경
- **표기형식** 
    ```SQL
    --해당 테이블스페이스의 물리적인 파일의 이름 또는 위치변경
    ALTER TABLESPACE RENMAE [A] TO [B]

    --해당 테이블스페이스의 용량을 1024메가로 변경
    ALTER TABLESPACE [테이블스페이스명] ADD DATAFILE [추가할데이터파일명] SIZE 1024M;

    --해당 데이터파일경로에 해당하는 테이블스페이스의 크기가 FULL이 되면 자동으로 100메가씩 증가
    ALTER DATABASE DATAFILE [데이터파일경로] AUTOEXTEND ON NEXT 100M MAXSIZE UNLIMITED;
    ```
### 테이블 스페이스 삭제
- **표기형식** 
    ```SQL
    --테이블스페이스 내의 객체(테이블,인덱스등)를 전체 삭제
    DROP TABLESPACE [테이블 스페이스명] INCLUDE CONTENTS;

    --테이블스페이스의 모든 세그먼트를 삭제. (데이터가 있는 테이블스페이스 제외)
    DROP TABLESPACE [테이블 스페이스명] INCLUDING CONTENTS;

    --삭제된 테이블스페이스를 참조하는 다른 테이블스페이스의 테이블로부터 참조무결성 제약조건을 삭제
    DROP TABLESPACE [테이블 스페이스명] CASCADE CONSTRAINTS;

    --테이블 스페이스의 물리적파일까지 삭제
    DROP TABLESPACE [테이블 스페이스명] INCLUDING CONTENTS AND DATAFILES;
    ```

### 테이블 스페이스 작동방식
>오라클에서는 테이블스페이스라고 불리우는 테이블이 저장될 공간을 먼저 만들고나서 테이블을 생성한다.<BR>테이블에실질적으로 저장되는 장소라고 생각하면 된다. 이러한 작동방식은 각각의 테이블을 <BR>테이블 스페이스 별로 나누어서 관리와 퍼포먼스의 향상을 가지고 온다. 테이블스페이스를 생성하면<BR>정의된 용량만큼 미리 확보한 테이블스페이스가 생성되어지고 생성되어진 테이블스페이스에 테이블의 데이터가 저장된다.<BR>이렇게 설정된 데이터 스페이스에 용량이 가득차면 오라클 서버가 죽는다. 그러므로 관리를 잘해주어야 한다.<BR> 하지만 또 테이블스페이스 마다 용량을 너무나도 크게잡으면 가변적으로 용량사이즈가 줄어들지 안힉에 용량이 낭비된다.

>테이블 스페이스는 자동으로 할당해주는 부분이 많아 DBA가 아니고서는 권한도 없고 크게 신경쓰지 않아도된다.
1. 테이블 생성시 오라클 서버에서 자동으로 지정해줌
2. 유저를 생성하면서 디폴트 테이블 스페이스를 자동으로 지정해줌
3. 테이블을 만들게되면 그 테이블 스페이스에들어가게되고 테이블 스페이스 생성때 설정하는 경로에 위치하게된다.