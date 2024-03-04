<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<script type="text/javascript" src="scripts/memberReserveView.js" defer></script>

<main>
	<div class="inner">
		<div class="car-List">
			<h2>예약 정보 확인</h2>
			<input type="hidden" name="id" id="id" value="${logId}">
			<table class="reserve-table">
				<tr>
					<td>이미지</td>
              		<td>이름</td>
             	 	<td>대여일</td>
              		<td>대여기간</td>
              		<td>반납일</td>
              		<td>총 금액</td>
              		<td>수량</td>
              		<td>보험</td>
              		<td>wifi</td>
              		<td>babySeat</td>
              		<td>navigation</td>
              		<td></td>
				</tr>
				<c:forEach var="vo" items="${list}">
					<tr>
						<td><img src="img/${vo.img}"></td>
						<td>${vo.name}</td>
						<td>${vo.rday}</td>
						<td>${vo.dday}</td>
						<td>${vo.endDate}</td>
						<td>${vo.totalPrice}원</td>
						<td>${vo.qty}</td>
						<td>
							<c:choose>
								<c:when test="${vo.usein == 0}">미적용</c:when>
								<c:when test="${vo.usein == 1}">적용</c:when>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${vo.usewifi == 0}">미적용</c:when>
								<c:when test="${vo.usewifi == 1}">적용</c:when>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${vo.useseat == 0}">미적용</c:when>
								<c:when test="${vo.useseat == 1}">적용</c:when>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${vo.usenavi == 0}">미적용</c:when>
								<c:when test="${vo.usenavi == 1}">적용</c:when>
							</c:choose>
						</td>
						<td>
							<button id="delBtn" onclick="deleteReservation('${vo.reserve_seq}')"> X </button>
						</td>
					</tr>			
				</c:forEach>
			</table>
		</div>
	</div>
</main>

<%@ include file="../parts/footer.jsp"%>