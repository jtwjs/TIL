# Singleton Pattern(싱글톤 패턴)
> **한번에 하나의 객체(Instance)만 가질수 있는 클래스**<br> 싱글톤 클래스의 객체를 만들 때 변수는 첫번째 객체를 가리킨다.

> 애플리케이션이 시작될 때 어떤 클래스가 **최초 한번만** 메모리를 할당하고(static) 그 메모리에 인스턴스를 만들어 사용하는 디자인패턴 <br>생성자가 여러차례 호출되더라도 실제로 생성되는 객체는 하나이고 최초 생성 이후에 호출된 생성자는 최초에 생성한 객체를 반환한다.<br>(**자바에선 생성자를 private로 선언해서 생성 불가하게 하고 getInstance()로 받아쓰기도함**)

>**Singleton Pattern은 단 하나의 인스턴스를 생성해 사용하는 디자인 패턴이다.**<br>인스턴스가 필요할 때 똑같은 인스턴스를 만들어 내는것이 아니라,동일(기존) 인스턴스를 사용하게함

## Singleton 클래스를 만드는 방법
1. **생성자를 private**로 만든다.
2. **이 싱글톤 클래스를 반환 유형으로 한 정적 메소드**를 작성한다.

```java
class MySingletonClass{
    private static MySingletonClass single_instance = null;
    
    private MySingletonClass(){

    }
    public static MySingletonClass getInstance() {
        if(single_instance == null){
            single_instance = new MySingletonClass();
        }
        return single_instance;
    }
}
```


## Singleton Pattern을 쓰는이유
1. 고정된 메모리 영역을 얻으면서 한번의 new로 인스턴스를 사용하기 때문에 메모리 낭비를 방지할 수 있음 
2. 싱글톤으로 만들어진 클래스의 인스턴스는 전역 인스턴스이기 떄문에 다른 클래스의 인스턴스들이 데이터를 공유하기 쉽다
    - DBCP(DataBase Connection Pool)처럼 공통된 객체를 여러개 생성해서 사용해야하는 상황에서 많이 사용
3. 인스턴스가 절대적으로 한개만 존재하는 것을 보증하고 싶을 경우 사용
4. 두 번째 이용시부터는 객체 로딩시간이 현저하게 줄어 성능이 좋아지는 장점
## Singleton Pattern의 문제점
1. 너무 많은 일을 하거나 많은 데이터를 공유시킬 경우 다른 클래스의 인스턴스들 간에 **결합도가 높아져** "개방-폐쇄 원칙"을 위배하게 된다.
    - 객체 지향 설계 원칙에 어긋남, 수정과 테스트가 어렵다.
2. 멀티쓰레드환경에서 동기화처리를 안하면 인스턴스가 두개가 생성되는 경우가 발생할수 있음
#### 일반 클래스 vs 싱글톤 클래스
>일반 클래스의 경우 클래스를 정의할때 생성자를 사용하는 반면,**싱글톤 ㄴ클래스의 경우 getInstance()메소드를 사용**