## Table
>데이터를 담은 표를 만들때 사용
```CSS
<table>
    <tr>
        <th> </th>
        <td> </td>
    </tr>
</table>
```
- ```<table> </talbe>```(table)
- ```<tr> </tr>```(table row)
- ```<th> </th>```(table header)
- ```<td> </td>```(table data)

- **시맨틱하게 마크업**
    - ```<thead> </thead>```
    - ```<tbody> </tbody>```
    - ```<tfoot> </tfoot>```
        - 총합,최종결론부분에 해당되는 테이블 Row에 써주자
- **rowspan="숫자"**
    - 행 병합
- **colspan="숫자"**
    - 열 병합
- **scope="row|col"**
    - ```<th>```에만 쓸수있는 속성
    - 가로줄에 헤더인지 세로줄에 헤더인지 명시