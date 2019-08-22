/**
 * 
 */
window.onload = function() {
	getUserInfo();
}

function getUserInfo() {

	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let user = JSON.parse(xhttp.responseText);
			console.log(user)
			setValues(user);
		}
	}

	xhttp.open("GET", 'http://localhost:8080/EmployeeReimbursementSystem/html/Home.do',
			true);
	xhttp.send();

}

function setValues(user){
	console.log(user);
	document.getElementById("username").innerHTML = "Username: " + user.username;
	document.getElementById("role").innerHTML = "Role: " + user.role;
}