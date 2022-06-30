<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!-- '/'�߰��� ��θ� ����� �༭ ����η� ���� -->
<%@ include file="../layout/header.jsp"%>
<div class="container" style="margin-bottom: 2">

	<form action=method="post">
		<div class="form-group">
			<label for="title">Title</label> <input type="text" class="form-control" placeholder="Enter title" id="title">
		</div>



		<div class="form-group">
			<label for="content">Content:</label>
			<textarea class="form-control summernote" rows="5" id="content"></textarea>
		</div>


	</form>

	<button id="btn-save" class="btn btn-primary">�۾��� �Ϸ�</button>
</div>

<script>
	$('.summernote').summernote({
		placeholder : '',
		tabsize : 2,
		height : 300
	});
</script>

<script src="/js/board.js"></script>

<%@ include file="../layout/footer.jsp"%>


