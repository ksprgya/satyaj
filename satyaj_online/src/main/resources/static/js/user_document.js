
function validate(){
	var name =document.getElementById('file');
	if(name.value == ""){
		alert("please upload file ");
		name.focus();
		return false;
	}else{
		return true;
	}
}

