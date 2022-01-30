 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="eng">
<head>
<meta charset="ISO-8859-1">
<title>Add Books</title>
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
        .books
        {
        	margin: 60px 400px;
        }
        
        h2{
            text-align: center;
        }
        
        .category{
            margin-left: 40px;
        }
        
        .description{
            margin-left: 22px;
        }
        
        .booktitle{
            margin-left: 32px;
        }
        
        .bookcode{
           margin-left: 24px;
        }
        
        .price{
           margin-left: 62px;
        }
        
        .publishdate{
           margin-left: 14px;
        }
        
        .condition{
           margin-left: 30px;
        }
        
        .image{
           margin-left: 53px;
        }
        button{
           margin-left: 100px;
           width: 60px;
           padding-top: 6px;
           padding-bottom: 6px;
        }
        input[type=text]
        {
        	border-top: none;
        	border-right: none;
        	padding-right: 20px;
        	padding-top: 7px;

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

<form action="AddBooks" method="post">
<div class="books">
<h4>Add Books :</h4><br>
<label for="category">Category :</label>
<input type="text" name="category" class="category" pattern="[A-Z a-z]+" required><br><br>
<label for="description">Description : </label>
<input type="text" name="description" class="description" pattern="[A-Z a-z ,]{6,}" required><br><br>
<label for="booktitle">Book title :</label>
<input type="text" name="booktitle" class="booktitle" pattern="[A-z a-z,]{5,}" required><br><br>
<label for="bookcode">Book Code :</label>
<input type="text" name="bookcode" class="bookcode" pattern="[A-Z]+[0-9]{2,5}" required><br><br>
<label for="price">Price :</label>
<input type="text" name="price" class="price" Pattern="[1-9][0-9]+" maxlength="5" required><br><br>
<label for="publishdate">Publish Date :</label>
<input type="date" name="publishdate" class="publishdate" required><br><br>
<label for="condition">Condition :</label>
<input type="text" name="condition" class="condition" pattern="[A-Za-z]{3,10}" required><br><br>
<label for="image">Image :</label>
<input type="file" name="image" class="image" required><br><br>
<button type ="submit">Add</button>
</div>
</form>
</body>
</html>