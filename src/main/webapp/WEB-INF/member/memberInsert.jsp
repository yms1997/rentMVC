<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 class="py-3">회원 가입</h1>
	<form action="${ctx}/memberAdd.do" method="post" enctype="multipart/form-data" >
		<table class="table table-bordered" >
			<tr>
				<td>아이디</td>
				<td><input class="col-5" type="text" name="id" id="id" autofocus required />
				 <input type="button" value="중복체크" id="checkId" class="btn btn-outline-dark"></td>
			</tr>
			
			<tr>
				<td>패스워드</td>
				<td><input class="col-5" type="password" name="pw" id="pw" required/></td>
			</tr>
			
			<tr>
				<td>이메일</td>
				<td><input class="col-5" type="email" name="email" id="email" required/></td>
			</tr>
			
			<tr>
				<td>전화번호</td>
				<td><input class="col-5" type="tel" name="tel" id="tel" required/></td>
			</tr>
			
			<tr>
				<td>취미</td>
				<td><input class="col-5" type="text" name="hobby" id="hobby" required/></td>
			</tr>
			
			<tr>
				<td>직업</td>
				<td><input class="col-5" type="text" name="job" id="job" required  /></td>
			</tr>
			
			<tr>
				<td>나이</td>
				<td><input class="col-5" type="number" name="age" id="age" required  /></td>
			</tr>
			
			<tr>
				<td>인삿말</td>
				<td><input class="col-5" type="text" name="info" id="info" required  /></td>
			</tr>
			
			<tr>
				<td>프로필 사진</td> <td> <input type="file" name="uploadFile" accept="image/*"></td>
			</tr>
			
			<tr>
				<td colspan="2" id="btns">
					<input type="submit" value="가입" class="col-3 btn btn-primary"/> 
					<input type="reset" value="취소" class="col-3 btn btn-warning" /></td>
			</tr>
		</table>
	</form>
	
</body>
</html>