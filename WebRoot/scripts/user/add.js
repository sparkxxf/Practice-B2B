function changeAgentSelect(typeSel) {
	var typeSelValue = typeSel.value;
	if (typeSelValue == 1) {
		document.getElementsByName("user.agent.id")[0].disabled = 'disabled';
	} else {
		document.getElementsByName("user.agent.id")[0].disabled = '';
	}
}

function do_back(){
	window.history.back();
}

var request;
function checkUsername(usernameTag){
	if (window.XMLHttpRequest){
		request = new XMLHttpRequest();
		
	}else if(window.ActiveXObject){
		request = new AcitveXObject("Mircosoft.XMLHTTP");
		
	}
	var userName = usernameTag.value;
	
	if (userName.length == 0){
		return;
	}
	
	request.onreadystatechange = callBackFun;
	var url = "/b2b/user/userAction_checkName.action?user.userName="+userName+"&id="+Math.random();
	
	request.open("get", url,true);
	
	request.send(null);
}
function callBackFun(){
	if (request.readyState == 4){
		var data = request.responseText;
		
		if (data == 'true'){
			
			document.getElementById("userNameSpan").innerHTML = "<font style='color: red;'>Username used!</font>";
			document.getElementById("checkNameTag").value = "1";
		}else{
			
			document.getElementById("userNameSpan").innerHTML = "<font style='color: green;'>Username has not used!</font>";
			document.getElementById("checkNameTag").value = "0";
		}
	}
}

function formCheck() {
	
	var v = document.getElementsByName("user.userName")[0].value;
	var m = document.getElementsByName("user.realName")[0].value;
	var n = document.getElementsByName("user.email")[0].value;
	var t = document.getElementsByName("user.tel")[0].value;
	var a = document.getElementsByName("user.agent.id")[0].value;
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
	
	if (a.length == 0) {
		document.getElementById("agentSpan").innerHTML = "<font style='color: red;'>please choice agent</font>";
		flag = 0;
	}else{
		document.getElementById("agentSpan").innerHTML = "";
		flag += 1;
	}
	
	if (document.getElementById("checkNameTag").value == 1){
		return false;
	}

	if(flag==5){
	document.userAction_add.submit();		
	}else{
		return;
	}
}







