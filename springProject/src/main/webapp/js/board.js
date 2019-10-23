/**
 * 
 */
$('#boardWriteBtn').on("click" , function(){
	if($('#subject').val() == ''){
	}else if($('#content').val() == ''){
	}else{
		$.ajax({
			type : 'post',
			url : '/springProject/board/boardWrite',
			data : $('#boardWriteForm').serialize(),
			dataType : 'text',
			success : function(){
				alert("글쓰기 성공");
			},
			error : function(err) {
				console.log(err);
			}
		});
	}
});

$(document).ready(function(){
	$.ajax({
		type : 'post' ,
		url : '/springProject/board/writeAll',
		data : 'pg='+$('#pgInput').val(),
		dataType : 'json',
		success : function(data){
			$.each(data['list'], function(key, value){
				$('#inputList').append('<tr>' +
									  '<td>'+value.seq+'</td>' + 
									  '<td>'+value.content+'</td>' + 
									  '<td>'+value.id+'</td>' + 
									  '<td>'+value.logtime+'</td>' +
									  '<td>'+value.hit+'</td>'+
									  '</tr>');
			});
		},
		error : function(err){
			console.log(err);
			alert('dd3');
		}
	});
	
});




//function isLogin(seq, pg){
//	if("${memId}"=="")
//		alert("먼저 로그인하세요");
//	else
//		location.href="/miniproject/board/boardView.do?seq="+seq+"&pg="+pg;		
//}
//
//window.onload=function(){ //선택된 값 유지
//	if('${searchOption}'=='subject' || '${searchOption}'=='id'||'${searchOption}'=='all')
//		document.getElementById('searchOption').value = '${searchOption}';
//}
//
//function boardSearch(pg){
//	location.href="/miniproject/board/boardSearch.do?pg="+pg
//			+"&searchOption=${searchOption}"
//			+"&keyword=${keyword}";
//}

//function checkBoard(){
//	if (document.getElementById("subject").value == ""){ 
//		alert("제목을 입력하시오");
//		document.getElementById("content").focus();
//	}
//	else if (document.getElementById("content").value == ""){
//		alert("비밀번호 입력하시오");
//	}
//	else {
//		document.forms[0].submit();
//	}
//}
//
//function isLogin(memId,seq,pg){
//	if(memId==""){
//		alert("로그인 먼저 해주세요");
//	}else{
//		location.href="/miniproject/board/boardView.do?seq="+seq+"&pg="+pg;
//	}
//}
//
//function searchList(){
//	if(document.getElementById("textContent").value==""){
//		alert("검색어를 입력해주세요");
//	}else{ 
//		var textContent = document.getElementById("textContent").value;
//		var selected = document.boardListForm.selected.value;
//		location.href="/miniproject/board/boardList.do?pg=1&textContent="+textContent+"&selected="+selected;
//	}
//}
//
