function do_add() {
	document.query_form.action = preAddActionURL;
	document.query_form.submit();
}

function do_update() {
	if (!checkRadio("proCategory.id")) {
		alert('Please select one');
		return ;
	}
	document.query_form.action = preUpdateActionURL;
	document.query_form.submit();
}



function do_delete() {
	if (!checkRadio("proCategory.id")) {
		alert('Please select one');
		return;
	}
	var flag = confirm("are you sure to delete?");
	if(flag) {
		document.query_form.action = deleteActionURL;
		document.query_form.submit();		
	}
}

/*function check(){
	
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
*/


