function changeAgentSelect(typeSel){

	var typeSelValue = typeSel.value;
	if (typeSelValue ==-1 || typeSelValue ==1){
		document.getElementsByName("user.agent.id")[0].disabled='disabled';
		
	}
	else{
		document.getElementsByName("user.agent.id")[0].disabled='';
	}
}

function do_add(){
	document.query_form.action=preAddActionURL;
	document.query_form.submit();
  	}


function do_update(){
	if (!check()){
		alert('请选择一个记录！！');
		return ;
		}
	document.query_form.action=preUpdateActionURL;
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
}


function check(){
	
	var radios = document.getElementsByName("types");
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