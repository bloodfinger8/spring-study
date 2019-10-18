<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#mainA:link {
  color: black;
  text-decoration: none;
}
#mainA:visited{
  color: black;
  text-decoration: none;
}
#mainA:hover{
	color: red;
	text-decoration: underline;
	font-weight:bold;
}
#mainA:active {
	color: black; 
	text-decoration: none; 
}

</style>
</head>
<body>
<table>
	<tr>
		<th>메인 화면</th>
	</tr>
	<tr>
		<td><a id="mainA" href="/chapter06_SpringMaven/user/writeForm.do">입력</a></td>
	</tr>
	<tr>
		<td><a id="mainA" href="../user/list">출력</a></td>
	</tr>
	<tr>
		<td><a id="mainA" href="../user/modifyForm">수정</a></td>
	</tr>
	<tr>
		<td><a id="mainA" href="../user/deleteForm">삭제</a></td>
	</tr>
</table>
</body>
</html>