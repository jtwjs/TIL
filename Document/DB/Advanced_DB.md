## 분산 데이터베이스(Distributed Database)
>분산 데이터베이스는 **논리적으로는 같은 시스템**에 속하지만 **물리적으로는 컴퓨터 네트워크를 통해 분산되어 있는 데이터베이스**이다.
### 분산 데이터 베이스 시스템의 구성 요소
- **분산 처리기**
    - 자체적으로 처리 능력을 가지며 지리적으로 분산되어 있는 컴퓨터 시스템을 의미 
- **분산 데이터베이스**
    - 지리적으로 분산되어 있는 데이터베이스로서 해당 지역의 특성에 맞게 데이터베이스가 구성된다.
- **통신 네트워크**
    - 분산 처리기들을 통신망으로 연결하여 논리적으로 하나의 시스템처럼 작동할 수 있도록 하는 네트워크를 말함
### 분산 데이터베이스의 목표
- **위치 투명성(Location Transparency)**
    - 접근하려는 데이터베이스의 실제 위치를 알 필요 없이 단지 데이터베이스의 **논리적인 명칭만으로 접근가능**
- **중복 투명성(Replication Transparency)**
    - 동일한 데이터가 여러 곳에 중복되어 있더라도 사용자는 마치 **하나의 데이터만 존재하는 것처럼 사용가능**
    - 시스템은 자동으로 여러 데이터에 대한 작업을 수행
- **병행 투명성(Concurrency Transparency)**
    - 분산 데이터베이스와 관련된 다수의 트랜잭션들이 **동시에 실행되더라도** 그 **트랜잭션들의 수행 결과는 서로 영향을 받지 않는다.**
- **장애 투명성(Failure Transparency)**
    - 트랜잭션, DBMS, 네트워크, 컴퓨터 장애에도 불구하고 **트랜잭션은 정확하게 수행된다.**
### 분산 데이터베이스의 장·단점
- **장점**
    - 지역 자치성이 높다.
    - 데이터의 공유성이 향상
    - 분산 제어 가능
    - 시스템 성능 향상
    - 효율성 및 융통성이 높다.
    - 신뢰성 및 가용성이 높다.
    - 점증적 시스템 용량 확장이 용이
- **단점**
    - DBMS가 수행할 기능이 복잡
    - 데이터베이스 설계가 어렵다.
    - 소프트웨어 개발 비용이 증가한다
    - 처리 비용이 증가한다
    - 잠재적 오류가 증가한다
---
## 멀티미디어 데이터베이스(Multimedia Database)
>멀티미디어 데이터베이스는 **텍스트, 그래픽, 정지 화상, 동영상, 음성 등이 복합적으로 구성된 데이터베이스**이다.
### 멀티미디어 데이터베이스의 특성
- 데이터가 일반적으로 대용량이다
- 정형화된 데이터가 아니고 검색 대상의 내용이 데이터의 중간에 있을 수 있으므로 미디어별로 별도의 검색 방법이 필요
- 비정형 데이터이기 때문에 데이터의 구조가 복잡하고 관계를 구성하기가 어렵다.
### 멀티미디어 데이터베이스 구축방법
- 파일 기반 기법
    - DBMS를 사용하지 않으며 단순한 검색 위주의 VOD(Video On Demand)등에 이용됨
    - 데이터의 동시 접근이 어렵고 회복 기능 등의 지원이 빈약하다
- 관계형 데이터베이스 기반 기법
    - 텍스트 데이터를 저장하기 위해서는 CLOB(Character Large Object) 데이터 타입을 이용
    - 이미지, 비디오, 오디오 등을 이용하기 위해서는 BLOB(Binary Large Object) 데이터 타입을 이용
    - 일반적으로 정형화된 데이터는 관계형 데이터베이스의 데이터 타입을 이용하고 비정형화된 데이터는 파일로 저장
- 객체지향 데이터베이스 기반 기법
    - 멀티미디어를 가장 잘 표현할 수 있는 기법
    - 사용자 정의 클래스, 사용자 정의 메소드를 이용하여 미디어별로 별도의 클래스를 정의할수 있음
- 객체 관계형 데이터베이스 기반 기법
    - 관게형 데이터베이스의 CLOB, BLOB 데이터 타입을 이용하거나 사용자 정의 클래스, 사용자 정의 메소드를 이용하여 미디어별 타입을 정의해서 사용 가능
---
## 주기억장치 데이터베이스(Main Memory Database)
>주기억장치 데이터베이스는 데이터베이스 전체를 **주기억장치에 상주시킨 후 데이터베이스 연산을 수행**하는 시스템으로, **디스크 입·출력이 발생하지 않는다**.
### 주기억장치 데이터베이스의 특성
- 모든 연산이 주기억장치에서 수행되므로 **디스크 입·출력이 줄어들어 빠른 연산이 가능**
- 시스템의 문제가 생겼을 경우 복구시켜 주는 **회복작업의 구현이 어렵다.**
- 주기억장치의 구입 **비용이 많이 든다**.
---
## 데이터 웨어하우스(Data Warehouse)
>급증하는 **다량의 데이터를 효과적으로 분석하여 정보화**하고 이를 **여러 계층의 사용자들이 효율적으로 사용할 수 있도록 한 데이터베이스**이다.
- 데이터 웨어하우스에는 다양한 원본 데이터베이스로부터 정제되어 추출된 데이터만을 저장하고 필요한 인덱스를 생성한다.
- 이후, 데이터의 다차원 분석 도구로 데이터 웨어하우스를 분석하여 **효율적인 의사결정에 필요한 자료를 얻는다**.
### 데이터 웨어하우스의 장단점
- **장점**
    - 높은 투자 수익율을 얻을 수 있다.
    - 타사에 비하여 경쟁우위를 획드할 수 있다.
    - 의사 결정자의 생산성을 향상시킬 수 있다.
- **단점**
    - 기존 시스템과 명확한 역할 설정을 하지 못하면 업무의 혼란을 초래
    - 추출 기준에 맞지 않는 데이터의 입력,갱신,삭제가 발생시 불일치 문제 발생
    - 의사결정을 위한 충분한 데이터가 확보되지 않으면 정확한 결과를 도출할 수 없다.
    - 과다한 자원을 사용하게 되고 유지 보수가 어렵다.

## 데이터 마트(Data Mart)
>전사적으로 구축된 데이터 웨어하우스로부터 **특정 주제나 부서 중심으로 구축된 소규모 단일 주제의 데이터 웨어하우스**를 말함
- **특정 부서의 의사 결정 지원**을 목적으로 하는 부서별 또는 업무 기능별로 구축되는 데이터 웨어하우스 
    - 일반적으로 한 기업 내에 복수개의 데이터마트가 존재
- 전사적 통합성을 염두에 두고 데이터 마트가 데이터 웨어하우스보다 먼저 구축될수 있다.
### 데이터 마트의 특징
- 전사적 데이터 웨어하우스의 데이터를 분석 요건에 적합한 구조로 재구성함
- **추세, 패턴 분석** 및 **데이터 접근이 용이한 요약 데이터로 구성**되며, 필요시 일부 상세 데이터 포함
- 분석에 필요한 이력 데이터만을 포함하는 **제한된 규모의 데이터**
- 다양한 질의나 요구를 충족하는 **유연성과 접근성이 뛰어난 다차원 구조의 데이터**

## 데이터 마이닝(Data Mining)
>데이터 웨어하우스에 저장된 데이터 집합에서 **사용자의 요구에 따라 유용하고 가능성 있는 정보를 발견하기 위한 기법**
### 데이터 마이닝의 기법
- **연관(Association)**
    - 대용량의 트랜잭션 데이터로부터 "A이면 B이다" 형식의 연관 관계를 발견하기 위한 방법
- **연속(Sequence)**
    - 개인별 트랜잭션 이력 데이터를 시계열적으로 분석하여 트랜잭션의 향후 발생 가능성을 예측하는 방법
        - 시계열적 분석: 일정 기간동안 시간의 흐름에 따라 데이터를 분석하는 것을 말함
- **분류(Classification)**
    - 다른 그룹과의 차별적인 특성을 도출하기 위한 방법
- **클러스터링(Clustering, 군집화)**
    - 상호 간에 유사한 특성을 갖는 데이터들을 집단화 하는 방법
- **특성화(Characterization)**
    - 데이터 집합의 일반적인 특성을 분석하는 것으로 데이터의 요약 과정을 통해 특성을 발견하는 방법
- **패턴 분석(Pattern Analysis)**
    - 데이터베이스 내의 명시된 패턴을 찾는 방법
- **경향 분석(Trend Analysis)**
    - 시계열 데이터들이 시간 축으로 변화하는 전개 과정을 특성화하여 동적으로 변화하는 데이터를 분석하는 방법

---
## OLAP(Online Analytical Processing)
>다차원으로 이루어진 데이터로부터 **통계적인 요약 정보를 분석하여 의사결정에 활용하는 방식**을 말함
- 데이터 웨어하우스나 데이터 마트와 같은 시스템과 상호 연관되는 정보 시스템
- 데이터 웨어하우스가 데이터를 저장하고 관리한다면 OLAP는 **데이터 웨어하우스의 데이터를 전략적인 정보로 변환시키는 역할**
- OLAP는 **중간 매개채 없이** 이용자들이 직접 컴퓨터를 이용하여 데이터에 접근하는 데 있어 필수적인 시스템이라 할 수 있다.
### OLAP 연산
- Roll-up
    - 분석할 항목에 대해 한 차원의 계층 구조를 따라 단계적으로 구체적인 내용의 상세 데이터로부터 **요약된 형태의 데이터로 접근하는 기능**
- Drill-down
    - 분석할 항목에 대해 한 차우너의 계층 구조를 따라 단계적으로 요약된 형태의 데이터로부터 **구체적인 내용의 상세데이터로 접근하는 기능**
- Drill-through
    - 데이터 웨어하우스나 **OLTP에 존재하는 상세 데이터에 접근**하는 기능
- Drill-across
    - **다른 데이터 큐브의 데이터에 접근**하는 기능
- Pivoting
    - 보고서의 행, 열, 페이지 **차원을 바꾸어 볼 수 있는 기능**
- Slicing
    - 다차원 데이터 항목들을 **다양한 각도에서 조회**하고 자유롭게 비교하는 기능
- Dicing 
    - **Slicing을 더 세분화**하는 기능
### OLAP 종류
- ROLAP(Relational-OLAP)
    - 관계형 데이터베이스와 관계형 질의어를 사용하여 다차원 데이터를 저장하고 분석
- MOLAP(Multi-dimension OLAP)
    - 다차원 데이터를 저장하기 위해 특수한 구조의 다차원 데이터베이스를 사용하고 <Br>데이터 검색 속도를 향상시키기 위해 큐브 캐시라고 하는 주기억 장치 속에 데이터 큐브를 보관함
        - 데이터 큐브(Data Cube) : 특정 목적의 OLAP에서 사용하기 위한 큐브형태의 다차원 논리적 구조
- HOLAP(Hybrid OLAP)
    - ROLAP와 MOLAP의 특성을 모두 가지고 있다.
    - 빠른 검색이 필요한 경우에는 요약을 메모리에 저장하고 기본 데이터나 다른 요약들은 관계형 데이터베이스에 저장함

### OLTP(Online Transaction Proceesing)
>**온라인 업무 처리 형태**의 하나로 네트워크상의 **여러 이용자가 실시간**으로 데이터베이스의 데이터를 **갱신하거나 검색하는 등의 단위작업을 처리하는 방식**
- 여기서 단위 작업은 트랜잭션을 의미
    - 데이터 무결성을 위해 각 트랜잭션은 그 전체가 완전히 행하던지 전혀 행해지지 않던지 하나가 되도록 처리
- OLTP 시스템은 일반적으로 **빠른 응답시간을 요구**하며 개개의 레코드를 효율적으로 조회하고 수정할 수 있도록 **정규화 되어있다.**

## ODBC(Open DataBase Connectivity)
> 프로그램 데이터베이스의 종류에 관계없이 자유롭게 데이터베이스에 접근하여 사용할 수 있도록 Microsoft사가 만든 **응용프로그램의 표준 인터페이스(API)** 이다.
- **데이터베이스에 따른 차이는 ODBC 드라이버에 흡수됨**에 따라 사용자는 데이터베이스 종류를 의식하지 않고<br> ODBC 기준에 맞게 응용프로그램을 작성하기만 하면 된다.
- ODBC를 사용하면 **여러 종류의 데이터베이스를 함꼐 사용**할 수 있다.
- 기존에 사용하던 데이터베이스를 교체하더라도 응용프로그램을 그대로 사용할 수 있어 **비용이 절감됨**
### ODBC의 구조

![ODBC](https://user-images.githubusercontent.com/60641307/80305107-c4665700-87f5-11ea-9919-5cb0d706d55f.jpg)

- Application
    - 데이터베이스에 접속할 때 ODBC API를 사용함
- Driver Manager 
    - Application과 ODBC Driver 간의 통신을 관리하는 라이브러리 
    - DSN에서 정의된 형태로 특정 데이터베이스에 접속할 때 필요한 드라이버를 로딩하거나 언로딩함
- DSN(Domain Service Name)
    - 서버에 연결할 때 필요한 드라이버와 데이터베이스 정보를 저장함
- ODBC Driver
    - ODBC API가 지원하는 함수를 구현하는 라이브러리
- DB Server : ODBC Driver에서 요청한 SQL에 대한 결과를 반환

