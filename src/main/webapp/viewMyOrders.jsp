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
* {
	margin: 0;
	padding: 0;
}

body {
	background-image: url(image/book.jpg);
	background-repeat: repeat;
	color: white;
	background-size: cover;
	background-attachment: fixed;
	font-weight: 1000;
	font-size: 18px;
	font-weight: bold;
}

ul {
	list-style: none;
	background-color: SaddleBrown;
	margin: 0;
	color: black;
	width: 136.3%;
	position: fixed;
}

li {
	display: inline-block;
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: center;
	font-size: 17px;
}

li a {
	text-decoration: none;
	color: white;
	display: block;
	padding-right: 40px;
	padding-left: 60px;
}

li a:hover {
	opacity: 0.7;
	color: black;
	font-weight: bold;
}

button:hover {
	opacity: 0.7;
	color: gold;
	font-weight: bold;
}

button {
	padding: 10px;
	border-radius: 4px;
	background-color: GoldenRod;
	color: black;
	font-weight: bold;
	border-color: transparent;
}

.set1 {
	margin-right: 10px;
}

h3 {
	margin-left: 600px;
	font-size: 30px;
	padding-top: 50px;
}

table {
	margin-left: 370px;
	top: 5px;
	border-style: solid;
	border-color: silver;
	background-color: rgba(0, 0, 0, 0.4);
}

table, td, th {
	padding: 6px 9px;
}

.user {
	
}
</style>
</head>
<body>
	<div class="nav">
		<ul>
			<li><a href="ShowBookServlet">Home</a></li>
			<li><a href="ShowCartServlet" class="set1">My Cart</a></li>
			<li><a href="MyProfileServlet">User profile</a></li>
			<li><a href="rechargeWallet.jsp">Recharge Wallet</a></li>
			<li><a href="FilterByConditionServlet">Old Books</a></li>
			<li><a href="login.jsp">Log Out</a></li>
		</ul>
	</div>
	<h3>My Orders</h3>
	<div class="user">
		<table id="allusers">
			<caption></caption>
			<thead>
				<tr>
					<th id="sno">S.no</th>
					<th id="bookid">Book Id</th>
					<th id="quantity">Quantity</th>
					<th id="totalcost">Total Cost</th>
					<th id="orderdate">Order Date</th>
					<th id="status">Status</th>
					<th id="cancel">Cancel Order</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="count" value="0" />
				<c:forEach items="${viewOrderList}" var="viewOrder">
					<c:set var="count" value="${count+1}" />
					<tr>
						<td>${count}</td>
						<td>${viewOrder.bookId}</td>
						<td>${viewOrder.quantity}</td>
						<td>${viewOrder.totalCost}</td>
						<td><fmt:parseDate value="${viewOrder.orderDate}"
								pattern="yyyy-MM-dd" var="orderedDate" type="date" /> <fmt:formatDate
								pattern="dd-MM-yyyy" value="${orderedDate}" /></td>
						<td>${viewOrder.status}</td>
						<td><span><a
								href="cancelorder?orderid=${viewOrder.orderId}"><button>Cancel</button></a></span>
						<td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br>
	<br>
</body>
</html>