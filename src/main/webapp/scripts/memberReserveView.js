(() => {
	if(!document.querySelector("#id")?.value){
		alert("로그인 먼저 해주세요")
		location.href=ctx+"/main.do";
	}
})();

function deleteReservation(reserve_seq){
	fetch("deleteRes.do", {
		method: "POST",
		headers: {
			"Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
		},
		body: "regNo="+reserve_seq,
	})
	.then(response => response.text())
	.then(data => {
		if(data == 0){
			alert("예약 취소 실패")
			location.href = ctx + "/userReserveList.do";
		}
		else{
			alert("예약 취소 성공")
			location.href = ctx + "/main.do";
		}
	})
	.catch(error => console.error("Error = " + error));
};

document.querySelector("#delBtn").addEventListener("click", () => {
	deleteReservation(reserve_seq);
});