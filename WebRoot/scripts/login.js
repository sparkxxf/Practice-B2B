/**
 * form check.
 */
function formCheck() {
	
	var username = document.getElementById('username').value;
	var password = document.getElementById('password').value;

	if(username.length == 0 && password.length == 0) {
		alert(usnpwdNotEmpty);
		return false;
	}
	if(username.length == 0) {
		alert(usnNotEmpty);
		return false;
	}
	if(password.length == 0) {
		alert(pwdNotEmpty);
		return false;
	}
	return true;
}
