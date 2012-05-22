function changeptype() {
//	document.query_form.action = prepareQueryActionURL;
	document.query_form.submit();
}

function do_publish() {
	
	var ckbselect = document.getElementsByName('ProductCategory.id');
	var ids = '';
	for(var i=0;i<ckbselect.length;i++){
		if(ckbselect[i].checked){
			ids+=ckbselect[i].value + ","
		}
	}
	if(ids.length>0){
		ids = ids.substr(0,ids.length-1);
		document.getElementById('selectedIds').value = ids;
		document.query_form.action = do_publish_ActionURL;
		document.query_form.submit();
	}else{
		
		alert("请选择要发布的产品");

	}
}

function do_queryPublished() {
		document.query_form.action = do_queryPublished_ActionURL;
		document.query_form.submit();
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