<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>삭제 할 아이디 입력  <input type="text" id="deleteId" name="id"> <input type="button" id="deleteBtn" value="검색"> </div>
	<div id="deleteDiv"></div>
</body>


<script  src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">

$(document).on("click" , "#deleteBtn", function(){
	if($('#deleteId').val()==''){
		$('#deleteDiv').html('<span style="color:red; font-size:7px;">삭제할 아이디를 입력해주세요</span>');
		$('#deleteId').focus();
	}else{
		var con= confirm( '삭제하시겠습니까?' );
		if(con){
			$.ajax({
				type : "POST" ,
				url : '/chapter06_SpringMaven/user/userDelete',
				data : {'id' : $('#deleteId').val()},
				success : function(){
					alert('삭제 완료');
					$(location).attr("href", "http://localhost:8080/chapter06_SpringMaven/main/index.do");
				}
			});
		}else{
			$('#deleteId').val('');
		}
	}
	
});

</script>
</html>