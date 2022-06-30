<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!-- '/'추가시 경로를 못잡아 줘서 상대경로로 설정 -->
<%@ include file="layout/header.jsp"%>

<div class="container" style="margin-bottom: 2">
	<c:forEach var="board" items="${boards.content }">
		<!-- 페이징을 해줘서 이렇게 받아야 함 그냥 받으면 boards로 받아도됨-->
		<div class="card m-2">
			<div class="card-body">
				<h4 class="card-title">${board.title}</h4>
				<a href="/board/${board.id }" class="btn btn-primary">싱세 보기</a>
			</div>
		</div>
	</c:forEach>
	<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${boards.first }">
				<li class="page-item disabled"><a class="page-link " href="?page=${boards.number -1 }">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item "><a class="page-link" href="?page=${boards.number -1 }">Previous</a></li>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${boards.last }">
				<li class="page-item disabled"><a class="page-link" href="?page=${boards.number +1 }">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item "><a class="page-link" href="?page=${boards.number +1 }">Next</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>

<%@ include file="layout/footer.jsp"%>


