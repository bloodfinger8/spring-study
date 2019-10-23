<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- <link rel="stylesheet" href="../css/login.css"> -->
	<form name="loginForm" id="loginForm" method="post" action="/springProject/member/login">
		 <table cellspacing="0" cellpadding="5">
			<tr>
				<td>
					<input type="text" id="loginId" name="id" placeholder="ID">
					<div id="loginIdDiv"></div>
				</td>
			</tr>
			<tr>
				<td>
					<input type="password" id="loginPwd" name="pwd" placeholder="PASSWORD">
					<div id="loginPwdDiv"></div>
				</td>
			</tr>
			<tr>
				<th colspan="2" align="center">
				<input type="button" id="loginBtn" value="로그인">
				<input type="button" value="회원가입" onclick="location.href='/springProject/member/writeForm'">
				</th>
			</tr>
		</table>
		<br>
		<div id="loginResultDiv" style="text-align: center;"></div>
	</form>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/member.js" ></script>

