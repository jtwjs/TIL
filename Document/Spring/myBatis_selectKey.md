##  &#60;selectKey&#62;
- 대부분의 RDBMS 시스템은 Sequence와 같은 채번 자동생성을 지원한다.<br>개발을 하다보면 종종 자동생성된 Sequence 값을 가져와서 사용해야 하는 경우가 있다.<br>이런 경우에 &#60;selectKey&#62;를 사용한다.
- &#60;selectKey&#62;는 mybatis의 statement 타입중 &#60;insert&#62;타입에만 사용할수 있는 하위 요소이다.
- &#60;insert&#62;문 아래에 사용함으로써, 자동생성된 키 값을 가져오며, 이 값을 반환하여 활용할수 있다.
### selectKey 속성

|속성|설명|
|:--|:--|
|keyProperty|selectKey 구문의 결과가 셋팅될 대상 프로퍼티(쿼리에 대입될 변수명)|
|keyColumn|리턴되는 결과셋의 칼럼명은 프로퍼티에 일치한다.<br>여러개의 칼럼을 사용한다면 칼럼명의 목록은 콤마를 사용해서 구분한다.|
|resultType|결과값의 타입, 마이바티스는 이기능을 제거할수 있지만 추가하는게 문제되지않는다.<br>마이바티스는 String을 포함하여 키로 사용될 수 있는 간단한 타입을 허용함|
|order|BEFOR 또는 AFTER 셋팅(실행시점) 할수 있다. <br>BEFORE로 설정하면 키를 먼저 조회하고 그 값을 keyProperty에 셋팅한 뒤 insert 구문을 실행함<br>AFTER로 설정하면 insert 구문을 실행한 뒤 selectKey 구문을 실행한다.<br>오라클은 같은 데이터베이스에서는 insert구문 내부에서 일괄된 호출형태로 처리|
|statementType|마이바티스는 Statemetn,PreparedStatement 그리고 CallableStatement을<br> 매핑하기 위해 STATEMENT, PREPARED 그리고 CALLABLE 구문타입을 지원한다.|

#### &#60;selectKey&#62; 기본예제

```xml
<insert id="insertExample" parameterType="productVO">
    <selectKey keyProperty="id" resultClass="int">
    SELECT STOCKIDSEQUENCE.NEXTVAL AS ID FROM DUAL
    </selectKey>

    INSERT INTO PRODUCT(PRD_ID, PRD_DESCRIPTION)
    VALUES(PRD_ID=#{ID}, PRD_DESCRIPTION=#{description})
</insert>

```
- &#60;selectKey&#62; 쿼리를 먼저 실행시키고 결과 값을 keyProperty로 productVO의 대입된다.
- keyProperty를 지정하지 않으면 Alias로 지정한 컬럼명으로 &#60;selectKey&#62; 결과 값이 대응된다.
    - 정확한 값이 대응대기 위해서는 keyProperty 값 == VO변수이름 == Table 컬럼명이 되어야 한다.
- &#60;selectKey&#62;를 사용하는 이유는 생성된 값을 다음에 활용하기 위하여 저장하는데에 있다.
- **멀티 쓰레드에서 발생할수 있는 문제의 해결을 위한사용**
    - &#60;selectKey&#62;를 사용하면, 채번한 값을 객체에 저장한 후 그 값을 INSERT에 사용하므로, 멀티쓰레드 상황에서도 안전하게 값을 가져올 수 있다.