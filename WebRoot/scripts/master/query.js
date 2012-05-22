function do_add(){
	document.query_form.action=preAddActionURL;
	document.query_form.submit();
  	}

function do_delete(){	
	if (!check()){
		alert('请选择一个记录！！');
		return ;
		}
	
	var flag = confirm("确定要删除词条记录吗??");
	if(true==flag){
	document.query_form.action=deleteActionURL;
	document.query_form.submit();
		
	}
	
	function check(){
	
	var radios = document.getElementsByName("userId");
	var len = radios.length;
	var clicked = false;
	
	for (var i=0;i<len;i++){
		if(radios[i].checked){
			clicked = true;
			break;
		}	
	}
	return clicked;
}	
	
}