<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="eng">
<head>
<meta charset="ISO-8859-1">
<title>View Orders</title>
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
	padding-right: 57px;
	padding-left: 56px;
}

a:hover {
	opacity: 0.6;
	color: gold;
	font-weight: bold;
}

a {
	text-decoration: none;
	color: white;
}

.table {
	margin-top: 40px;
	margin-left: 450px;
}

th {
	padding: 10px;
}

td {
	padding: 10px;
}

h3 {
	text-align: center;
	margin-top: 20px;
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
		<li><a href="authorUpdate.jsp">Update Author</a></li>
		<li><a href="ViewAuthorServlet">View Author</a></li>
		<li><a href="ViewAllOrderServlet">View ALL Orders</a></li>
	</ul>
	<h3>All Orders</h3>
	<div class="table">
		<table id="allusers">
			<caption></caption>
			<thead>
				<tr>
					<th id="sno">S.no</th>
					<th id="cusid">Customer id</th>
					<th id="bookid">Book Id</th>
					<th id="quantity">Quantity</th>
					<th id="totalcost">Total Cost</th>
					<th id="orderdate">Order Date</th>
					<th id="status">Status</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="count" value="0" />
				<c:forEach items="${orderlist}" var="viewallorder">
					<c:set var="count" value="${count+1}" />
					<tr>
						<td>${count}</td>
						<td>${viewallorder.cusid}</td>
						<td>${viewallorder.bookid}</td>
						<td>${viewallorder.quantity}</td>
						<td>${viewallorder.totalcost}</td>
						<td><fmt:parseDate value="${viewallorder.orderdate}"
								pattern="yyyy-MM-dd" var="publishDate" type="date" /> <fmt:formatDate
								pattern="dd-MM-yyyy" value="${publishDate}" /></td>
						<td>${viewallorder.status}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>