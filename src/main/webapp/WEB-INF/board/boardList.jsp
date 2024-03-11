<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<script type="text/javascript" src="scripts/boardList.js" defer></script>

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
						<th>조회수</th>
					</tr>
					<c:forEach var="vo" items="${list}" begin="${PoststartNum}" end="${PostEndNum - 1}" step="1" varStatus="i">
						<tr>
							<td>${(totalCount - i.index) - ((startPageNum - 1) * boardCnt)}</td>
							<td>${vo.writer}</td>
							<td>${vo.regDate}</td>
							<td><a href="${ctx}/boardView.do?no=${vo.no}">${vo.subject}</a></td>
							<td>${vo.contents}</td>
							<td>${vo.read_cnt}</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="6"><button type="button" onclick="checkId1('${logId}')">새글작성</button></td>
					</tr>
				</table>
			</div>
			<div class="board-pageing">
				<c:if test="${startPageNum > pageNumCnt}">
					<a href="${ctx}/boardList.do?start=${startPageNum - 1}&curNum=${startPageNum - pageNumCnt}">이전</a>
				</c:if>
				<c:forEach begin="${startPageNum}" end="${EndPageNum}" step="1" var="i">
					<a href="${ctx}/boardList.do?start=${i}&curNum=${startPageNum}">${i}</a>
				</c:forEach>
				<c:if test="${EndPageNum < totalPage}">
					<a href="${ctx}/boardList.do?start=${startPageNum + pageNumCnt}&curNum=${startPageNum + pageNumCnt}">이후</a>
				</c:if>
			</div>
		</div>
	</div>
</main>

<%@ include file="../parts/footer.jsp"%>