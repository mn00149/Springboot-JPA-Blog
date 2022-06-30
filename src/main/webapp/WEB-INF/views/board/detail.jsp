<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!-- '/'추가시 경로를 못잡아 줘서 상대경로로 설정 -->
<%@ include file="../layout/header.jsp"%>
<div class="container" style="margin-bottom: 2">
	<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
	<c:if test="${board.user.id == principal.user.id }">

		<a href="/board/${board.id }/updateForm"  class="btn btn-warning">수정</a>
	</c:if>

	<c:if test="${board.user.id == principal.user.id }">
		<button id="btn-delete" class="btn btn-danger">삭제</button>
	</c:if>
	<br /> <br />
	<div>
		글번호: <span id="id"><i>${board.id }</i></span> 작성자: <span><i>${board.user.username }</i></span>

	</div>
	<br /> <br />

	<div class="form-group">
		<h3>${board.title }</h3>
	</div>

	<hr>

	<div class="form-group">
		<div>${board.content}</div>
	</div>
	<hr>


</div>



<script src="/js/board.js"></script>

<%@ include file="../layout/footer.jsp"%>


