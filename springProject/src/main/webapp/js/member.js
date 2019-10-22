/**
 * 
 */
$('#loginBtn').on("click" , function(){
	$('#loginIdDiv').empty();
	$('#loginPwdDiv').empty();
	
	if($('#loginId').val()==''){
		$('#loginIdDiv').html("<span style='color:red; font-size:7px;'>아이디를 입력하시오</span>");
		$('#loginId').focus();
	}else if($('#loginPwd').val()==''){
		$('#loginPwdDiv').html("<span style='color:red; font-size:7px;'>비밀번호를 입력하시오</span>");
		$('#loginPwd').focus();
	}else{
		$.ajax({
			type : 'post',
			url : '/springProject/member/login',
			data : $('#loginForm').serialize(),
			dataType : 'text',
			success : function(data){
				if(data == 'success'){
					$(location).attr("href", "http://localhost:8080/springProject/main/index");
				}else if(data == 'fail'){
					$('#loginResultDiv').html("<span style='color:red; font-size:9px;'>로그인 실패</span>");
				}
			},
			error : function(e){
				console.log(e);
			}
		});
	}
	
});

$('#writeId').focusout(function(){
	$('#checkIdSpan').empty();
	
	if($('#writeId').val()==''){
		$('#checkIdSpan').html("<span style='color:red; font-size:9px;'>아이디를 입력하세요 </span>")
	}else{
		$.ajax({
			type : 'post',
			url : '/springProject/member/checkId',
			data : $('#writeForm').serialize(),
			dataType : 'text',
			success : function(data){
				if(data == 'success'){
					$('#checkIdSpan').html("<span style='color:red; font-size:9px;'>이미 아이디를 존재합니다 </span>")
				}else if(data == 'fail'){
					$('#checkIdSpan').html("<span style='color:blue; font-size:9px;'>사용 가능 아이디 </span>")
				}
			},
			error : function(err){
				console.log(err);
			}
			
		});
	}
});


$('#checkPostBtn').on('click' , function(){
	window.open("/springProject/member/checkPost.jsp","","width=580 height=500 scrollbars=yes ");
});

$(document).on("click","#searchPostBtn",function(){
	$.ajax({
		type : 'post',
		url : '/springProject/member/getZipcodeList',
		data : $('#checkPostForm').serialize(),
		dataType : 'json',
		success : function(data){
			$.each(data['list'], function(key, value){
				$('#jusoTbody').append('<tr>' +
									  '<td><div id="z'+ key +'">'+value.zipcode+'</div></td>' + 
									  '<td colspan="3"><a id="addressA">'+value.sido+" "+
									  		 value.yubmyundong+" "+
									  		 value.ri+" "+
									  		 value.roadname+" "+
									  		 value.buildingname+
									  '</a></td>' + 
									  '</tr>');
			});
		},
		error : function(){
			alert('error');
		}
	});
});

//$(document).on("click","#addressA",function(){
//	opener.document.getElementById('daum_zipcode').value = $('#').val();
//	opener.document.getElementById('daum_addr1').value = 'sd';
//	window.close();
//	opener.document.getElementById('daum_addr2').focus();
//});
//function checkPostClose(zipcode,address){
////	opener.document.getElementById('daum_zipcode').value = zipcode;
////	opener.document.getElementById('daum_addr1').value = address;
////	window.close();
////	opener.document.getElementById('daum_addr2').focus();
//	
	
//}

//function checkWrite() { //유효성 검사 
//		if (document.writeForm.name.value == "") {
//			alert("이름 입력하시오");
//		}else if (document.writeForm.id.value == "") {
//			alert("아이디 입력하시오");
//		}else if (document.writeForm.pwd.value == "") {
//			alert("비밀번호를 입력하시오");
//		}else if (document.writeForm.repwd.value == "") {
//			alert("비밀번호 재확인을 입력하시오");
//		}else if((document.writeForm.pwd.value != document.writeForm.repwd.value)){
//			alert("비밀번호 불일치");
//		}else if(document.writeForm.check.value != document.writeForm.id.value){
//			alert("중복체크 하세요");
//		}else{
//			document.writeForm.submit();
//		}
//}
//
//function checkIdClose(id){
//	//1.데이터전달 
//	opener.writeForm.id.value = id;
//	opener.writeForm.check.value = id; //만약에 중복체크를 하고 아이디를 다른걸로 변경했을때를 위해
//	//2.창닫아버리기
//	window.close();
//	//3.다음창(비밀번호)에 포커스 깜빡깜빡
//	opener.writeForm.pwd.focus();
//}
//
//
//function checkGender(){
//	var sid = document.modifyForm.gendercheck.value;
//}
//
//

//
//
//function checkModify(){
//	if (document.modifyForm.id.value == ""){ 
//		alert("이름을 입력하시오");
//	}
//	else if (document.modifyForm.pwd.value == ""){
//		alert("비밀번호 입력하시오");
//	}
//	else if ((document.modifyForm.pwd.value != document.modifyForm.repwd.value)){
//		alert("비밀번호 불일치 합니다.");
//	}
//	else {
//		document.modifyForm.submit();
//		
//	}
//}
//
//
