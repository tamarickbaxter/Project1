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
	if(user.roleId == 1){
		document.getElementById("role").innerHTML = "Role: Finance Manager";
		displayPendingButton();
	}
	else
		document.getElementById("role").innerHTML = "Role: Employee";
}

function getTicketInfo() {

	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let t = JSON.parse(xhttp.responseText);
			setTicketValues(t);
		}
	}

	xhttp.open("GET", 'http://localhost:8080/EmployeeReimbursementSystem/html/LoadTickets.do',
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
		if(t[counter].status==0)
			cell8.innerHTML = "Pending";
		else if(t[counter].status==1)
			cell8.innerHTML = "Approved";
		else
			cell8.innerHTML = "Denied";
		if(t[counter].type==0)
			cell9.innerHTML = "Lodging";
		else if(t[counter].type==1)
			cell9.innerHTML = "Travel";
		else if(t[counter].type==2)
			cell9.innerHTML = "Food";
		else
			cell9.innerHTML = "Other";
		counter++;
	}	
}

function displayPendingButton(){
	let bt = document.getElementById("pending_button");
	bt.innerHTML = "<button id='pend_button' class='btn btn-primary'>View All Pending Tickets</a>";	
	document.getElementById('pend_button').addEventListener("mousedown",getAllPending);
}



function getAllPending() {

	let xhttp3 = new XMLHttpRequest();
	xhttp3.onreadystatechange = function() {
		if (xhttp3.readyState == 4 && xhttp3.status == 200) {
			let p = JSON.parse(xhttp3.responseText);
			displayAllPending(p);
		}
	}

	xhttp3.open("GET", 'http://localhost:8080/EmployeeReimbursementSystem/html/LoadPendingTickets.do',
			true);
	xhttp3.send();

}

function displayAllPending(p){
	let place = document.getElementById("pending");
	place.innerHTML = "<table id='pending_tickets'>" +
			"<tr class='table_headers'>"+
				"<th>Ticket ID</th>"+
				"<th>Amount</th>"+
				"<th>Submitted</th>"+
				"<th>Resolved</th> "+
				"<th>Description</th> "+
				"<th>Author</th> "+
				"<th>Resolver</th> "+
				"<th>Status</th> "+
				"<th>Type</th> "+
			"</tr></table>";
	
	let counter = 0;
	let tb = document.getElementById("pending_tickets");
	
	for(i in p){
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
		let cell10 = row.insertCell(9);
		let cell11 = row.insertCell(10);
		cell1.innerHTML = p[counter].id;
		cell1.id = 'ticketId'+counter;
		cell2.innerHTML = p[counter].amount;
		cell3.innerHTML = p[counter].timestamp;
		cell4.innerHTML = p[counter].resolved;
		cell5.innerHTML = p[counter].description;
		cell6.innerHTML = p[counter].author;
		cell7.innerHTML = p[counter].resolver;
		if(p[counter].status==0)
			cell8.innerHTML = "Pending";
		else if(p[counter].status==1)
			cell8.innerHTML = "Approved";
		else
			cell8.innerHTML = "Denied";
		if(p[counter].type==0)
			cell9.innerHTML = "Lodging";
		else if(p[counter].type==1)
			cell9.innerHTML = "Travel";
		else if(p[counter].type==2)
			cell9.innerHTML = "Food";
		else
			cell9.innerHTML = "Other";
		cell10.innerHTML = "<button id='approve_btn"+counter+"' class='btn btn-primary'>Approve</a>";	
		cell11.innerHTML = "<button id='deny_btn"+counter+"' class='btn btn-danger'>Deny</a>";	
		document.getElementById('approve_btn'+counter).addEventListener("click",approve);
		document.getElementById('deny_btn'+counter).addEventListener("click",deny);
		counter++;
	}
}


function approve(event){
	
	
	let num = event.target.id.substr(event.target.id.length-1);
	let ticket = document.getElementById('ticketId'+num);
	let ticketId = ticket.innerHTML;
	
	let xhttp4 = new XMLHttpRequest();
	xhttp4.onreadystatechange = function() {
		if (xhttp4.readyState == 4 && xhttp4.status == 200) {
			//let p = JSON.parse(xhttp4.responseText);
			console.log('submitted ticket approval '+ticketId);
		}
	}

	xhttp4.open("POST", 'http://localhost:8080/EmployeeReimbursementSystem/html/Approve.do',
			true);
	xhttp4.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp4.send("ticketId="+ticketId);
	
}

function deny(event){
	
	let num = event.target.id.substr(event.target.id.length-1);
	let ticket = document.getElementById('ticketId'+num);
	let ticketId = ticket.innerHTML;
	
	let xhttp4 = new XMLHttpRequest();
	xhttp4.onreadystatechange = function() {
		if (xhttp4.readyState == 4 && xhttp4.status == 200) {
			//let p = JSON.parse(xhttp4.responseText);
			console.log('submitted ticket approval '+ticketId);
		}
	}
	
	xhttp4.open("POST", 'http://localhost:8080/EmployeeReimbursementSystem/html/Deny.do',
			true);
	xhttp4.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp4.send("ticketId="+ticketId);
	
}