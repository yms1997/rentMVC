<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>


<main>
	<div class="inner">
		<div class="board">
			<div class="board-header">
				<p>게시글 수정하기</p>
			</div>
			<div class="board-table">
				<form method="post" action="${ctx}/boardUpdate.do">
					<table border="1">
						<tr>
							<th>번호</th>
							<td colspan="3">${vo.no}</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td>${vo.writer}</td>
							<th>작성일</th>
							<td>${vo.regDate}</td>
						</tr>
						 <tr>
            				<th>제목</th>
            				<td colspan="3">
                				<input type="text" name="subject" value="${vo.subject}">
            				</td>
        				</tr>
        				<tr>
            				<th>내용</th>
            				<td colspan="3">
                				<textarea rows="10" cols="20" name="contents">${vo.contents}</textarea>
            				</td>
       					</tr>
       					<tr>
       						<td colspan="4">
       							<input type="hidden" name="no" value="${vo.no}">
       							<input type="submit" value="수정하기">
       					</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</main>


<%@ include file="../parts/footer.jsp"%>