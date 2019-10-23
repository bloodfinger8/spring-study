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

$('#id').focusout(function(){
	$('#checkIdSpan').empty();
	
	if($('#id').val()==''){
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
					$('#check').val($('#id').val());
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


$(document).on("click" , "#searchPostBtn" , function(){
	if($('#sido').val() =='시도선택')
		alert('시도를 선택하세요');
	else if($('#sido').val()!='세종' && $('#sigungu').val()=='' )
		alert('시군구를 입력하세요');
	else if($('#roadname').val()=='')
		alert('도로명을 입력하세요');
	else{
		$.ajax({
			type : 'post',
			url : '/springProject/member/getZipcodeList',
			data : $('#checkPostForm').serialize(),
			dataType : 'json',
			success : function(data){
				$('table tr:gt(2)').remove();
				
				$.each(data['list'], function(key, value){
					
					var address = value.sido+" "+
								  value.sigungu+" "+
								  value.yubmyundong+" "+
								  value.ri+" "+
								  value.roadname+" "+
								  value.buildingname;
					address = address.replace(/null/g, '');
					
					$('#jusoTbody').append('<tr>' +
										  '<td><div id="z'+ key +'">'+value.zipcode+'</div></td>' + 
										  '<td colspan="3"><a id="addressA">'+
										  		 address+
										  '</a></td>' + 
										  '</tr>');
				});
				
				$('a').click(function(){
					//alert($(this).parent().prev().text());
					$('#daum_zipcode' , opener.document).val($(this).parent().prev().text());
					opener.document.getElementById('daum_addr1').value = $(this).text();
					window.close();
					//$('#daum_addr2').focus();
				});
				
			},
			error : function(){
				alert('error');
			}
		});
	}
});
// 밖으로 빼서 작성해도 가능하다
//$(document).on("click" , "#addressA" , function(){
//	$('#daum_zipcode' , opener.document).val($(this).parent().prev().text());
//	opener.document.getElementById('daum_addr1').value = $(this).text();
//	window.close();
//});



$('#writeBtn').on("click" , function(){
	$('#nameDiv').empty();
	$('#checkIdSpan').empty();
	$('#pwdDiv').empty();
	$('#repwdDiv').empty();
	
	if($('#name').val()=='')
		$('#nameDiv').text('이름을 입력하세요').css('color', 'red').css('font-size','7pt');
	else if($('#id').val()=='')
		$('#checkIdSpan').text('아이디를 입력하세요').css('color', 'red').css('font-size','7pt');
	else if($('#pwd').val()=='')
		$('#pwdDiv').text('비밀번호를 입력하세요').css('color', 'red').css('font-size','7pt');
	else if($('#pwd').val() != $('#repwd').val())
		$('#repwdDiv').text('비밀번호가 일치하지 않습니다').css('color','red').css('font-size','7pt');
	else if($('#id').val() != $('#check').val())
		$('#checkIdSpan').text('중복체크 하세요').css('color','red').css('font-size','7pt');
	else
		$('#writeForm').submit();
});




//function checkGender(){
//	var sid = document.modifyForm.gendercheck.value;
//}
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
