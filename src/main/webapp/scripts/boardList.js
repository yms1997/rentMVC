function checkId1(loginId){
	let id = loginId;
	if(id === ""){
		alert("로그인 후 이용가능합니다");
		location.href=ctx+"/memberLogin.do";
	}
	else{
		location.href=ctx+"/boardInsert.do";
	}
}
