# Static
>어떠한 값이 메모리에 한번 할당되어 프로그램이 끝날때까지 그 메모리에 값이 유지된다는것을 의미
- 특정한 값을 공유하여 메모리의 이점을 얻는다.
## 클래스의 정적 구성 요소
- 클래스의 정적 구성 요소
    - 객체가 아니라 클래스 자체에 속하는 필드,메소드 등의 구성 요소
    - static 키워드를 사용하여 선언
## Static field(정적 필드)
>static 키워드가 붙은 필드

```java
class Accumulator {
    int total = 0;
    Static int grandTotal = 0;//정적 필드를 선언하는 선언문
    void accumulate(int amount){
        total += amount;
        grandTotal += amount; //정적 필드를 사용하는 메소드
    }
}

class Static FieldExample {
    public static void main(String[] args){
        class StaticFieldExample1 { 
    public static void main(String args[]) { 
        Accumulator obj1 = new Accumulator(); //객체 생성1
        Accumulator obj2 = new Accumulator(); //객체 생성2
        obj1.accumulate(10); //객체1의 accumulate메소드 실행
        obj2.accumulate(20); //객체2의 accumulate메소드 실행
        System.out.println("obj1.total = " + obj1.total); //10
        System.out.println("obj1.grandTotal = " + obj1.grandTotal); //30
        System.out.println("obj2.total = " + obj2.total); //20
        System.out.println("obj2.grandTotal = " + obj2.grandTotal//30
        //grandTotal은 정적변수(공유된 값)이므로 accumulate메소드가 실행하면서 값을 계속 더한 경우임
        System.out.println("총계= "+Accumulator.grandTotal);
        //객체를 생성하지 않고 (클래스이름.정적필드이름)으로 사용 가능
    }
}
```
## static 변수(클래스 변수)
>클래스가 정의만 되어도 접근이 가능한 변수 ex:) 클래스명.클래스변수<br>(인스턴스 변수는 인스턴스가 생성되었을때 접근 가능)
- static으로 선언된 변수는 선언되 클래스의 모든 인스턴스가 공유하게 된다.
- static 변수의 활용
    - 인스턴스 간에 데이터 공유가 필요한 상황.

## static 메소드(클래스 메소드)
>정적메소드 영역에서 사용가능한 필드는 정적 필드만 사용가능

```java
//정적 메소드들로만 구성괸 기능적 클래스
class IntBytes {
static byte firstByte(int num) {//int 타입 데이터의 1번째 바이트를 리턴
 num = (num >> 24) & 0xFF;           
 return (byte) num;             
  }                                 
static byte secondByte(int num) {//int 타입 데이터의 2번째 바이트를 리턴  
  num = (num >> 16) & 0xFF;     
  return (byte) num;             
   }                                  
static byte thirdByte(int num) {//int 타입 데이터의 3번째 바이트를 리턴
   num = (num >> 8) & 0xFF;        
   return (byte) num;           
      }                      
static byte forthByte(int num) {//int 타입 데이터의 4번째 바이트를 리턴 
   num = num & 0xFF;         
     return (byte) num;   
    }        
 } 
```

## 정적 초기화 블록 : static 키워드가 붙은 블록
>잘 쓰지는 않는다....
```java
class HunderdNumbers {
    static int arr[];
    static {            //정적 초기화 블록
        arr = new int[100]; 
        for(int cnt = 0; cnt<100; cnt++)
            arr[cnt] = cnt;
    }
}
```
