function do_back(){
	window.history.back();
}

function changeAgentSelect(typeSel) {
	var typeSelValue = typeSel.value;
	if (typeSelValue ==1 ) {
		document.getElementsByName("user.agent.id")[0].disabled = 'disabled';
	} else {
		document.getElementsByName("user.agent.id")[0].disabled = '';
	}
}


function formCheck() {
	var v = document.getElementsByName("user.userName")[0].value;
	var m = document.getElementsByName("user.realName")[0].value;
	var n = document.getElementsByName("user.email")[0].value;
	var t = document.getElementsByName("user.tel")[0].value;
	var flag=0;
	
	
	if (v.length == 0) {
		document.getElementById("userNameSpan").innerHTML = "<font style='color: red;'>please enter userName</font>";
		flag=0;
	}else
		{
		document.getElementById("userNameSpan").innerHTML = "";
		flag +=1;
		}
	
	if (m.length == 0) {
		document.getElementById("realNameSpan").innerHTML = "<font style='color: red;'>please enter realName</font>";
		flag=0;
	}else{
		document.getElementById("realNameSpan").innerHTML = "";		
		flag +=1;
	}
	
	if (n.length == 0) {
		document.getElementById("emailSpan").innerHTML = "<font style='color: red;'>please enter email</font>";
		flag=0;
	}else if (!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/.test(n)) {
		document.getElementById("emailSpan").innerHTML = "<font style='color: red;'>please enter right email!</font>";
		flag = 0;
	}else{
		document.getElementById("emailSpan").innerHTML = "";		
		flag += 1;
	}
	if (t.length == 0) {
		document.getElementById("telSpan").innerHTML = "<font style='color: red;'>please enter tel</font>";
		flag=0;
	}else if (!/^[1-9]\d*$/.test(t)) {
		document.getElementById("telSpan").innerHTML = "<font style='color: red;'>please enter right tel!</font>";
		flag = 0;
	}else{
		document.getElementById("telSpan").innerHTML = "";		
		flag += 1;
	}
	

	if(flag==4){
	document.userAction_update.submit();		
	}else{
		return;
	}
}