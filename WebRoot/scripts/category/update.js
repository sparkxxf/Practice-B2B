function formCheck(){
	
	var brand = document.getElementsByName("proCategory.brand")[0].value;
	var type = document.getElementsByName("proCategory.type")[0].value;
	var priceValue = document.getElementsByName("proCategory.prize")[0].value;
	var flag =1 ;
	
	if (brand.length == 0) {
		document.getElementById("brandSpan").innerHTML = "<font style='color: red;'>please write!!</font>";
		flag = 0;
	} else {
		document.getElementById("brandSpan").innerHTML = "";
		flag += 1;
	}
	
	if (type.length == 0) {
		document.getElementById("typeSpan").innerHTML = "<font style='color: red;'>please write!!</font>";
		flag = 0;
	} else {
		document.getElementById("typeSpan").innerHTML = "";
		flag += 1;
	}
	
	if (priceValue.length == 0) {
		document.getElementById("prizeSpan").innerHTML = "<font style='color: red;'>please write!!!</font>";
		flag = 0;
	} else if (!/^[1-9]\d*$/.test(priceValue)) {
		document.getElementById("prizeSpan").innerHTML = "<font style='color: red;'>please write number!!</font>";
		flag = 0;
	}else {
		document.getElementById("prizeSpan").innerHTML = "";
		flag += 1;
	}
	
	if( flag==4 ){
		document.update_form.submit();					
	}
	
}
		



function do_back(){
	window.history.back();
}