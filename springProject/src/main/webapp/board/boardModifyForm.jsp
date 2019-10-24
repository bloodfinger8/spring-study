<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>글수정</h3>
<form id="boardModifyForm" name="boardModifyForm" method="post" action="/miniproject/board/boardModify.do">
		<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<th>제목</th>
				<td><input type="text" name="modifySubject" id="modifySubject" size="50" value="${boardDTO.subject}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="modifyContent" id="modifyContent" rows="13" cols="50">${boardDTO.content}</textarea></td>
			</tr>
			<tr>
				<th colspan="2" align="center">
				<input type="button" id="boardModifyBtn" value="글수정"> 
				<input type="reset" value="다시작성">
				</th>
			</tr>
		</table>
		<input type="hidden" name="pg" value="${pg}">
		<input type="hidden" name="seq" value="${seq}">
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/board.js" type="text/javascript"> </script>
