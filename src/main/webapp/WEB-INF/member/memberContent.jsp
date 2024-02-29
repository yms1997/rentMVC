<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ include file="../parts/header.jsp"%>
<script type="text/javascript" src="scripts/memberContent.js" defer></script>
<style>
   #photo{
      width:30%;
      height:30%;
   }
</style>
<body>
<c:if test="${vo==null}">
  <h1 class="py-3"> 일치하는 회원이 없습니다 </h1>
</c:if>
<c:if test="${vo ne null}">
<h1 class="py-3" > ${vo.id} 회원의 상세보기 </h1>
<form action="${ctx}/memberUpdate.do" method="post">
<input type="hidden" id="no" name="no" value="${vo.no}"/>
<table class='table table-bordered'>
  <tr>
    <td>번호</td>
    <td class="left"> ${vo.no}</td>
  </tr>
   <tr>
    <td>아이디</td>
    <td class="left">${vo.id}</td>
  </tr>
   <tr>
    <td>비밀번호</td>
    <td class="left">${vo.pw}</td>
  </tr>  
    <tr>
    <td>이메일</td>
    <td><input class="col-12"  type="text" name="email" value="${vo.email}"/></td>
  </tr> 
  <tr>
    <td>전화번호</td>
    <td><input class="col-12"  type="text" name="tel" value="${vo.tel}"/></td>
  </tr> 
     <tr>
    <td>취미</td>
    <td><input class="col-12"  type="text" name="hobby" value="${vo.hobby}"/></td>
  </tr>
  <tr>
    <td>직업</td>
    <td><input class="col-12"  type="text" name="job" value="${vo.job}"/></td>
  </tr>
  <tr>
    <td>나이</td>
    <td><input class="col-12"  type="text" name="age" value="${vo.age}"/></td>
  </tr>
  <tr>
    <td>자기소개</td>
    <td><input class="col-12"  type="text" name="info" value="${vo.info}"/></td>
  </tr>  
  <tr>
    <td>프로필 이미지</td>
        <td>
    	   <c:if test="${vo.sFileName!=null}">
    	         <img src="Uploads/${vo.sFileName}" id="photo"/>
    	   </c:if>
    	   <c:if test="${vo.sFileName==null}">
    	         <img src="https://upload.wikimedia.org/wikipedia/commons/1/14/No_Image_Available.jpg" id="photo" class="defalut">
    	   </c:if>
    	      </td>
  </tr> 
  <tr>
    <td colspan="2" align="center">
       <input type="button" value="사진 업로드" class='col-3 btn btn-success' id="uploadBtn" /> 
       <input type="submit" value="수정하기" class='col-3 btn btn-primary' /> 
       <input type="button" value="사진 삭제" class='col-3 btn btn-warning' id="deleteBtn"   <c:if test="${loginId!=vo.id and loginId!='admin'}"> 
    	              disabled="disabled"
          	      </c:if>/> 
    </td>
  </tr>
</table>


</form>

<div id="upload">
<form id="imgForm" enctype="multipart/form-data">
<input id="uploadFile" type="file" name="uploadFile" accept="image/*">
<input type="hidden" name="no" value="${vo.no}"/>
</form>
</div>
</c:if>
<%@ include file="../parts/footer.jsp"%>