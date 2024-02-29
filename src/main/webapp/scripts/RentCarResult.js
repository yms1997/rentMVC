//let ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

(() => {
	if(!document.querySelector("#id").value){
		alert("로그인 먼저 해주세요")
		location.href=ctx+"/main.do";
	}
})();

const form = document.querySelector('#car-form');
form.addEventListener("submit", (e) => {
	alert("체크");
	e.preventDefault();
	checkValue();
});

let carReservation = {
	reserveSeq: null,
	no: document.querySelector('#no').value,
	qty: document.querySelector('#qty').value,
};

let today = new Date().toISOString().split("T")[0];
document.querySelector("#date").value = today;
document.querySelector("#date").min = today;
let isSend = false;

function checkValue(){
	let date = document.querySelector("#date")?.value;
	let dday = document.querySelector("#dday")?.value;
	let rentDate = new Date(date);
	let endDate = new Date(rentDate);
	endDate.setDate(rentDate.getDate() + Number(dday));
	
	let usein = document.querySelector("#usein")?.value;
	let usenavi = document.querySelector("#usenavi")?.value;
	let usewifi = document.querySelector("#usewifi")?.value;
	let useseat = document.querySelector("#useseat")?.value;
	let carQty = document.querySelector("#qty").value;
	
	let carCnt = document.querySelector("#carCnt");
	let carDate = document.querySelector("#carDate");
	let carDaysCnt = document.querySelector("#carDaysCnt");
	let carDays = document.querySelector("#carDays");
	let carOptionsCnt = document.querySelector("#carOptionsCnt");
	let carOptions = document.querySelector("#carOptions");
	let carTotals = document.querySelector("#carTotals");
	
	let price = document.querySelector("#price")?.dataset?.price;
	
	carCnt.innerHTML = carQty + "개 ("+ price +" 원)";
	carDate.innerHTML = date + " ~ " + endDate.getFullYear() + "-" + (endDate.getMonth() + 1) + "-" + endDate.getDate();
	carDaysCnt.innerHTML = dday + "일 * " + carQty + "개";
	carDays.innerHTML = (price * dday * carQty) + "원";
	
	let totalCnt = 0;
	totalCnt = usein == 1 ? totalCnt + 1 : totalCnt;
	totalCnt = usewifi == 1 ? totalCnt + 1 : totalCnt;
	totalCnt = useseat == 1 ? totalCnt + 1 : totalCnt;
	carOptionsCnt.innerHTML = totalCnt + "개 * " + carQty + "개";
	carOptions.innerHTML = (totalCnt * 10000 * carQty) + "원";
	
	carTotals.innerHTML = (price * dday + totalCnt * 10000 * dday) * carQty + "원";
	
	carReservation['dday'] = dday;
  	carReservation['rday'] = date;
  	carReservation['usein'] = usein;
  	carReservation['usewifi'] = usewifi;
  	carReservation['useseat'] = useseat;
  	carReservation['usenavi'] = usenavi;
}

document.querySelector("#delBtn").addEventListener("click", () => {
	alert("취소했습니다");
	location.href = ctx + "/main.do";
})
document.querySelector("#updateBtn").addEventListener("click", () => {
	alert("체크2");
	carReservation['id'] = document.querySelector('#id').value;
	if(isSend){
		alert("이미 예약 완료 했습니다")
		return;
	}
	console.log(carReservation);
	carReservationAjax();
	isSend = true;
});

function carReservationAjax(){

	
	fetch("reservateCar.do", {
		method: "POST",
		headers: {
			"Content-Type": "application/json",
		},
		body: JSON.stringify(carReservation),
	})
	.then(response => response.json())
	.then(data => {
		if(data == 1){
			alert("렌트카 예약 성공");
			location.href=ctx+"/main.do";
		}
	})
	.catch(error => console.error("Error:", error));
}

