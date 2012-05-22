function do_delete(){

		var choices = document.getElementsByName('choice');
		var assignedProductIds = "";
		for(var i=0; i < choices.length; i++) 
		{
			if(choices[i].checked){
			assignedProductIds += choices[i].value + ",";				
			}
		}

		var assignedProductIds = assignedProductIds.substr(0,assignedProductIds.length -1);
		if(assignedProductIds.length != 0) 
		{
			document.productpublish_form.action = deleteActionURL;
			document.getElementById('assignedProductIds').value = assignedProductIds;
			document.productpublish_form.submit();
		} else {
			alert('please choose one or some choices!')
			return false;
		}

}

function selectAll(chkBox,otherBoxesName) {
	var otherBoxes = document.getElementsByName(otherBoxesName);

	if (chkBox.checked) {
		for (i=0; i<otherBoxes.length; i++) {
			otherBoxes[i].checked = true;
		}
	
	}else{
		for (i=0; i<otherBoxes.length; i++) {
			otherBoxes[i].checked = false;
		}
	}

}
/*var assignedRoleIds = "";
	var list = document.assign_form.asroles;
	for(var i = 0; i < list.options.length; i++) {
		assignedRoleIds += list.options[i].value + ","
	}
	
	var assignedRoleIds = assignedRoleIds.substr(0,assignedRoleIds.length - 1);
	
	if(assignedRoleIds.length != 0) {
		document.assign_form.action = saveUserRolesActionURL;
		document.getElementById('assignedRoleIds').value = assignedRoleIds;
		document.assign_form.submit();
	} else {
		document.assign_form.action = saveUserRolesActionURL;
		document.getElementById('assignedRoleIds').value = "";
		document.assign_form.submit();
	}*/




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
}	*/