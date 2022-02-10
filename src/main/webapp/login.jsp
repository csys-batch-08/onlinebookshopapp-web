<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="eng">
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>
<style>
body {
	background-image: url(image/book.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	color: white;
}
.login {
	border-style: solid;
	border-color: threedlightshadow;
	position: absolute;
	top: 140px;
	right: 40%;
	padding-right: 30px;
	padding-left: 30px;
}

button {
	padding: 7px;
	border-radius: 4px;
	background-color: GoldenRod;
	color: black;
	font-weight: bold;
	border-color: transparent;
}

button:hover {
	opacity: 0.7;
	color: gold;
	font-weight: bold;
}

a {
	text-decoration: none;
	color: white;
}
</style>
</head>
<body>
	<form action="LoginServlet" method="post">
		<div class="login">
			<h2>Log in</h2>
			<label for="emailid">Email Id :</label><br> <input type="text"
				name="emailid" id="emailid" class="emailid"
				pattern="[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}" required><br>
			<br> <label for="password">Password :</label><br> <input
				type="password" name="password" id="password" class="password"
				pattern="[A-Za-z0-9]{8,10}" required><br> <br>
			<button type="submit">Log In</button>
			<br> <br> <a href="forgotPassword.jsp">Forgot
				password??</a><br> <br>
			<p>
				Don't have an account??... <a href="register.jsp">Register</a>
			</p>
			<c:if test="${sessionScope.login!=null}">
				<h4>${sessionScope.login}</h4>
			</c:if>
			<c:remove var="login" scope="session" />
		</div>
	</form>
</body>
</html>