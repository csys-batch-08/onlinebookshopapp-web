<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="eng">
<head>
<meta charset="ISO-8859-1">
<title>cart success</title>
<style>
body {
	background-image: url(image/book.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	color: white;
}

h1 {
	margin-left: 380px;
	padding-top: 200px;
}

h2 {
	margin-left: 490px
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
	position: fixed;
}

li {
	display: inline-block;
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: center;
	font-size: 17px;
}

li a:hover {
	opacity: 0.7;
	color: black;
	font-weight: bold;
}

li a {
	text-decoration: none;
	color: white;
	display: block;
	padding-right: 54px;
	padding-left: 54px;
}

li  button {
	margin-right: 350px;
}

.set1 {
	margin-right: 10px;
}

.text {
	padding: 7px;
	border-radius: 4px;
	border-color: transparent;
}

li button {
	padding: 5.5px;
	border-radius: 4px;
	background-color: SandyBrown;
	color: White;
	font-weight: bold;
	border-color: transparent;
}

a:hover {
	opacity: 0.7;
	color: gold;
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="nav">
		<ul>
			<li><a href="ShowBookServlet" class="set1">Home</a></li>
			<li><a href="ShowCartServlet">My Cart</a></li>
			<li><a href="MyProfileServlet">User profile</a></li>
			<li><a href="rechargeWallet.jsp">Recharge Wallet</a></li>
			<li><a href="ViewMyOrderServlet">View My Order</a></li>
			<li><a href="FilterByConditionServlet">Old Books</a></li>
			<li><a href="login.jsp">Log Out</a></li>
		</ul>
	</div>
	<h1>Item added to cart successfully!!</h1>
</body>
</html>