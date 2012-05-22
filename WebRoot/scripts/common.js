/**
 * 检查查询页面中radio是否被选中一个
 * @param elementName
 * @return
 */
function checkRadio(elementName) {
    var radios = document.getElementsByName(elementName);	
    var len = radios.length;
    var clicked = false;
    for (var i=0; i<len; i++) {
    	if (radios[i].checked) {
    		clicked = true;
    		break;
    	}
    }
    
    return clicked;

}

/*function selectAll(chkBox,otherBoxesName) {
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
	}*/