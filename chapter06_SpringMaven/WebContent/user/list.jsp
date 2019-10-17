<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" cellpadding="5" cellspacing="0">
	<tr>
		<th width="100">이름</th>
		<th width="100">아이디</th>
		<th width="100">비밀번호</th>
	</tr>
	<tbody id="inputDiv"></tbody>
</table>
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
</script>
</html>