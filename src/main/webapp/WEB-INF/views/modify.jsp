<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="include/header.jsp"%>
<script>
	$(function() {
		$("button").eq(1).click(function() {
			location.href = "detail?no=${vo.no}"
		})
		var status = "${vo.status}";
		switch(status) {
		case "r":
			$("select option").eq(0).prop("selected",true);
			break;
		case "e":
			$("select option").eq(1).prop("selected",true);
			break;
		case "f":
			$("select option").eq(2).prop("selected",true);
			break;
		case "p":
			$("select option").eq(3).prop("selected",true);
			break;
		}
		$(function(){
			$("form").submit(function() {
				if($("input[name='name']").val()==""||$("input[name='content']").val()==""||$("input[name='startDate']").val()==""||$("input[name='endDate']").val()==""||$("select option:selected").val()=="") {
					alert("폼을 다 채워주세요");
					return false;
				}
				if($("input[name='name']").val().length>30) {
					alert("프로젝트 제목은 30자를 초과할 수 없습니다");
					return false;
				}
			})
		})	
	})
</script>
<div class="container">
	<form action="modify" method="post">
		<input type="hidden" name="no" value="${vo.no}">
		<div class="form-group">
			<label for="name">프로젝트 이름</label> <input type="text"
				class="form-control" name="name" value="${vo.name}">
		</div>
		<div class="form-group">
			<label for="content">프로젝트 내용</label>
			<textarea rows="10" cols="50" class="form-control"
				placeholder="프로젝트 내용을 입력하세요" name="content">${vo.content}</textarea>
		</div>
		<div class="form-group">
			<label for="startDate">시작일자</label> <input type="date"
				class="form-control" name="startDate"
				value="<fmt:formatDate value="${vo.startDate}"
									pattern="yyyy-MM-dd" />">
		</div>
		<div class="form-group">
			<label for="endDate">마감일자</label> <input type="date"
				class="form-control" name="endDate"
				value="<fmt:formatDate value="${vo.endDate}"
									pattern="yyyy-MM-dd" />">
		</div>
		<div class="form-group">
			<label for="status">상태</label> <select class="form-control"
				name="status">
				<option>준비</option>
				<option>진행중</option>
				<option>종료</option>
				<option>보류</option>
			</select>
		</div>
		<button type="submit" class="btn btn-default">수정</button>
		<button type="reset" class="btn btn-default">취소</button>
	</form>
</div>
<%@ include file="include/footer.jsp"%>