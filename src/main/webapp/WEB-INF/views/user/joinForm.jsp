<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!-- '/'�߰��� ��θ� ����� �༭ ����η� ���� -->
<%@ include file="../layout/header.jsp"%>
<div class="container" style="margin-bottom: 2">
	<form>
		<div class="form-group">
			<label for="username">username:</label> <input type="text" class="form-control" placeholder="username" id="username">
		</div>

		<div class="form-group">
			<label for="email">Email address:</label> <input type="email" class="form-control" placeholder="Enter email" id="email">
		</div>

		<div class="form-group">
			<label for="password">Password:</label> <input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>

		
	</form>
	
	<button id="btn-save" class="btn btn-primary">ȸ������ �Ϸ�</button>

</div>

<script src="/blog/js/user.js"></script>

<%@ include file="../layout/footer.jsp"%>

