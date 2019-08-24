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
//	console.log(t);
	let counter = 0;
	let tb = document.getElementById("tickets");
	for(i in t){
		let row = tb.insertRow(counter+1);
		let cell1 = row.insertCell(0);
		let cell2 = row.insertCell(1);
		let cell3 = row.insertCell(2);
		let cell4 = row.insertCell(3);
		let cell5 = row.insertCell(4);
		let cell6 = row.insertCell(5);
		let cell7 = row.insertCell(6);
		let cell8 = row.insertCell(7);
		let cell9 = row.insertCell(8);
		cell1.innerHTML = t[counter].id;
		cell2.innerHTML = t[counter].amount;
		cell3.innerHTML = t[counter].timestamp;
		cell4.innerHTML = t[counter].resolved;
		cell5.innerHTML = t[counter].description;
		cell6.innerHTML = t[counter].author;
		cell7.innerHTML = t[counter].resolver;
		cell8.innerHTML = t[counter].status;
		cell9.innerHTML = t[counter].type;
		counter++;
	}
}

function displayAllPending(){
	
}

