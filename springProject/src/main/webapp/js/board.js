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
				$(location).attr("href", "http://localhost:8080/springProject/board/boardList?seq=1");
			},
			error : function(err) {
				console.log(err);
			}
		});
	}
});


//게시글 수정
$('#boardModifyBtn').on("click" , function(){
	if($('#modifySubject').val() == '' ){
	}else if($('#modifyContent').val() == ''){
	}else{
		alert($('#boardModifyForm').serialize());
		$.ajax({
			type : 'post',
			url : '/springProject/board/boardModify',
			data : $('#boardModifyForm').serialize(),
			success : function(){
				alert('수정완료');
				$(location).attr("href", "http://localhost:8080/springProject/board/boardList?seq=1");
			},
			error : function(err){
				console.log(err);
			}
		});
	}
});

//검색
$('#boardSearchBtn').on("click" , function(event , str){
	if(str != 'trigger'){
		$('input[name=pg]').val(1);
	}
	
	if($('input[name=keyword]').val() == ''){
		alert('검색단어 넣으세요');
	}else{
		$.ajax({
			type : 'post',
			url : '/springProject/board/boardSearch',
			data : $('#boardSearchForm').serialize(),
			dataType : 'json',
			success : function(data){
				alert(JSON.stringify(data));
				
				$('#boardListTable tr:gt(0)').remove();
				
				$.each(data.list, function(index,items){
					$('<tr/>').append($('<td/>',{
						align: 'center',
						text: items.seq
					})).append($('<td/>',{
						
						}).append($('<a/>',{
							href: 'javascript:void(0)',
							text: items.subject,
							id: 'subjectA',
							class: items.seq+''
						
					}))).append($('<td/>',{
						align: 'center',
						text: items.id
					})).append($('<td/>',{
						align: 'center',
						text: items.logtime
					})).append($('<td/>',{
						align: 'center',
						text: items.hit
					})).appendTo($('#boardListTable'));
				});
				
				//검색될 결과의 페이징 처리
				$('#boardPaging').html(data.boardPaging.pagingHTML);
				
			},
			error : function(err){
				console.log(err);
			}
		});
	}
});

//답글
$('#boardReplyBtn').on('click' , function(){
	if($('#boardReplySubject').val() == '' ){
		alert('제목을 입력하세요');
	}else if($('#boardReplyCotent').val() == ''){
		alert('내용을 입력하세요');
	}else{
		alert($('#boardReplyForm').serialize());
		$.ajax({
			type : 'post',
			url : '/springProject/board/boardReply',
			data : $('#boardReplyForm').serialize(),
			success : function(data){
				
				alert('답글 등록');
				
				
			},
			error : function(err){
				console.log(err);
			}
		
		});
	}
});
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

//BoardPaging -makeSearchPagingHTML 메소드의 함수
function boardSearch(pg){
//	location.href="/springProject/board/boardSearch?pg="+pg
//			+"&searchOption=${searchOption}"
//			+"&keyword=${keyword}";
	$('input[name=pg]').val(pg);
	$('#boardSearchBtn').trigger('click','trigger');
}

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
