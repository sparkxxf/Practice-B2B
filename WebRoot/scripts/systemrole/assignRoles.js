function changeSystemRole() {
	document.assign_form.submit();
}



/**
 * Move selected options from left to right, or right to left
 */
function move_option(e1, e2){
	try{
	    for(var i=0; i<e1.options.length; i++) {
	      if(e1.options[i].selected){
	        var e = e1.options[i];
	        e2.options.add(new Option(e.text, e.value));
	        e1.remove(i);
	        i=i-1
	      }
	    }
	} catch(e) {
	}
}

/**
 * Move all options from left to right, or right to left
 */
function move_all(e1, e2){
	try{
	    for(var i=0; i<e1.options.length; i++) {
	      if(e1.options[i]){
	        var e = e1.options[i];
	        e2.options.add(new Option(e.text, e.value));
	        e1.remove(i);
	        i=i-1
	      }
	    }
	} catch(e) {
	}
}

/**
 * save user's roles.
 */
function do_saveRoleFuncs() {
	var assignedRoleIds = "";
	var list = document.assign_form.asfuncs;
	for(var i = 0; i < list.options.length; i++) {
		assignedRoleIds += list.options[i].value + ","
	}
	
	var assignedRoleIds = assignedRoleIds.substr(0,assignedRoleIds.length - 1);
	
	if(assignedRoleIds.length != 0) {
		document.assign_form.action = saveRoleFuncsActionURL;
		document.getElementById('assignedFuncsId').value = assignedRoleIds;
		document.assign_form.submit();
	} else {
		document.assign_form.action = saveRoleFuncsActionURL;
		document.getElementById('assignedFuncsId').value = "";
		document.assign_form.submit();
	}
	
}