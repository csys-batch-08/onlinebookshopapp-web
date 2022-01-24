<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Author Update</title>
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
        
fieldset{
    position: absolute;
    top: 140px;
    right: 40%;
    padding-right: 30px;
    padding-left: 30px;
    
}
a{
    text-decoration: none;
    color: white;
}</style>
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
 
<form action="updateauthor" method="post">
<fieldset>
<label for="emailid">Email Id :</label><br>
<input type="text" name="emailid" class="emailid" pattern="[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}"  required><br><br>
<label for="authorname">Author Name :</label><br>
<input type="text" name="authorname" class="authorname" pattern="[A-Za-z]{5,}" required><br><br>
<button type="submit">Update Author</button>
</fieldset>
</form>
</body>
</html>