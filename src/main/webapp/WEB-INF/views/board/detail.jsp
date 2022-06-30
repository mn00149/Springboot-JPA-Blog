<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!-- '/'�߰��� ��θ� ����� �༭ ����η� ���� -->
<%@ include file="../layout/header.jsp"%>
<div class="container" style="margin-bottom: 2">
	<button class="btn btn-secondary" onclick="history.back()">���ư���</button>
	<c:if test="${board.user.id == principal.user.id }">

		<a href="/board/${board.id }/updateForm"  class="btn btn-warning">����</a>
	</c:if>

	<c:if test="${board.user.id == principal.user.id }">
		<button id="btn-delete" class="btn btn-danger">����</button>
	</c:if>
	<br /> <br />
	<div>
		�۹�ȣ: <span id="id"><i>${board.id }</i></span> �ۼ���: <span><i>${board.user.username }</i></span>

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

