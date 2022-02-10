<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="eng">
<head>
<meta charset="ISO-8859-1">
<title>USERS LIST PAGE</title>
<style>
body {
	background-image: url(image/new8.jpg);
	background-repeat: no-repeat;
	background-size: 1400px 625px;
	color: white;
	background-attachment: fixed;
}

* {
	margin: 0;
	padding: 0;
}

.nav {
	list-style: none;
	background: linear-gradient(to bottom, #33cccc 7%, #006666 74%);
	color: black;
	margin-top: 10px;
}

li {
	display: inline-block;
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: center;
	font-size: 13px;
}

li a:hover {
	opacity: 0.6;
	color: black;
	font-weight: bold;
}

li a {
	text-decoration: none;
	color: white;
	display: block;
	padding-right: 55px;
	padding-left: 56px;
}

a:hover {
	opacity: 0.6;
	font-weight: bold;
}

table {
	border: solid silver;
	margin: 30px 50px;
	background-color: rgba(0, 0, 0, 0.4);
}

td {
	padding: 10px;
	font-weight: bold;
	font-size: 17px;
}

th {
	font-weight: bold;
	font-size: 18px;
}

button {
	padding: 5px;
	border-radius: 4px;
	background: linear-gradient(to bottom, #33ccff 45%, #006666 100%);
	color: white;
	font-weight: bold;
	border-color: transparent;
}

h1 {
	text-align: center;
}

input {
	padding: 5px;
	border-radius: 4px;
}
</style>
</head>
<body>
	<div class="nav">
		<ul>
			<li><a href="admin.jsp">Home</a></li>
			<li><a href="addBooks.jsp">Add Books</a></li>
			<li><a href="updateBook.jsp">Update Book</a></li>
			<li><a href="ViewAllBookServlets">All Books</a></li>
			<li><a href="addAuthor.jsp">Add Author</a></li>
			<li><a href="authorUpdate.jsp">Update Author</a></li>
			<li><a href="ViewAuthorServlet">View Author</a></li>
			<li><a href="ViewAllOrderServlet">View ALL Orders</a></li>
			<li><a href="CancelledOrdersServlet">Cancelled Orders</a></li>
		</ul>
	</div>
	<div class="head">
		<h1>All Users</h1>
		<form action="ViewParticularUserServlet">
			<label for="search"></label> <input type="text" name="search"
				id="search" class="text" placeholder="Enter email Id"> <a
				href=><button>Search</button></a>
		</form>
	</div>
	<div class="table">
		<table id="allusers">
			<caption></caption>
			<thead>
				<tr>
					<th id="sno">S.no</th>
					<th id="cusid">Customer ID</th>
					<th id="name">Name</th>
					<th id="phoneno">Phone No</th>
					<th id="address">Address</th>
					<th id="emailid">Email_id</th>
					<th id="password">Password</th>
					<th id="wallet">Wallet</th>
					<th id="role">Role</th>
					<th id="inactive">Inactive</th>
					<th id="active">Active</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="count" value="0" />
				<c:forEach items="${userlist}" var="userList">
					<c:set var="count" value="${count+1}" />
					<tr>
						<td>${count}</td>
						<td>${userList.cusId}</td>
						<td>${userList.name}</td>
						<td>${userList.phoneNo}</td>
						<td>${userList.address}</td>
						<td>${userList.emailId}</td>
						<td>${userList.password}</td>
						<td>${userList.wallet}</td>
						<td>${userList.role}</td>
						<td><a href="deleteuser?emailid=${userList.emailId}"><button>Inactive</button></a></td>
						<td><a href="activeuser?emailid=${userList.emailId}"><button>Active</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>