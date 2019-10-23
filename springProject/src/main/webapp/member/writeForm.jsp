<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<form name="writeForm" id="writeForm" method="post" action="/springProject/member/write">
		<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<th width="80">이름</th>
				<td width="320"><input type="text" id="name" name="name"><div id="nameDiv"></div></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" id="id" name="id">
				<span id="checkIdSpan"></span>
				<input type="hidden" id="check" name="check" value=""> 
				<!-- hidden은 중복체크를 위해 존재한다  -->
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" id="pwd" name="pwd"><div id="pwdDiv"></div></td>
			</tr>
			<tr>
				<th>재확인</th>
				<td><input type="password" id="repwd" name="repwd"><div id="repwdDiv"></div></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><input type="radio" name="gender" value="0" checked>남
					<input type="radio" name="gender" value="1">여</td>
			</tr>

			<tr>
				<th>이메일</th>
				<td><input type="text" name="email1" size="12"> @ <input type="text"
					list="browsers" placeholder="직접입력" name="email2"> 
					<datalist id="browsers">
						<option value="gmail.com">
						<option value="naver.com">
						<option value="hanmail.com">
					</datalist></td>
			</tr>

			<tr>
				<th>핸드폰</th>
				<td><select name="tel1">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="018">018</option>
				</select> -<input type="text" name="tel2" size="4"> -<input
					type="text" name="tel3" size="4"></td>
			</tr>

			<tr>
				<th rowspan="3">주소</th>
				<td><input type="text" name="zipcode" id="daum_zipcode"  size="10" readonly> 
				<input type="button" id="checkPostBtn" value="우편번호검색" ></td>
			</tr>
			<tr>
				<td><input type="text" name="addr1" id="daum_addr1" placeholder="주소" size="40" readonly></td>
			</tr>
			<tr>
				<td><input type="text" name="addr2" id="daum_addr2" placeholder="상세주소" size="40"></td>
			</tr>
 
			<tr>
				<th colspan="2" align="center">
				<input type="button" id="writeBtn" value="회원가입"> 
				<input type="reset" value="다시작성">
				</th>
			</tr>
		</table>
	</form>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/member.js" type="text/javascript"> </script>
