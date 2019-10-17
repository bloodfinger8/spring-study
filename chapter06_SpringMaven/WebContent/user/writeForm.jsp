<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="writeForm" method="post" action="http://localhost:8080/chapter06_SpringMaven/user/write">
	<table  >
		<tr>
			<td width="70" align="center">이름</td>
			<td><input type="text" id="name" name="name"><div class="divName"></div></td>
		</tr>
		<tr>
			<td align="center">아이디</td>
			<td><input type="text" id="id" name="id"><div class="divId"></div></td>
		</tr>
		<tr>
			<td align="center">비밀번호</td>
			<td><input type="text" id="pwd" name="pwd"><div class="divPwd"></div></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="button" class="userBtn" value="등록">
			<input type="reset" class="resetBtn" value="취소"></td>
		</tr>
	</table>
</form>
</body>
<script  src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$('.userBtn').on("click", function(){
		$('.divName').empty();
		$('.divId').empty();
		$('.divPwd').empty();
		
		if($('#name').val() == ''){
			$('.divName').html("<span style='color:red; font-size:7px;'>이름을 입력하시오</span>");
			$('#name').focus();
		}
		else if($('#id').val() == ''){
			$('.divId').html("<span style='color:red; font-size:7px;'>아이디를 입력하시오</span>");
			$('#id').focus();
		}
		else if($('#pwd').val() == ''){
			$('.divPwd').html("<span style='color:red; font-size:7px;'>비밀번호를 입력하시오</span>");
			$('#pwd').focus();
		}
		else {
			//$('.userBtn').submit();
			//본인자리로 다시 옮겨온다
			$.ajax({
				type : 'post',
				url : '/chapter06_SpringMaven/user/write',
				data : $('#writeForm').serialize(),
				success : function(){
					alert('등록 완료');
					//location.href='http://localhost:8080/chapter06_SpringMaven/main/index.do';
				}
			});
		}
	});
	
	$('.resetBtn').on("click",function(){
		$('div').empty();
	});
	
</script>

</html>