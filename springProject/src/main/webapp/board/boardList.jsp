<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="../css/boardList.css">

<table id="boardListTable" border="1"  width="600" frame="hsides" rules="rows" cellspacing="0" cellpadding="5">
			<tr>
				<td>글번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>
			
			<tbody id="inputList">
			</tbody>
			
			<!-- <tr>
				<td colspan="5" align="center" id="boardPaging">ㅇ</td> 
			</tr> -->
	</table>
	<div id="boardPaging" style="width:660px; text-align: center;"></div>
<input type="hidden" id="pgInput" name="pgInput" value="${pg}">
			
<form name="boardSearchForm" id="boardSearchForm">	
	<div style=" padding-top:30px; width: 700px; text-align:center; ">
		<input type="hidden" name="pg" value="1">
		<select name="searchOption" id="searchOption">
		    <option value="all">제목+내용</option>
		    <option value="subject">제목</option>
		    <option value="id">글작성자</option>
		</select>
		<input type="text"  name="keyword" value="${keyword }" placeholder="검색어를 입력해주세요">
		<input type="button" id="boardSearchBtn" value="검색2">
	</div>
</form> 

<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- <script type="text/javascript" src="../js/board.js"></script> -->
<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
		type : 'post' ,
		url : '/springProject/board/writeAll',
		data : 'pg='+$('#pgInput').val(),
		dataType : 'json',
		success : function(data){
			alert(JSON.stringify(data));
			$.each(data['list'], function(key, value){
				 /* $('#inputList').append('<tr>' +
								  	  '<td>'+value.seq+'</td>' + 
									  '<td><a id="subjectA">'+value.subject+'</a></td>' + 
									  '<td>'+value.id+'</td>' + 
									  '<td>'+value.logtime+'</td>' +
									  '<td>'+value.hit+'</td>'+
									  '</tr>');  */
				$('<tr/>').append($('<td/>',{
					align: 'center',
					text : value.seq
				})).append($('<td/>',{
					}).append($('<a/>',{
							href : 'javascript:void(0)',
							id : 'subjectA',
							text : value.subject,
							class : value.seq+""
				})) ).append($('<td/>',{
					align: 'center',
					text : value.id
				})).append($('<td/>',{
					align: 'center',
					text : value.logtime
				})).append($('<td/>',{
					align: 'center',
					text : value.hit
				})).appendTo($('#inputList'));
									  
				//답글
				for(i=0; i<value.lev; i++){
					$('.' + value.seq).before('&emsp;');
				}
				if(value.lev != 0){
					//$('.' + value.seq).prepend('<img id="theImg" src="../image/dapgle.gif" />')
					$('.' + value.seq).before($('<img/>',{
						src : '../image/dapgle.gif'
					}));
					$('.' + value.seq).parent().prev().css('visibility','hidden'); //글번호 숨기기
				}
			
			});
			//페이징 처리
			$('#boardPaging').html(data.boardPaging.pagingHTML);
			
			//로그인 여부
			$('#boardListTable').on('click' ,'#subjectA' , function(){
				if(data.memId == null){
					alert('로그인 해라');
				}else{
					var seq = $(this).parent().prev().text();
					//var seq = $(this).attr('class'); 이렇게 사용해도 된다
					$(location).attr("href", "http://localhost:8080/springProject/board/boardView?seq="+seq+"&pg="+$('#pgInput').val());
				}
			});
			
			
		},
		error : function(err){
			console.log(err);
		}
	});
	
});
</script>
