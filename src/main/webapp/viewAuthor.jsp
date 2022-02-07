<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="eng">
<head>
<meta charset="ISO-8859-1">
<title>AUTHOR LIST</title>
<style>
body {
	background-image: url(image/new8.jpg);
	background-repeat: no-repeat;
	background-size: 1400px 625px;
	color: white;
	background-image: fixed;
}

* {
	margin: 0;
	padding: 0;
}

ul {
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
	font-size: 15px;
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
	color: gold;
	font-weight: bold;
}

h2 {
	margin-top: 50px;
	text-align: center;
}

a {
	text-decoration: none;
	color: white;
}

table {
	margin-left: 480px;
	border-collapse: collapse;
	border: 2px solid silver;
	margin-top: 80px;
}

td, th {
	padding: 10px;
}

button {
	padding: 5px;
	border-radius: 4px;
	background: linear-gradient(to bottom, #33ccff 45%, #006666 100%);
	color: white;
	font-weight: bold;
	border-color: transparent;
}

button:hover {
	opacity: 0.6;
	background: linear-gradient(to bottom, #009999 0%, #33cccc 100%);
	font-weight: bold;
}

h1 {
	text-align: center;
}
</style>
</head>
<body>

	<ul>
		<li><a href="admin.jsp">Home</a></li>
		<li><a href="ViewUserServlet">View User</a></li>

		<li><a href="addBooks.jsp">Add Books</a></li>
		<li><a href="updateBook.jsp">Update Book</a></li>
		<li><a href="ViewAllBookServlet">All Books</a></li>

		<li><a href="addAuthor.jsp">Add Author</a></li>
		<li><a href="ViewAllOrderServlet">View ALL Orders</a></li>
		<li><a href="CancelledOrdersServlet">Cancelled Orders</a></li>
	</ul>

	<h1>Author List</h1>
	<table border="1" id="allusers">
		<caption></caption>
		<thead>
			<tr>
				<th id="sno">S.no</th>
				<th id="name">Name</th>
				<th id="emailid">Email id</th>
				<th id="bookid">Book id</th>
				<th id="action">Actions</th>
			</tr>
		</thead>

		<tbody>
		<tbody>
			<c:set var="count" value="0" />
			<c:forEach items="${authorlist}" var="viewAuthor">
				<c:set var="count" value="${count+1}" />

				<tr>


					<td>${count}</td>
					<td>${viewAuthor.name}</td>
					<td>${viewAuthor.emailid}</td>
					<td>${viewAuthor.bookid}</td>
					<td><a href="authorUpdate.jsp"><button>Update</button></a></td>
				</tr>

			</c:forEach>
		</tbody>
	</table>


</body>
</html>

