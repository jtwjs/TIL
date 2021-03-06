## 시스템 카탈로그(System Catalog)
>데이터베이스 관리자(DBA)의 도구로, DB에 저장되어 있는 모든 데이터 개체들에 대한 정의나 명세에 대한 정보가 수록되어있는 시스템 테이블
- 데이터 사전(Data Dictionary)라고도 한다.
- DDL의 결과로 구성되는 기본 릴레이션, 인덱스, 뷰, 사용자, 접근 권한 등의 DB 구조 및 통계 정보가 저장됨
- 시스템 카탈로그에 저장된 내용을 메타데이터(Metadata)라고 한다.
- 시스템 카탈로그는 사용자와 데이터베이스 관리 시스템의 접근이 가능하다. 

### 시스템 카탈로그의 내용 
- **릴레이션 관련 정보**
    - 릴레이션 이름
    - 릴레이션이 저장된 파일 이름과 파일 구조
    - 릴레이션의 속성들에 대한 속성 이름과 타입(또는 도메인)
    - 릴레이션에 대해 정의된 각 인덱스의 이름
    - 릴레이션에 대해 정의된 무결성 제약 조건
- **인덱스 관련 정보**
    - 인덱스의 이름
    - 인덱스의 구조
    - 인덱스 키에 대한 정보
- **뷰 관련 정보**
    - 뷰의 이름
    - 뷰의 정의
    - 뷰의 소유자
- **통계 관련정보**
    - **릴레이션 카디널리티(Cardinality)**
        - 각 릴레이션에 저장된 레코드의 수 
    - **인덱스 카디널리티**
        - 각 인덱스에 저장된 레코드의 수 
    - **인덱스의 높이**
        - 각 트리 인덱스에 레벨
    - **인덱스의 범위**
        - 각 인덱스에 대한 최소 키값과 최대 키값
- **사용자 관련 정보**
    - 사용자의 계정(Accunt) 정보
    - 사용자의 권한 정보
### 시스템 카탈로그 특징
- 시스템 카탈로그 자체도 시스템 테이블로 구성되어 있어 사용자가 **SQL문을 이용하여 내용 검색 가능**
- 데이터베이스 관리 시스템에 의해 생성되고 유지된다.
- 시스템 카탈로그의 갱신
    - 사용자가 SQL문을 실행시켜 기본 테이블, 뷰, 인덱스 등을 변경하면 **DBMS가 자동으로 시스템 카탈로그를 갱신**한다.
    - 사용자가 SQL문으로 시스템 카탈로그를 **직접 갱신하는 것은 허용되지 않는다.**
- 분산 시스템에서의 시스템 카탈로그는 보통의 릴레이션, 인덱스, 사용자 등의 정보를 포함할 뿐만 아니라<BR> **위치 투명성 및 중복 투명성을 제공하기 위해 필요한 모든 제어 정보도 포함**되고 있다.
    - **위치 투명성**
        - 접근하려는 데이터베이스의 실제 위치를 알지 못해도 **데이터베이스의 논리적인 명칭만으로 접근 가능**한 특성
    - **중복 투명성**
        - 동일 데이터가 여러곳에 **중복되어 있더라도** 사용자는 마치 **하나의 데이터만 존재하는 것처럼 사용**, 시스템은 자동으로 여러데이터에 대한 작업을 수행하는 특성
### 시스템 카탈로그의 구성요소
- **SYSOBJECTS**
    - 사용자 릴레이션, 뷰, 제약조건, 규칙, 저장 프로시저 등 **데이터베이스에서 만들어진 각 개체에 관한 정보를 한 행으로 관리**
    - SYSOBJECTS는 **개체명**, **소유자**, **개체종류**, **생성일** 등으로 구성됨
        - 개체종류 : (U: 사용자테이블, V: 뷰, PK: PRIMARY KEY 제약조건)
- **SYSCOLUMNS**
    - 시스템 내에 있는 **모든 테이블에 대해** 각 테이블이 가지고 있는 **모든 열(속성)에 대한 정보를 한행으로 관리**
    - SYSCOLUMNS는 **속성명**, **테이블명**, **소유자**, **속성타입**, **자릿수** 등으로 구성됨
- **SYSINDEXES**
    - 시스템에 있는 **모든 인덱스에 대한 정보를 한행으로 관리**
    - SYSINDEXES는 **인덱스명**, **테이블명**, **속성수**, **튜플수** 등으로 구성됨
- **SYSVIEWS**
    - 시스템에 있는 **모든 뷰에 대한 정보를 한 행으로 관리**
    - SYSVIEWS는 **뷰명**, **소유자**, **뷰명령문** 등으로 구성됨
- **SYSUSERS**
    - 해당 데이터베이스를 사용할 수 있는 **사용자와 그룹에 관한 정보를 한행으로 관리**
    - SYSUSERS는 **사용자ID**, **사용자명**, **그룹명**, **생성일** 등으로 구성됨
- **SYSPROTECTS**
    - 데이터베이스의 계정에 적용된 **사용자 권한에 관한 정보를 한 행으로 관리**
    - SYSPROTECTS는 **개체명**, **사용자ID**, **권한**, **보호타입** 등으로 구성됨
