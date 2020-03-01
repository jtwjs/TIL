# Code Reuse(코드 재사용) <IntelliJ>

## JAR파일 Export
>JAR : java archive를 의미,java코드의 zip파일과 유사한개념
1. File - Project Structure 메뉴 <br>(단축키: [Ctrl]+[Alt]+[Shift]+[S])
![jar1](https://user-images.githubusercontent.com/60641307/75622184-110c2800-5be1-11ea-9c81-aa035e487d10.png)
2. Artifacts - 우측 Add버튼 (단축키: Alt+Insert) - JAR - From modules with dependences 
![jar2](https://user-images.githubusercontent.com/60641307/75622241-98599b80-5be1-11ea-93f0-fd12e0a8d44d.png)
3. Module: 선택한모듈 - OK 
>Executable JAR파일을 만들려면 Main Class를 명시해야 하지만 다른 프로젝트에서 외부 라이브러리로 사용할 JAR파일을 만들기위해 공란으로 둠
![jar3](https://user-images.githubusercontent.com/60641307/75622279-ee2e4380-5be1-11ea-8299-f940b849721e.png)
4. Output directory란에 JAR파일을 만들 디렉토리가 자동으로 입력됨 - OK
![jar4](https://user-images.githubusercontent.com/60641307/75622393-e58a3d00-5be2-11ea-927e-fc8ee12aea72.png)

5. Build - Build Project (단축키: Ctrl + F9)
![jar5](https://user-images.githubusercontent.com/60641307/75622421-474aa700-5be3-11ea-82f6-db779a8a1bf3.png)

6. 빌드가 정상적으로 끝나면 Build - Build Artifacts
![jar6](https://user-images.githubusercontent.com/60641307/75622442-9ee91280-5be3-11ea-85a9-6decebe047fc.png)

7. JarExample:jar - build 클릭
![jar7](https://user-images.githubusercontent.com/60641307/75622461-d8218280-5be3-11ea-9b47-a393f2d345de.png)
8. Jar파일 생성 완료
![jar8](https://user-images.githubusercontent.com/60641307/75622528-91805800-5be4-11ea-9da7-348ffa79a210.png)

## JAR 파일 Import
1. File - Project Structure 메뉴 <br>(단축키: [Ctrl]+[Alt]+[Shift]+[S])
![jar1](https://user-images.githubusercontent.com/60641307/75622184-110c2800-5be1-11ea-9c81-aa035e487d10.png)
2. Libraries - 우측 Add버튼 (단축키: Alt+Insert) - Java 

![jarImport2](https://user-images.githubusercontent.com/60641307/75622575-369b3080-5be5-11ea-93cc-4f02d989f0d7.png)

3. Import할 JAR 파일 선택 
![jarImport3](https://user-images.githubusercontent.com/60641307/75622617-d0fb7400-5be5-11ea-90c6-4c78b3501812.png)

4. JAR파일을 Import할 모듈 선택
![jarImport4](https://user-images.githubusercontent.com/60641307/75622649-1c158700-5be6-11ea-8635-64d9ae6fdbb9.png)

5. 프로젝트의 External Libraries 하위에 추가됨
![jarImport5](https://user-images.githubusercontent.com/60641307/75622669-5aab4180-5be6-11ea-92cb-551532c80156.png)

