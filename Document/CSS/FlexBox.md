## Flexbox
#### How to use it
- **나,플렉스박스 쓸거임(단호)**
    
    ```CSS
        display: flex;
        /* flex | inline-flex*/
    ```
    - 정렬하고자 하는 요소를 감싸는 **부모에게 display:flex** 지정
- **가로정렬? 세로정렬?**
    
    ```CSS
    flex-direction: row;
    /* row(가로) | row-reverse | column(세로) | column-reverse */
    ```
    - **Axis** : flex를 사용하면 보이지않는 두개의 축이 생김
        - flex-direction이 어떤값으로 설정되있는지에 따라 축의 방향이 달라짐
        - Main axis: flex-direction의 값의 방향 (↓,→)
        - Cross axis: Main aixs 와 수직을 이루는 방향 (↓,→)
- **무조건 한줄 안에 다정렬?**
    >어떻게든 한줄안에 모든 요소를 정렬할것인지, 여러줄을만들어서 정렬할것인지 정하는것
    ```CSS
    flex-wrap: nowrap;
    /* nowrap | wrap */
    ```
    - **nowrap**: 감싸지 않고 자식의 사이즈를 줄여서라도 한줄로 정렬해버린다.
    - **wrap**: 한 줄에 모두 정렬하기에 공간이 넉넉하지 않으면 여러 줄을 만들어 버림
- **씬나는 플렉스박스 파티 타임!**

    ```CSS
     /* Main axis의 방향을 기준으로 정렬할때 사용*/
    justify-content: center;

    /* Cross axis의 방향을 기준으로 정렬할때 사용*/
    align-items: 
    /* felx-wrap: wrap 일 때  */
    align-content: 

    /* flex-start(시작부분) | center | flex-end(끝부분) */
    /* space-between(요소들 사이의 간격을 같게 해줌) |
    /* space-around(요소 양옆간격이 같아진다)
    
    ```
- **order** : 요소의 순서를 지정해준다.
---
- TIP 
    1. 선 align-itmes 후 align-content

