
function validate(){
	var name =document.getElementById('name');
	if(name.value == ""){
		alert("please enter your name");
		name.focus();
		return false;
	}else{
		return true;
	}
}

