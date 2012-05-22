function do_back(){
	window.history.back();
}


function formCheck() {
	var t = document.getElementsByName("agentType.tel")[0].value;
	var v = document.getElementsByName("agentType.address")[0].value;
	var m = document.getElementsByName("agentType.name")[0].value;
	var n = document.getElementsByName("agentType.legal")[0].value;
	var flag=0;
	
	
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
	
	
	if (v.length == 0) {
		document.getElementById("addressSpan").innerHTML = "<font style='color: red;'>please enter address</font>";
		flag=0;
	}else
		{
		document.getElementById("addressSpan").innerHTML = "";
		flag +=1;
		}
	
	
	
	if (m.length == 0) {
		document.getElementById("nameSpan").innerHTML = "<font style='color: red;'>please enter gent name</font>";
		flag=0;
	}else{
		document.getElementById("nameSpan").innerHTML = "";		
		flag +=1;
	}
	
	if (n.length == 0) {
		document.getElementById("legalSpan").innerHTML = "<font style='color: red;'>please enter legal</font>";
		flag=0;
	}else{
		document.getElementById("legalSpan").innerHTML = "";		
		flag +=1;
	}
	

	if(flag==4){
	document.agentAction_add.submit();		
	}else{
		return;
	}
}

