<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>

<main>
	<div class="inner">
		<form id="car-form" action="${ctx}/selectCarOption.do" method="post">
			<div class="car-desc">
				<div class="car-photo">
					<img alt="${vo.name}" src="img/${vo.img}">
				</div>
				<h2>차량 정보</h2>
				<p>${vo.info}</p>
			</div>
			<table class="car-table">
				<tr>
					<td colspan="2">
						<h2>${vo.name} 차량선택</h2>
					</td>
				</tr>
				<tr>
					<td class="colname">차량수량</td>
					<td class="left"><select name="qty" id="qtyVal">
						<c:forEach var="i" begin="1" end="${vo.total_qty}">
						<option value="${i}">${i}</option>
						</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="colname">차량분류</td>
					<td class="left">
						<c:choose>
							<c:when test="${vo.category eq '1'}">
								<c:out value="소형"/>
							</c:when>
							<c:when test="${vo.category eq '2'}">
								<c:out value="중형"/>
							</c:when>
							<c:when test="${vo.category eq '3'}">
								<c:out value="대형"/>
							</c:when>
						</c:choose>
					</td>
				</tr>
				<tr>
              		<td class="colname">대여가격</td>
              		<td class="left">${vo.price}원</td>
            	</tr>
            	<tr>
              		<td class="colname">제조회사</td>
              		<td class="left">${vo.company}</td>
            	</tr>
            	<tr>
              		<td colspan="2">
                		<input type="hidden" name="no" value="${vo.no}"/>
                		<button class="next-btn mybtn">옵션선택후 구매하기<span>></span></button>
              		</td>
            	</tr>
			</table>
		</form>
	</div>
</main>

<%@ include file="../parts/footer.jsp"%>