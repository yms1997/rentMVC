<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>

<main>
	<div class="inner">
		<div class="board">
			<div class="board-header">
				<h2>새 글 작성</h2>
			</div>
			<div class="board-table">
				<form method="post" action="${ctx}/Addboard.do">
					<table border="1">
						<tr>
							<th>제목</th>
							<td><input type="text" id="subject" name="subject" required /></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea id="contents" name="contents" required></textarea></td>
						</tr>
						<tr>
							<th>작성자</th>
							<td><input type="hidden" name="writer" value="${logId}"/>${logId}</td>
						</tr>
						<tr>
							<td colspan="4">
								<input type="submit" value="등록하기">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</main>

<%@ include file="../parts/footer.jsp"%>