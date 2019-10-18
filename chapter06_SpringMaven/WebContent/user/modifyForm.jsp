<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="modifyForm" method="post" action="http://localhost:8080/chapter06_SpringMaven/user/write">

	<div>수정 할 아이디 입력  <input type="text" id="checkId" name="id"> <input type="button" id="searchBtn" value="검색"> </div>
	<div id="checkDiv"></div>
	<div id="inputDiv"></div>
	
	<br><br>
	<div id="tableDiv"></div>
</form>
</body>

<script  src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	
$('#searchBtn').on("click", function(){
	$('#checkDiv').empty();
	$('#checkId').empty();
	
	if($('#checkId').val() == ''){
		$('#checkDiv').html("<span style='color:red; font-size:7px;'>수정할 아이디를 입력해주세요</span>");
		$('#checkId').focus();
	}else {
		$.ajax({
			type : "GET" ,
			url : '/chapter06_SpringMaven/user/getUser',
			data : {'id' : $('#checkId').val()},
			dataType : 'json' ,
			success : function(data){
				if(data.userDTO==null){
					$('#checkDiv').html("<span style='color:blue; font-size:7px;'>검색한 아이디가 없습니다</span>");
				}else {
				$('#tableDiv').html('<table id="searchTable">'+
						'<tr>'+
						'<td width="70" align="center">이름</td>'+
						'<td><input type="text" id="name" name="name"><div class="divName"></div></td>'+
					'</tr>'+
					'<tr>'+
						'<td align="center">아이디</td>'+
						'<td><input type="text" id="id" readonly></td>'+
					'</tr>'+
					'<tr>'+
						'<td align="center">비밀번호</td>'+
						'<td><input type="text" id="pwd" name="pwd"><div class="divPwd"></div></td>'+
					'</tr>'+
					'<tr>'+
						'<td colspan="2" align="center">'+
						'<input type="button" id="modifyBtn" value="수정">'+
						'<input type="reset" id="resetBtn" value="취소">'+
						'</td>'+
					'</tr>'+
				'</table> ');
				
				$('#name').val(data.userDTO.name);
				$('#id').val(data.userDTO.id);
				$('#pwd').val(data.userDTO.pwd);
				}
			},
			error : function(e){
				alert(e);
			}
		});
	
	}
	
});

$(document).on("click" ,'#modifyBtn', function(){
	if($('#name').val() == ''){
		$('.divName').append("<span style='color:red; font-size:7px;'>수정할 아이디를 입력해주세요</span>");
		$('.divName').focus();
	}else if($('#pwd').val() == ''){
		$('.divPwd').append("<span style='color:red; font-size:7px;'>수정할 비밀번호를 입력해주세요</span>");
		$('.divPwd').focus();
	}else{
		$.ajax({
			type : "post" ,
			url : '/chapter06_SpringMaven/user/getModify',
			data : $('#modifyForm').serialize(),
			success : function(){
				alert('수정완료');
				$(location).attr("href", "http://localhost:8080/chapter06_SpringMaven/main/index.do");
			},
			error : function(){
				alert("와이");
			}
		});
	}
});
</script>



</html>