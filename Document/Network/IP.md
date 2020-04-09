## **IP**
    > TCP/IP 기반의 인터넷 망을 통하여 데이타그램의 전달을 담당하는 프로토콜
    
    1. 주요기능
        - IP계층에서 IP패킷의 라우팅 대상이됨(Routing)
        - IP 주소 지정(Addressing)
    2. 주요 특징
        - 신뢰성(에러제어) 및 흐름제어 기능이 전혀 없음 -> Best-Effort Service
            - 한편 신뢰성을 확보하려면 IP 게층 위의 TCP와 같은 상위 트랜스포트 계층에 의존
        - 비연결성 데이터그램 방식으로 전달되는 프로토콜 -> **Connectionless**
        - 패킷의 완전한 전달(소실,중보,지연,순서바뀜 등 이없게함)을 보장하지 않음 -> **Unreliable**
        - IP 패킷 헤더 내 수신 및 발신 주소를 포함 -> **IPv4 헤더, IPv6 헤더, IP주소**
        - IP 헤더 내 바이트 전달 순서: 최상위 바이트(MSB)를 먼저 보냄 -> **Big-endian**
        - 경우에 따라, 단편화가 필요함 -> **IP단편화 참조**
        - TCP,UDP,ICMP,IGMP 등이 IP데이터그램에 실려서 전송
        
>IP주소에는 클래스라는 개념이있다.(네트워크영역 호스트IP영역을 나누는 클래스)

- A 클래스 : 하나의 네트워크가 가질수 있는 호스트 수가 제일 많은 클래스
    - IP주소를 32자리 2진수로 표현할때 맨앞자리가 **0**
    - 범위: **0.0.0.0 ~ 127.255.255.255**
- B 클래스 
    - IP주소를 32자리 2진수로 표현할때 맨앞자리가 **10**
    - 범위: **128.0.0.0 ~ 191.255.255.255**
- C 클래스
    - IP주소를 32자리 2진수로 표현할때 맨앞자리가 **110**
    - 범위: **192.0.0.0 ~ 223.255.255.255**
