<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!-- '/'�߰��� ��θ� ����� �༭ ����η� ���� -->
<%@ include file="../layout/header.jsp"%>
<div class="container" style="margin-bottom: 2">
	<form action="/action_page.php">
		<div class="form-group">
			<label for="username">username:</label> <input type="text" class="form-control" placeholder="username" id="username">
		</div>
		
		
		
		<div class="form-group">
			<label for="password">Password:</label> <input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		<div class="form-group form-check">
			<label class="form-check-label"> <input class="form-check-input" type="checkbox"> Remember me
			</label>
		</div>
		<button type="submit" class="btn btn-primary">�α���</button>
	</form>

</div>

<%@ include file="../layout/footer.jsp"%>


