<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
  function deleteFn(no, id){
	  location.href="${ctx}/memberDelete.do?no="+no+"&id="+id; 
  }
  
</script>
<table class=" py-10 table table-bordered">
	<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이메일</td>
		<td>전화번호</td>
		<td>취미</td>
		<td>직업</td>
		<th>나이</th>
		<th>자기소개</th>
		<th>이미지</th>
		<td>삭제</td>
	</tr>
	<c:forEach var="vo" items="${list}">
		<tr>
			<td>${vo.no}</td>
			<td>${vo.id}</td>
			<td>${vo.pw}</td>
			<td>${vo.email}</td>
			<td>${vo.tel}</td>
			<td>${vo.hobby}</td>
			<td>${vo.job}</td>
			<td>${vo.age}</td>
			<td>${vo.info}</td>
			<td><c:if test="${vo.sFileName != null}">
					<img src="Uploads/${vo.sFileName}" width="60px" height="60px"/>
				</c:if>
				<c:if test="${vo.sFileName == null}">
					<img src="https://upload.wikimedia.org/wikipedia/commons/1/14/No_Image_Available.jpg" width="60px" height="60px"/>
				</c:if>
			</td>
			<td><input type="button" value="삭제" class="btn btn-outline-dark" 
				onclick="deleteFn('${vo.no}', '${vo.id}')" />
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>