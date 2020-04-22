<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="include/header.jsp"%>
<style>
.container {
	height: 500px;
}

.btn {
	float: right;
	margin-bottom : 20px;
}
.detail:hover td {
	background : lightgrey;
}
</style>
<script>
	$(function(){
		$("button").click(function() {
			location.href = "insert";
		})
		$(".detail").click(function() {
			var no = $(this).attr("data-no");
			location.href = "detail?no="+no;
		})
	})
</script>
<div class="container">
	<div class="row">
		<c:if test="${list==null}">
			<button class="btn btn-default">새 프로젝트 등록</button>
		</c:if>
		<c:if test="${list!=null}">
			<button class="btn btn-default">새 프로젝트 등록</button>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>프로젝트 이름</th>
						<th>시작날짜</th>
						<th>종료날짜</th>
						<th>상태</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${list}">
						<tr class="detail" data-no="${item.no}">
							<td>${item.name}</td>
							<td><fmt:formatDate value="${item.startDate}"
									pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${item.endDate}"
									pattern="yyyy-MM-dd" /></td>
							<td>${item.status eq 'r'?'준비':item.status eq 'e'?'진행중':item.status eq 'f'?'종료':'보류'}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</div>
<%@ include file="include/footer.jsp"%>