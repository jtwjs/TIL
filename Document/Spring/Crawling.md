## Crawling
- = Scraping 스크래이핑
- 웹페이지를 그대로 가져와서 데이터를 추출해 내는 행위
### Web Crawler
- 조직적, 자동화된 방법으로 WWW을 탐색하는 컴퓨터 프로그램
    - = (앤트(ants), 자동인덱서(automatic indexer), 봇(bots), 웜(worms), 웹 스파이더(web spider), 웹 로봇(web robot))
- 웹 크롤러가 하는 작업을 웹 크롤링(web crawling) 혹은 스파이더링(spidering)이라 부른다.
- 검색 엔진과 같은 여러 사이트에서는 **데이터의 최신 상태 유지를 위해 웹 크롤링**한다.
- 웹 크롤러는 대체로 **방문한 사이트의 모든 페이지의 복사본을 생성**하는데 사용됨
    - 이렇게 생성된 페이지를 보다 빠른 검색을 위해 인덱싱한다.
- 링크 체크나 HTML 코드 검증과 같은 웹사이트의 자동 유지 관리 작업을 위해 사용되기도 함
- 웹 크롤러는 봇이나 소프트웨어 에이전트의 한 형태
- 웹 크롤러는 대게 **시드(seeds)** 라고 불리는 URL 리스트에서부터 시작됨
    - 페이지의 모든 하이퍼링크를 인식하여 URL 리스트를 갱신
    - 갱신된 URL 리스트는 재귀적으로 다시 방문한다.

### Spring Jsoup

- pom.xml
    - ```xml
        <dependency>
            <groupId>org.jsoup</groupId>
            <artifactId>jsoup</artifactId>
            <version>1.8.3</version>
        </dependency>
      ```

```java
    String URL = "https://weather.naver.com/rgn/cityWetrMain.nhn";
    Document doc = Jsoup.connect(URL).get();
    Element elem = doc.select(".tbl_weather tbody>tr:nth-child(1)");
    String[] str = elem.text().split(" ");
    Elements elem2 = doc.select(".tbl_weather tbody>tr:nth-child(1) img");
```
- ```Document doc = Jsoup.connect(URL).get()```
    - 지정한 url에서 가져온 html 태그를 모두 가져온다.
- ```Element elem = doc.select("~")```
    - 지정한 url에서 가져온 html태그 중에 원하는 태그를 가져옴
- ```String str = elem.text(); ```
    - elem 안에 담긴 html 태그에서 문자열을 모두 가져오는 메소드
    - 태그가 아니라 단순히 문자열만 가져옴