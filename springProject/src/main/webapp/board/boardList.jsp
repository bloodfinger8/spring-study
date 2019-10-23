<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="../css/boardList.css">

<table border="1"  width="700" frame="hsides" rules="rows" cellspacing="0" cellpadding="15">
			<tr>
				<td>글번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>
			
			<tbody id="inputList">
			</tbody>
			<input type="hidden" id="pgInput" name="pgInput" value="${param.pg}">
			
			<tr>
			<td colspan="5" align="center" id="paging">
			<%-- ${boardPaging.pagingHTML } --%>
			</td> 
			</tr>
	</table>

<%-- <form name="" method="post" action="">	
	<div style=" padding-top:30px; width: 700px; text-align:center; ">
	<input type="hidden" name="pg" value="1">
	<select name="searchOption" id="searchOption">
	    <option value="all">제목+내용</option>
	    <option value="subject">제목</option>
	    <option value="id">글작성자</option>
	</select>
	<input type="text"  name="keyword" value="${keyword }" placeholder="검색어를 입력해주세요">
	<input type="submit" value="검색">
	</div>
</form> --%>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/board.js"></script>
