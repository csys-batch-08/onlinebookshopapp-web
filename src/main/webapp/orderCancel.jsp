<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="eng">
<head>
<meta charset="ISO-8859-1">
<title>Order Cancel</title>
<style>
body {
	background-image: url(image/book.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	color: white;
}

a {
	text-decoration: none;
	color: white;
}

ul {
	list-style: none;
	background-color: SaddleBrown;
	margin: 0;
	color: black;
	width: 136.3%;
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
	padding-left: 55px;
}

li a:hover {
	opacity: 0.7;
	color: black;
	font-weight: bold;
}

a:hover {
	opacity: 0.7;
	color: gold;
	font-weight: bold;
}

.set1 {
	margin-right: 10px;
}

h1 {
	text-align: center;
	padding-top: 150px;
}

h3 {
	text-align: center;
}
</style>
</head>
<body>
	<div class="nav">
		<ul>
			<li><a href="ShowBookServlet" class="set1">Home</a></li>
			<li><a href="ShowCartServlet">My Cart</a></li>
			<li><a href="MyProfileServlet">User profile</a></li>
			<li><a href="ViewMyOrderServlet">View My Order</a></li>
			<li><a href="FilterByConditionServlet">Old Books</a></li>
			<li><a href="login.jsp">Log Out</a></li>
		</ul>
	</div>
	<h1>Order Cancel Successfully!!</h1>
	<h3>Your amount refunded successfully....</h3>
	<h3>Available Wallet Balance :${availbalance}</h3>
</body>
</html>