<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3><img src="../image/springimg.png" width="60" height="60" onclick="location.href='/springProject/main/index'">
Spring mvc project</h3>

<font size="2">

<c:if test="${memId != null }">
	<a href="/springProject/board/boardWriteForm">글쓰기</a>&emsp;
		<c:if test="${memId == 'admin'}">
			<a href="/springProject/imageboard/imageboardWriteForm">이미지등록</a>&emsp;
		</c:if>
	<a href="/springProject/imageboard/imageboardList?pg=1">이미지게시판</a>&emsp;
</c:if>
<a href="/springProject/board/boardList?pg=1">게시판</a>&emsp;

</font>