<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="include/header.jsp"%>
<script>
	$(function() {
		$("#mod").click(function() {
			location.href = "modify?no=${vo.no}";
		})
		$("#del").click(function() {
			if(!confirm("삭제하시겠습니까?")) {
				return false;
			}
			location.href = "delete?no=${vo.no}";
		})
		$("#return").click(function() {
			location.href = "list";
		})
	})
</script>
<div class="container">
	<div class="form-group">
		<label for="name">프로젝트 이름</label> <input type="text"
			class="form-control" name="name" value="${vo.name}"
			readonly="readonly">
	</div>
	<div class="form-group">
		<label for="content">프로젝트 내용</label>
		<textarea rows="10" cols="50" class="form-control"
			placeholder="프로젝트 내용을 입력하세요" name="content" readonly="readonly">${vo.content}</textarea>
	</div>
	<div class="form-group">
		<label for="startDate">시작일자</label> <input type="text"
			class="form-control" name="startDate" value="<fmt:formatDate value="${vo.startDate}"
									pattern="yyyy-MM-dd" />"
			readonly="readonly">
	</div>
	<div class="form-group">
		<label for="endDate">마감일자</label> <input type="text"
			class="form-control" name="endDate" value="<fmt:formatDate value="${vo.endDate}"
									pattern="yyyy-MM-dd" />"
			readonly="readonly">
	</div>
	<div class="form-group">
		<label for="status">상태</label> <input type="text" class="form-control"
			name="status"
			value="${vo.status eq 'r'?'준비':vo.status eq 'e'?'진행중':vo.status eq 'f'?'종료':'보류'}" readonly="readonly">
	</div>
	<button class="btn btn-default" id="mod">수정</button>
	<button class="btn btn-default" id="del">삭제</button>
	<button class="btn btn-default" id="return">돌아가기</button>
</div>
<%@ include file="include/footer.jsp"%>