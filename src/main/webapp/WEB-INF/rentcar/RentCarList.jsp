<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>

<main>
	<div class="inner">
		<aside>
			<ul>
				<li onclick="location.href='${ctx}/rentcarList.do?kind=all'">전체조회</li>
				<li onclick="location.href='${ctx}/rentcarList.do?kind=small'">소형조회</li>
				<li onclick="location.href='${ctx}/rentcarList.do?kind=medium'">중형조회</li>
				<li onclick="location.href='${ctx}/rentcarList.do?kind=large'">대형조회</li>
			</ul>
		</aside>
		<div class="car-content">
			<h2>${title} 조회</h2>
			<div class="itemWrap">
				<c:forEach var="vo" items="${list}">
					<div class="item" onclick="checkQty('${vo.total_qty}', '${ctx}', '${vo.no}')">
						<div class="imgbox">
							<img src="img/${vo.img}" alt="${vo.name}">
						</div>
						<div class="textBox">
							<p class="textBox-name">${vo.name}&nbsp; ${vo.company}</p>
							<p class="textBox-price">${vo.price}원</p>
						</div>
					</div>				
				</c:forEach>
			</div>
		</div>
	</div>
</main>
<script>
	function checkQty(qty, ctx, no){
		if(qty > 0){
			location.href=ctx+"/rentcarInfo.do?no="+no;
		}
		else{
			alert("이 차는 모두 렌트 중입니다");
		}
	}
</script>

<%@ include file="../parts/footer.jsp"%>