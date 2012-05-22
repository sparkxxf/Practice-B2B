function formCheck() {
	var v = document.getElementsByName("systemrole.rolename")[0].value;
	if (v.length==0){
//		document.getElementById("error").innerHTML="<font style='color: red;'>产品类别名称不能为空！！</font>";
		alert('产品类别名称不能为空！！');
		return false;
	}
	document.systemroleAction_update.submit();
	

}

function do_back(){
	window.history.back();
}