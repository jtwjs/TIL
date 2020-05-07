## Media
- **Syntax Alert 문법주의**
    - **src**, [alt] 속성을 반드시 작성
- **오디오파일**
    - 일반적인 사용방법
        - ```<audio src="" >```
    
    - 간지나게사용하는 방법
     ```CSS
        <audio controls>
            <source src="./경로.wav" type="audio/wav />
            <source src="./경로.mp3" type="audio/mp3 />
            <source src="./경로.ogg" type="audio/ogg />
        </audio>
        <!-- 브라우저마다 지원하는 오디오파일 형식이 다르다.
         그럴때 요렇게 함써보자--!>
    ```
         
    - controls(atribute) 컨트롤바 생성
    - autoplay(attribute) 자동재생
    - loop(attribute) 무한반복

- **비디오파일**
    - 일반적인 사용방법
        - ```<video src=""> ```
    - 간지나게 사용방법
    ```CSS
    <video>
        <source src="./경로.mov" type="video/mp4 />
        <source src="./경로.mp4" type="video/mp4 />
        <p>
            브라우저를 업데이트 하심이 어떠신지요ㅋ?
        </p>
        <a href="https://browsehappy.com">브라우저 업데이트하기 </a>
    </video>
    ```
- **iframe**
    - html문서안에 또다른 html문서나 Content를 Embed할때 사용
    - ```<iframe src="https://edu.goorm.io" frameborder="0"> </iframe>```
    - 직접 작성할일은 거의 없다.
        - ex:) 유튜브영상,트위터를 share할때 사용