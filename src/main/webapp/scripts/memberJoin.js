let check = 0;
function validCheck(form){
	if(!form.id.value.trim()){
		alert("아이디를 입력해주세요");
		form.id.focus();
		return false;
	}
	if(!form.pw.value.trim()){
		alert("패스워드를 입력해주세요");
		form.pw.focus();
		return false;
	}
	if(!form.email.value.match(/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/)){
		alert("이메일 형식이 다릅니다");
		form.email.value="test@test.com";
		form.email.focus();
		return false;
	}
	if(!form.tel.value.match(/010-\d{3,4}-\d{4}/)){
		alert("전화번호 형식이 다릅니다");
		form.tel.value="010-1234-1234";
		form.tel.focus();
		return false;
	}
	if(!form.hobby.value.trim()){
		alert("취미를 입력해주세요");
		form.hobby.focus();
		return false;
	}
	if(!form.job.value.trim()){
		alert("직업을 입력해주세요");
		form.job.focus();
		return false;
	}
	if(!form.age.value.trim()){
		alert("나이를 입력해주세요");
		form.age.focus();
		return false;
	}
	if(!form.info.value.trim()){
		alert("인삿말을 입력해주세요");
		form.info.focus();
		return false;
	}
	
	if(check == 0){
		alert("id 중복체크 해주세요");
		return false;
	}
	else if(check == -1){
		alert("id 중복체크 다시하세요");
		return false;
	}
	form.submit();
}

document.getElementById("checkId").addEventListener("click", () => {
	let id = document.getElementById("id").value.trim();
	
	if(id.length === 0){
		alert("id 값을 입력해주세요");
		document.getElementById("id").focus();
		document.getElementById("id").style.border = "";
		return;
	}
	
	fetch("validIdAjax.do", {
		method : "POST",
		headers : {
			"Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
		},
		body: "id=" + id,
	})
	.then(response => response.text())
	.then(getResult)
	.catch(() => alert("error"));
});

function getResult(data){
	if(data === "valid"){
		alert("이 아이디는 사용가능 합니다");
		document.getElementById("pw").focus();
		document.getElementById("id").style.border = "3px blue solid";
		check = 1;
	}
	else if(data === "notValid"){
		alert("이 아이디는 사용 불가능 합니다");
		document.getElementById("id").value = "";
		document.getElementById("id").focus();
		document.getElementById("id").style.border = "3px red solid";
		check = -1;
	}
}
document.getElementById("id").addEventListener("keyup", (e) => {
	if(e.key === "Backspace" || e.keyCode === 8){
		check = 0;
	}
	document.getElementById("id").style.border = "";
});