<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="imageboardWriteForm" method="post" enctype="multipart/form-data" action="/miniproject/imageboard/imageboardWrite.do">
	<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<th>숙소 이름</th>
				<td><input type="text" name="imageId" id="imageId" size="50"></td>
			</tr>
			<tr>
				<th>숙소 위치</th>
				<td><input type="text" name="imageName" id="imageName" size="50"></td>
			</tr>
			<tr>
				<th colspan="2" align="center">
				<input type="button" id="imageBtn" value="불러오기"> 
				</th>
			</tr>
	</table>
</form>
</body>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$('#imageBtn').on('click' , function(){
		$.ajax({
			type : 'get' ,
			url : '/springProject/imageboard/imageboardData',
			dataType : 'json',
			success : function(data){
				/* $.each(data['list'], function(key, value){
					
				} */
				alert(JSON.stringify(data));
			},
			error : function(){
				alert('sds');
			}
		});
	});
	
</script>
</html>