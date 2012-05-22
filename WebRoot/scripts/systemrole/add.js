function formCheck() {
	
	var v = document.getElementsByName("systemrole.rolename")[0].value;
	if (v.length==0){
        alert('角色名称不能为空！！');
		return false;
	}
	document.systemroleAction_add.submit();
}

function do_back(){
	window.history.back();
}