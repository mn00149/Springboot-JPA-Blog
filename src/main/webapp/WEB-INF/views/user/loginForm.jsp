<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!-- '/'추가시 경로를 못잡아 줘서 상대경로로 설정 -->
<%@ include file="../layout/header.jsp"%>
<div class="container" style="margin-bottom: 2">
	<form action="/auth/loginProc" method="post">
		<div class="form-group">
			<label for="username">username:</label> 
			<input name="username" type="text" class="form-control" placeholder="username" id="username">
		</div>
		
		
		
		<div class="form-group">
			<label for="password">Password:</label> 
			<input name="password" type="password" class="form-control" placeholder="Enter password" id="password">
		</div>

		<button id="btn-login" class="btn btn-primary">로그인</button>
	</form>

</div>


<!-- <script src="/js/user.js"></script> -->
<%@ include file="../layout/footer.jsp"%>


