# Overloading (오버로딩)
## Method Overloading (메소드 오버로딩)
- 자바에서의 메소드 호출 조건
    - 메소드와 메소드 호출문의 **파라미터 수,타입,순서**가 맞아야함
> **이런 특성을 이용하여 한 클래스 안에 똑같은 이름의 메소드 여러개를 선언할수 있다.** -> 메소드 오버로딩
- **method signature** : 메소드 이름, 파라미터 변수의 수, 타입, 순서를 묶어서 명칭
```java
class PhysicalInfo{
    String name;
    int age;
    float height, weight;
    PhysicalInfo(String name,int age, float height, float weight){
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }//메소드의 이름은 같지만 파라미터 변수의 수와 타입이 다르다.
    void update(int age) {
        this.age = age;
    }
    void update(int age, float height){
        this.age = age;
        this.height = height;
    }
    void update(int age,float height,float weight){
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
}
```