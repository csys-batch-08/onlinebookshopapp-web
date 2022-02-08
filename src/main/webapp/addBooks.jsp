<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="eng">
<head>
<meta charset="ISO-8859-1">
<title>Add Books</title>
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

h2 {
	margin-top: 50px;
	text-align: center;
}

h1 {
	margin-top: 100px;
}

form {
	border-style: solid;
	border-color: silver;
	padding-right: 20px;
	padding-left: 40px;
	margin-top: 60px;
	margin-right: 470px;
	margin-left: 440px;
	padding-bottom: 10px;
	padding-top: 10px;
}

.category {
	margin-left: 40px;
}

.description {
	margin-left: 22px;
}

.booktitle {
	margin-left: 32px;
}

.bookcode {
	margin-left: 24px;
}

.price {
	margin-left: 62px;
}

.publishdate {
	margin-left: 14px;
}

.condition {
	margin-left: 30px;
}

.image {
	margin-left: 53px;
}

input[type=text] {
	border-top: none;
	border-right: none;
	padding-right: 20px;
	padding-top: 7px;
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
</style>
</head>
<body>
	<ul>
		<li><a href="admin.jsp">Home</a></li>
		<li><a href="ViewUserServlet">View User</a></li>
		<li><a href="updateBook.jsp">Update Book</a></li>
		<li><a href="ViewAllBookServlet">All Books</a></li>
		<li><a href="addAuthor.jsp">Add Author</a></li>
		<li><a href="authorUpdate.jsp">Update Author</a></li>
		<li><a href="ViewAuthorServlet">View Author</a></li>
		<li><a href="ViewAllOrderServlet">View ALL Orders</a></li>
		<li><a href="CancelledOrdersServlet">Cancelled Orders</a></li>
	</ul>
	<form action="AddBooks" method="post">
		<h3>Add Books !...</h3>
		<br> <label for="category">Category :</label> <input type="text"
			name="category" id="category" class="category" pattern="[A-Z a-z]+"
			required><br>
		<br> <label for="description">Description : </label> <input
			type="text" name="description" id="description" class="description"
			pattern="[A-Z a-z ,]{6,}" required><br>
		<br> <label for="booktitle">Book title :</label> <input
			type="text" name="booktitle" id="booktitle" class="booktitle"
			pattern="[A-z a-z,]{5,}" required><br>
		<br> <label for="bookcode">Book Code :</label> <input type="text"
			name="bookcode" id="bookcode" class="bookcode"
			pattern="[A-Z]+[0-9]{2,5}" required><br>
		<br> <label for="price">Price :</label> <input type="text"
			name="price" id="price" class="price" Pattern="[1-9][0-9]+"
			maxlength="5" required><br>
		<br> <label for="publishdate">Publish Date :</label> <input
			type="date" name="publishdate" id="publishdate" class="publishdate"
			required><br>
		<br> <label for="condition">Condition :</label> <input
			type="text" name="condition" id="condition" class="condition"
			pattern="[A-Za-z]{3,10}" required><br>
		<br> <label for="image">Image :</label> <input type="file"
			name="image" id="image" class="image" required><br>
		<br>
		<button type="submit">Add</button>
	</form>
</body>
</html>