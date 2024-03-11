<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>


<main>
	<div class="inner">
		<div class="board">
			<div class="board-header">
				<p>게시글 보기</p>
			</div>
			<div class="board-table">
				<form method="post" action="${ctx}/boardContent.do?no=${vo.no}">
					<table border="1">
						<tr>
							<th>번호</th>
							<td colspan="6">${vo.no}</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td>${vo.writer}</td>
							<th>작성일</th>
							<td>${vo.regDate}</td>
							<th>조회수</th>
							<td>${vo.read_cnt}</td>
						</tr>
						 <tr>
            				<th>제목</th>
            				<td colspan="6">${vo.subject}</td>
        				</tr>
        				<tr>
            				<th>내용</th>
            				<td colspan="6">${vo.contents}</td>
       					</tr>
       					<tr>
       						<td colspan="6">
       							<input type="hidden" name="no" value="${vo.no}">
       							<input type="submit" value="수정하기" <c:if test="${logId ne vo.writer and logId ne 'admin'}"> disabled="disabled"</c:if> />
       							<input type="button" value="삭제하기" <c:if test="${logId ne vo.writer and logId ne 'admin'}"> disabled="disabled"</c:if> onclick="location.href='${ctx}/boardDelete.do?no=${vo.no}'"/>
       					</tr>
					</table>
				</form>
			</div>
		</div>
	</div>

</main>


<%@ include file="../parts/footer.jsp"%>