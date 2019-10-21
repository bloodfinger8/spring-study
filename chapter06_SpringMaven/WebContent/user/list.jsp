<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/chapter06_SpringMaven/main/index.do"><img src="../image/springimg.png" width="50" height="50"/></a>

<table border="1" cellpadding="5" cellspacing="0">
	<tr>
		<th width="100">이름</th>
		<th width="100">아이디</th>
		<th width="100">비밀번호</th>
	</tr>
	<tbody id="inputDiv"></tbody>
</table>
<br>
<select id="selectBox" name="selectBox">
    <option value="name">이름</option>
    <option value="id">아이디</option>
</select>
<input type="text" id="searchText" name="searchText"><input type="button" id="searchBtn" value="검색">

</body>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//userControoller -> userDervice -> userDAO
	$.ajax({
		type : "post" ,
		url : '/chapter06_SpringMaven/user/getList',
		dataType : 'json' ,
		success : function(data){
			//alert(JSON.stringify(data));
			$.each(data['list'], function(key, value){
				$('#inputDiv').append('<tr>' +
									  '<td>'+value.name+'</td>' + 
									  '<td>'+value.id+'</td>' + 
									  '<td>'+value.pwd+'</td>' + 
									  '</tr>');
			});
		}
	});
});

$('#searchBtn').on("click" ,function(){
	
	if($('#searchText').val()==''){
		//$('.divId').html("<span style='color:red; font-size:7px;'>검색어를 입력하세요</span>");
		alert('dd');
	}else {
		var result ={};
		result['k'] = $('#selectBox option:selected').val();
		result['v'] = $('#searchText').val();
		alert(JSON.stringify(result));
		
		$.ajax({
			type : "post" ,
			url : '/chapter06_SpringMaven/user/search',
			data : JSON.stringify(result),
			dataType : 'json' ,
			contentType:'application/json; charset=utf-8',
			success : function(data){
				$('#inputDiv').empty();
				$.each(data['list'], function(key, value){
					$('#inputDiv').append('<tr>' +
										  '<td>'+value.name+'</td>' + 
										  '<td>'+value.id+'</td>' + 
										  '<td>'+value.pwd+'</td>' + 
										  '</tr>');
				});
			},
			error : function(){
				alert('error');
			}
		}); 
		
	}
	
	
});



</script>
</html>