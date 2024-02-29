let ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

function loginAjax(form){
	let id = form.id.value.trim();
	let pw = form.pw.value.trim();
	
	if(id.length == 0 || pw.length == 0){
		alert("값을 다 넣어주세요");
		return;
	}
	
	fetch("memberLoginCheck.do", {
		method : "POST",
		headers : {
			"Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
		},
		body : "id=" + id + "&pw=" + pw
	})
	.then(response => response.text())
	.then(data => {
		if(data !== "null"){
			alert("로그인 성공!")
			location.href = ctx +"/main.do";
		}
		else{
			alert("로그인 실패!")
			location.href = ctx +"/memberLogin.do";
		}
	})
	.catch(error => console.error("Error = ", error));
	form.id.value = "";
	form.pw.value = "";
}

document.querySelector(".logout-btn").addEventListener("click", () => {
	fetch("memberLogout.do", {
		method : "GET",
	})
	.then(response => response.text())
	.then(data => {
		if(data === "done"){
			alert("로그아웃 완료!")
			location.href = ctx +"/main.do";
		}
	})
	.catch(error => "Error: " + error)
});