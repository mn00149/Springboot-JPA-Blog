<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!-- '/'�߰��� ��θ� ����� �༭ ����η� ���� -->
<%@ include file="../layout/header.jsp"%>
<div class="container" style="margin-bottom: 2">
	<form>
		<input type="hidden" id="id" value="${principal.user.id }" />
		<div class="form-group">
			<label for="username">username:</label> <input value="${principal.user.username }" type="text" class="form-control" placeholder="username" id="username" readonly>
		</div>

		<div class="form-group">
			<label for="email">Email address:</label> <input value="${principal.user.email }" type="email" class="form-control" placeholder="Enter email" id="email">
		</div>

		<div class="form-group">
			<label for="password">Password:</label> <input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>


	</form>

	<button id="btn-update" class="btn btn-primary">ȸ������ �Ϸ�</button>

</div>

<script src="/js/user.js"></script>

<%@ include file="../layout/footer.jsp"%>


