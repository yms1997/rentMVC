<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>

<main>
	<div class="inner">
		<div class="board">
			<div class="board-header">
				<p> 전체 게시글 수 ${totalCount}개 </p>
			</div>
			<div class="board-table">
				<table border="1">
					<tr>
						<th>번호</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>제목</th>
						<th>내용</th>
						<th>삭제</th>
					</tr>
					<c:forEach var="vo" items="${list}">
						<tr>
							<td>${vo.no}</td>
							<td>${vo.writer}</td>
							<td>${vo.regDate}</td>
							<td><a href="${ctx}/boardContent.do?no=${vo.no}">${vo.subject}</a></td>
							<td>${vo.contents}</td>
							<td><button onclick="#"> 삭제 </button></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</main>

<%@ include file="../parts/footer.jsp"%>