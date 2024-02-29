let uploadDiv = document.querySelector("#upload");
uploadDiv.style.display = "hidden";
let uploadBtn = document.querySelector("#uploadBtn");
let deleteBtn = document.querySelector("#deleteBtn");

let input = document.querySelector("#uploadFile");
input.addEventListener("change", () => {
	let fName = input.files[0].name;
	let fSize = input.files[0].size;
	console.log("fileName =" + fName);
	console.log("fileSize =" + fSize);
	
	let fileForm =  /(.*?)\.(jpg|jpeg|png|gif|PNG)$/;
	let maxSize = 5 * 1024 * 1024;
	
	if(fName !== "" && fName !== null){
		if(!fName.match(fileForm)){
			alert("이미지 파일만 업로드 가능");
			return false;
		}
		if(fSize >= maxSize){
			alert("파일 사이즈는 5MB까지 가능");
			return false;
		}
	}
	else{
		return false;
	}
	
	let form = document.querySelector("#imgForm");
	let formData = new FormData(form);
	fetch("memberUploadImg.do", {
		method: "POST",
		body : formData,
	})
	.then(response => response.text())
	.then(data => {
		if(data === "fail"){
			alert("이미지 업로드 실패");
		}
		else{
			alert("이미지 업로드 성공");
			let beforeName = document.querySelector("#photo").src;
			beforeName = beforeName.substring(beforeName.lastIndexOf("/") + 1);
			
			let src = "Uploads/" + data;
			document.querySelector("#photo").setAttribute("src", src);
			document.querySelector("#photo").classList.remove("defalut");
			
			deleteBeforeImg(beforeName);
		}
	})
	.catch(error => {
		console.log("error =", error);
	});
})

uploadBtn.addEventListener("click", () => {
	uploadDiv.style.display = "block";
});

deleteBtn.addEventListener("click", () => {
	if(document.querySelector(".defalut")){
		alert("기본이미지는 삭제할 수 없습니다")
		 return;
	}
	fetch("memberDeleteImg.do", {
		method : "POST",
		headers : {
			"Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
		},
		body : "no=" + document.querySelector("#no").value,
	})
	.then(response => response.text())
	.then(data => {
		if(data === "fail"){
			alert("이미지 삭제 실패");
		}
		else{
			alert("이미지 삭제 성공");
			let src = "https://upload.wikimedia.ord/wikipedia/commons/1/14/No_Image_Available.jpg";
			document.querySelector("#photo").setAttribute("src", src);
			document.querySelector("#photo").classList.add("defalut");
		}
	})
	.catch(error => {
		console.log("error = " + error);
	});
});

function deleteBeforeImg(savedFileName){
	let url = "memberUpload.do?sName=" + savedFileName;
	fetch(url).then(response => console.log(response))
	.catch(error => {
		console.log("error = ", error);
	});
}