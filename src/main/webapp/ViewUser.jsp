<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USERS LIST PAGE</title>
<style>
body {
	background-image: url(image/new4.jpg);
	background-repeat: no-repeat;
	background-size: 2000px 2470px;
	color: black;
	font-weight: 100px;
}

* {
	margin: 0;
	padding: 0;
}

ul {
	list-style: none;
	background-color: #1c1c1c;
	margin: 0;
}

li {
	display: inline-block;
	padding-top: 10px;
	padding-bottom: 10px;
	text-align: center;
	font-size: 17px;
}

li a {
	text-decoration: none;
	color: white;
	display: block;
	padding-right: 40px;
	padding-left: 7px;
}

li  button {
	margin-right: 500px;
}

h2 {
	margin-top: 50px;
	text-align: center;
}

h1 {
	margin-top: 100px;
}

table {
	border: 2px solid black;
	margin: 10px 100px;
}

th, td {
	border: 2px solid black;
	border-collapse: collapse;
	padding: 10px;
	font-weight: bold;
}

h2 {
	text-align: center;
}
</style>
</head>
<body>
	<aside>
		<ul>
			<li><a href="ViewUser.jsp">View User</a></li>
			<li><a href="DeleteUser.jsp">Delete User</a></li>

			<li><a href="AddBooks.jsp">Add Books</a></li>
			<li><a href="UpdateBook.jsp">Update Book</a></li>
			<li><a href="ViewAllBook.jsp">All Books</a></li>

			<li><a href="AddAuthor.jsp">Add Author</a></li>
			<li><a href="AuthorUpdate.jsp">Update Author</a></li>
			<li><a href="ViewAuthor.jsp">View Author</a></li>

			<li><a href="ViewAllOrders.jsp">View ALL Orders</a></li>
		</ul>
	</aside>
	<h2>Books Wagon</h2>

	

	<div class="table">
		<table id="allusers">
			<thead>
				<tr>
					<th>S.no</th>
					<th>Customer ID</th>
					<th>Name</th>
					<th>Phone No</th>
					<th>Address</th>
					<th>Email_id</th>
					<th>Password</th>
					<th>Wallet</th>
					<th>Role</th>
					<th>Inactive</th>
					<th>Active</th>
				</tr>
			</thead>
			<br>
			<br>

			<tbody>
				<c:set var="count" value="0" />
				<c:forEach items="${userlist}" var="userList">
					<c:set var="count" value="${count+1}" />

					<tr>


						<td>${count}</td>

						<td>${userList.cusid}</td>
						<td>${userList.name}</td>
						<td>${userList.phoneNo}</td>
						<td>${userList.address}</td>
						<td>${userList.emailid}</td>
						<td>${userList.password}</td>
						<td>${userList.wallet}</td>
						<td>${userList.role}</td>
						<td><a href="deleteuser?emailid=${userList.emailid}"><button>Inactive</button></a></td>
						<td><a href="activeuser?emailid=${userList.emailid}"><button>Active</button></a></td>
					</tr>

				</c:forEach>

			</tbody>
		</table>


	</div>

</body>
</html>