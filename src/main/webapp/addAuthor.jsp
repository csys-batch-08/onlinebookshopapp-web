<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="eng">
<head>
<meta charset="ISO-8859-1">
<title>Add Author</title>
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
	margin-top: 20px;
}

li {
	display: inline-block;
	padding-top: 16px;
	padding-bottom: 16px;
	text-align: center;
	font-size: 18px;
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
	padding-right: 38px;
	padding-left: 35px;
}

a:hover {
	opacity: 0.6;
	color: gold;
	font-weight: bold;
}

.addauthor {
	border-style: solid;
	border-color: silver;
	padding-right: 20px;
	padding-left: 40px;
	margin-top: 60px;
	margin-right: 570px;
	margin-left: 440px;
	padding-bottom: 10px;
	padding-top: 10px;
}

a {
	text-decoration: none;
	color: white;
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

h2 {
	margin-bottom: 10px;
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
		<li><a href="authorUpdate.jsp">Update Author</a></li>
		<li><a href="ViewAuthorServlet">View Author</a></li>
		<li><a href="ViewAllOrderServlet">View ALL Orders</a></li>
		<li><a href="CancelledOrdersServlet">Cancelled Orders</a></li>
	</ul>
	<form action="AddAuthor" method="post">
		<div class="addauthor">
			<h2>Add Author!...</h2>
			<label for="authorname">Name :</label><br> <input type="text"
				name="authorname" id="authorname" class="author" required><br>
			<br> <label for="email">Email_Id :</label><br> <input
				type="text" name="email" id="email" class="author" required><br>
			<br> <label for="bookname">Book Name :</label><br> <input
				type="text" name="bookname" id="bookname" class="author" required><br>
			<br>
			<button type="submit">Add</button>
		</div>
	</form>
</body>
</html>