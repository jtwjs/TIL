# Exception(예외)

## try문
>익셉션 처리에 사용되는 명령문

```java
//기본형식
try{
    try블록
}catch(익셉션타입 익셉션변수){  //catch절(catch clause).반복가능
    catch블록
}finally{                    //finally절(finally clause).생략가능
    finally블록
}

//Ex1
class TryExample{
    public static void main(String args[]){
        int a = 3, b = 0;
        int result;
        try{                   //이 부분 실행하다가 익셉션이 발생하면
            result = a/b;
            System.out.println(result);
        }
        catch(java.lang.ArithmeticException e){//이 부분을 실행한다.
            System.out.println("잘못된 연산입니다.");
            System.out.println(e.getMessage()); // 익셉션 메세지를 출력
        }
        finally{        //이 부분은 익셉션 발생 유무와 상관없이 실행
            System.out.println("Done");
        }
    }
}

//Ex2
int divisor[] = {5,4,3,2,1,0};
for(int cnt = 0; cnt<10; cnt++){
    try{
        int share= 100/divisor[cnt];
        System.out.println(share);
    }
    catch(java.lang.ArithmeticException e){//catch블록 중복가능
        System.out.println("잘못된 연산입니다.");
    }
    catch(java.lang.ArrayIndexOutOfBoundsException e){
        System.out.println("잘못된 인덱스입니다.");
    }
    catch(java.lang.Exception e){ //Exception:모든 예외처리의 부모클래스(모든 예외처리)
                    //예외처리 기술을할때 부모예외처리는 자식예외처리보다 아래에 있어야한다.
        System.out.println("잘못된 인덱스입니다.");
    }
    System.out.println("Done"); 

/*결과값
20
25
33
50
100
잘못된 연산입니다.
잘못된 인덱스입니다.
잘못된 인덱스입니다.
잘못된 인덱스입니다.
잘못된 인덱스입니다.
Done.
*/
}
```