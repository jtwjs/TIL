
# Has A 관계 (포함 관계)
> 캡슐(class)이 다른 캡슐을 이용하는 관계가 있다. 그것을 이용하기 위해 자기의 부품(멤버)로 가지고 있다.

- 다른 객체를 받아들여서 그 객체의 기능을 사용하는 것이다.
- 받아들인 객체의 자원(메소드/변수)를 사용할 수 있다.
```java
class Gun
{
    public int power; //총은 파괴력이나
    public int shot;  // 탄약의 갯수등이 존재한다.
};
class police{
    Gun gun = new Gun();//경찰이 총을 소유한다.
    //이제 경찰이 총이 가진 기능을 사용할수 있게된것이다.
}
```
## Composition
>전체와 부분이 강력한 연관 관계를 맺으며, 전체와 부분이 같은 생명 주기를 갖는다.
## Aggregation 
>전체와 부분의 연관 관계를 맺지만, 그러나 동일한 생명 주기를 갖지 않는다.
![제목_없음](https://user-images.githubusercontent.com/60641307/75621716-34cc6f80-5bdb-11ea-8d8b-e6c47e4a1811.png)

# Is A 관계의 객체화 (상속관계의 객체화)
>부모클래스 객체명 = new 자식클래스()<br>(무엇든 포함할수 있는 기본이되는 클래스의 능력을 다른클래스에게 포함시켜주는것)
- 부모클래스로 데이터형을 선언하고 자식클래스를 생성해서 할당
- 부모클래스의 변수와 메소드만 호출 할 수 있다.
- 원칙적으로 자식클래스의 변수와 메소드는 호출 할 수 없다.
- 자식클래스에 부모클래스에게서 Override한 메소드가 있다면 그 메소드는 호출가능
- class뿐아니라 interface등도 부모로 받을수 있다.

```java 
class Person
{
    public int age; //사람이라면 나이가 있고,
    public char name;//이름이 있다.
};
class Student extends Person
{
    public char schoolAdress;//그 사람을 상속하면서, 학교의주소나,
    public char major;        //전공들을 학생은 추가로 가지고 있을것이다.
};
```