<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Book</title>
<style>
body{
    background-image: url(image/new4.jpg);
    background-repeat: no-repeat;
    background-size: 2000px 2470px;
    color:black;
    font-weight: 100px;
}
*{
			margin:0;
			padding:0;
		}
ul
    {
        list-style: none;
        background-color: #1c1c1c;
        margin:0;
    }
  li{
      display:inline-block;
      padding-top: 10px;
      padding-bottom: 10px;
      text-align: center;
      font-size: 17px;
  }
  li a{
      text-decoration: none;
      color:white;
      display:block;
      padding-right: 40px;
      padding-left: 7px;
  }
 li  button{
      margin-right: 500px;
  }
        h2{
        margin-top:50px;
        text-align: center;
        
        }
        h1{
        margin-top: 100px;
        }
         .set        {
        	margin: 100px 400px;
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

<form action="updatebook" method="post">
<div class="set">
<h4>Update Book :</h4><br>
<label for="booktitle">Book title :</label>
<input type="text" name="booktitle" id="booktitle" class="booktitle" required><br><br>

<label for="price">Price :</label>
<input type="text" name="price" id="price" class="price" required><br><br>

<button type ="submit">update</button>
</fieldset>
</form>
</div>
</body>
</html>