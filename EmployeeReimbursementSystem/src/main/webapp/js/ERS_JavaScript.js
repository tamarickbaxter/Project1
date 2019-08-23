/**
 * 
 */
window.onload = function() {
	getUserInfo();
	getTicketInfo();
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
	//console.log(user);
	document.getElementById("name").innerHTML = "Welcome " + user.firstName;
	document.getElementById("role").innerHTML = "Role: " + user.roleId;
}

function getTicketInfo() {

	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let t = JSON.parse(xhttp.responseText);
			setTicketValues(t);
		}
	}

	xhttp.open("GET", 'http://localhost:8080/EmployeeReimbursementSystem/html/LoadTicket.do',
			true);
	xhttp.send();

}

function setTicketValues(t){
	//console.log(t);
	document.getElementById("ticket_amount").innerHTML = "Amount: " + t.amount;  ///to be changed
	document.getElementById("status").innerHTML = "Status: " + t.status;
}