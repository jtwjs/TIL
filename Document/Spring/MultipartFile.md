## MultipartFile
- SpringFramework에서 제공하고 있는 MultipartFile 클래스와 MultipartHttpServletRequest 클래스를 사용해서 File 업로드 기능을 구현할 수 있다.

- 클라이언트에서 서버로 HTTP 요청을 할 때, "Content-Type"필드의 내용을 "multipart/form-data"로 세팅해서 요청
![multipartFile](https://user-images.githubusercontent.com/60641307/83241456-d319a280-a1d5-11ea-8bc9-88e295964e62.png)


### 사용자 정의 Class 타입을 사용하는 방법

- ```java
    @RequestMapping
    (value = "/upload", method = RequestMethod.POST)

    public String upload(MyCommand cmd){
        MultipartFile file = cmd.getFile();
        ...
    }

    Class MyCommand {
        MultipartFile file;
        ...
    }

  ```

- **요청파라미터 타입을 사용자가 정의한 클래스 타입으로 사용하는 경우**이다.
- 커맨드 객체(Command Object)
    - 요청파라미터로 사용되는 사용자가 정의한 클래스
    - 서버는 클라이언트의 HTTP 요청 메시지에 포함된 파라미터들이 모두 자동으로 사용자가 정의한 클래스의 구조에 맞게 파싱되기 때문에, 결과적으로는 개발자는 하나의 Command Object로 컨트롤 할수 있다.
- 해당 클래스를 정의할 때 File을 받을수 있는 MultipartFile타입에 대한 변수를 클래스 내에 함께 작성해두면 된다.

- 코드: MultipartController.java
    - ```java
        @RestController
        public class MultipartController {
            @RequestMapping(value={"/upload4"}, method = RequestMethod.POST),consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
            public String upload4(MyCommand cmd) trhows IOException {
                MultipartFile file = cmd.getFile();
                
                //파일의 파라미터 이름
                System.out.println(file.getName());
                //파일의 사이즈
                System.out.println(file.getSize());
                //파일의 실제 이름
                System.out.println(file.getOriginalFilename());
                //파일의 실제 내용
                byte[] data = file.getBytes();

                return "success-upload4";// view
            }
        }
      ```


- 코드: MyCommand.java
    - ```java
        public class MyCommand {
            MultipartFile file;

            public MultipartFile getFile() {
                return file;
            }
            public void setFile(MultipartFile file) {
                this.file = file;
            }
        }
      ```