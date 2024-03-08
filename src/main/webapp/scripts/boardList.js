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

function checkId2(loginId){
	let id = loginId;
	if(id === ""){
		alert("로그인 후 수정가능합니다")
		location.href= ctx + "/memberLogin.do";
		return false;
	}
	else{
		return true;
	}
}

function Deleteboard(no){
	let isDel = confirm("삭제하시겠습니까?");
	if(isDel === true){
		location.href= ctx + "/boardDelete.do?no="+no;
	}
	else{
		location.href= ctx + "/boardList.do";
	}
}