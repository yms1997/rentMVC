(() => {
	if(!document.querySelector("#id")?.value){
		alert("로그인 먼저 해주세요")
		location.href=ctx+"/main.do";
	}
})();