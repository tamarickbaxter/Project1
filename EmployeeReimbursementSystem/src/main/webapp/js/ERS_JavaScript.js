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
			setValues(user);
		}
	}

	xhttp.open("GET", 'http://localhost:8080/EmployeeReimbursementSystem/html/Home.do',
			true);
	xhttp.send();

}

function setValues(user){
	document.getElementById("name").innerHTML = "Pet's name is " + user.name;
	document.getElementById("role").innerHTML = "Pet's type is " + user.role;
}