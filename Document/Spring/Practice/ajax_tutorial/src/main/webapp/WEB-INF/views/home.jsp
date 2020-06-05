<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!-- 
create table people(
  id varchar2(10) primary key,
  name varchar2(20),
  job varchar2(20),
  address varchar2(40),
  bloodtype varchar2(2)
);
 -->
 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>데이터 베이스 연동</title>

<style type="text/css">
    form{width:500px; margin:10px auto;}
    
    ul{padding:0; margin:0; list-style:none;}
    ul li{padding:0; margin:0 0 10px 0;}
    
    label{width:150px; float:left;}
    
    table {border:1px solid gray; width:500px; margin:0 auto; border-collapse: collapse;}
    td{border:1px solid gray;}
</style>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>


<script type = "text/javascript">
//목록
function selectData()
{
   $('#output').empty(); //table내부 내용을 제거(초기화)
   
   $.ajax({
      url:'/ajax/getPeopleJSON.do',
      type:'POST',
      dataType:"json", //서버에서 보내줄 데이터 타입
      contentType: 'application/x-www-form-urlencoded; charset=utf-8',
      success:function(data)
      {
               //people vo 5개  ㅡㅡㅡㅡㅡ>item               
    	  $.each(data, function(index, item){
    			         var output = '';
    		            output += '<tr>';
    		            output += '<td>' + item.id + '</td>';
    		            output += '<td>' + item.name + '</td>';
    		            output += '<td>' + item.job + '</td>';
    		            output += '<td>' + item.address + '</td>';
    		            output += '<td>' + item.bloodtype + '</td>';
    		            output += '<td> <a href="/ajax/selectPeople.do" class="update_dataForm" id='+ item.id + '>수정</a>';
    		            output += ' ';
    		            output += '<a href="/ajax/deletePeople.do" class="delete_data" id=' + item.id + '>삭제</a></td>';
    		            output += '</tr>';        
    		            console.log("output:" + output);
    		            $('#output').append(output);
    		         });
    		      },
      error:function()
      {
         alert("ajax통신 실패!!!");
      }
   });
}


$(document).ready(function()
{                  //정적
   $('#input_data').click(function(event)
   {                           //직렬화
      var params = $("#insert_form").serialize();
      alert(params);
      jQuery.ajax
      ({
         url : '/ajax/insertPeople.do',
         type : 'POST',
         data : params, //서버로 보낼 데이터
         contentType : 'application/x-www-form-urlencoded; charset=utf-8',
         dataType : "json", //서버에서 보내줄 데이터 타입
         success:function (retVal)
         {
            if(retVal.res == "OK")
            {   //데이타 성공일때 이벤트 작성
               selectData();
               //초기화
               $('#id').val('');
               $('#name').val('');
               $('#job').val('');
               $('#address').val('');
               $('#bloodtype').val('');
            }
            else
               {
                  alert("Insert Fail!!!");
               }
         },
         error:function()
         {
            alert("ajax 통신 실패!!!");
         }      
         
      });
      //기본 이벤트 제거
      event.preventDefault();

   });


   $(document).on('click', '.update_data', function(event)
   {               //정적
    	  var params = $("#update_form").serialize();
          alert(params);
	jQuery.ajax({
		url: '/ajax/updatePeople.do',
		type: 'POST',
		data: params,
		dateType:"json",
		contentType: 'application/x-www-form-urlencoded; charset=utf-8',
		success: function(retVal){
			 if(retVal.res == "OK"){
				 selectData();
			 }else {
				 alert("Insert Fail!!!");
			 }
		},
		error:function()
	      {
	         alert("ajax통신 실패!!!");
	      }
	});	
	//기본 이벤트 제거
	   event.preventDefault();
	
		});
  



   

$(document).on('click', '.update_dataForm', function(event)
{
	jQuery.ajax({
		url : '/ajax/selectPeople.do',
		type: 'POST',
		data : {'id' : $(this).attr("id")},
	 	dataType:"json", //서버에서 보내줄 데이터 타입
     	contentType: 'application/x-www-form-urlencoded; charset=utf-8',
     	success:function(data){
     		var output='';
     		output += '<tr>';
            output += '<td><input type="hidden" name="id" value="'+data.id+'"/>' + data.id + '</td>';
            output += '<td><input type="text" name="name" id="name" /></td>';
            output += '<td><input type="text" name="job" id="job" /></td>';
            output += '<td><input type="text" name="address" id="address" /></td>';
            output += '<td><input type="text" name="bloodtype" id="bloodtype"/></td>';
            output += '<td> <a href="" class="update_data" id='+ data.id + '>수정</a>';
            output += ' ';
            output += '<a href="/ajax/deletePeople.do" class="delete_data" id=' + data.id + '>삭제</a></td>';
            output += '</tr>';        
            console.log("output:" + output);
            $('#output').html(output);
     		
     	},
     	error:function()
        {
           alert("ajax통신 실패!!!");
        }
		
	});
	   //기본 이벤트 제거
	   event.preventDefault();
	});
	

$(document).on('click', '.delete_data', function(event)
{
   jQuery.ajax
   ({
            //this : 이벤트가 가리키는 요소(삭제링크)
      url : $(this).attr("href"),
      type : 'GET',
      data : {'id' : $(this).attr("id")},
      contentType : 'application/x-www-form-urlencoded; charset=ut-8',
      dataType : 'json',
      success : function (retVal) //데이타 성공일때 이벤트 작성
      {
         if(retVal.res == "OK")
         {
            selectData();
         }
         else
         {
            alert("Insert Fail!!!");
         }   
      },
      error:function()
      {
         alert("ajax통신 실패!!!");
      }
   });
   //기본 이벤트 제거
   event.preventDefault();
});
   selectData();
});






   </script>
   
   
   
   
</head>
<body>
   <form id = "insert_form" method = "post">
      <fieldset>
         <legend>데이터추가</legend>
         <ul>
         <li>
         <label for = "id">아이디</label>
         <input type ="text" name = "id" id = "id">
         </li>
         <li>
         <label for = "name">이름</label>
         <input type = "text" name = "name" id = "name">
         </li>
         <li>
         <label for = "job">직업</label>
         <input type = "text" name = "job" id = "job">
         </li>
         <li>
         <label for = "address">주소</label>
         <input type = "text" name = "address" id = "address">
         </li>
         <li>
         <label for = "bloodtype">혈액형</label>
         <input type = "text" name = "bloodtype" id = "bloodtype">
         </li>
         <li>
         <input type= "button" value = "추가" id = "input_data">
         </li>
         </ul>
         
         
         
      </fieldset>
   </form>
   <form id = "update_form" method = "post">
      <table id = "output"></table>
   </form>
</body>
</html>