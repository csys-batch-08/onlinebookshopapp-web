<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang = "eng">
<head>
<meta charset="ISO-8859-1">
<title>Delete User</title>
<style>
body{
    background-image: url(image/new8.jpg);
    background-repeat: no-repeat;
    background-size:1400px 625px;
    color: white;
    background-image: fixed;
}
*{
			margin:0;
			padding:0;
		}
ul
    {
        list-style: none;
          background: linear-gradient(to bottom, #33cccc 7%, #006666 74%);
        color: black;
        position: fixed;
        margin-bottom: 300px;
    }
  li{
      display:inline-block;
      padding-top: 12px;
      padding-bottom: 12px;
      text-align: center;
      font-size: 15px;
  }
  li a:hover{
  	opacity: 0.6;
  	color: black;
  	font-weight: bold;
  }
  li a{
      text-decoration: none;
      color:white;
      display:block;
      padding-right: 35px;
      padding-left: 35px;
  }
 
  
  a:hover{
  	opacity: 0.6;
  	color: gold;
  	font-weight: bold;
  }
        h2{
        margin-top:50px;
        text-align: center;
        
        }
        h1{
        margin-top: 100px;
        }
        
.delete{
    border-style:solid;
    border-color:threedlightshadow;
    position: absolute;
    top: 140px;
    right: 40%;
    padding: 30px 30px;
    
    
}
button{

    padding: 5px;
  	border-radius: 4px;
  	background: linear-gradient(to bottom, #33ccff 45%, #006666 100%);
  	color: white;
  	font-weight: bold;
  	border-color: transparent;
}
button:hover{
    opacity: 0.7;
  	background: linear-gradient(to bottom, #33cccc -1%, #006666 103%);
  	font-weight: bold;
}
a{
    text-decoration: none;
    color: white;
}
input {

	height: 25px;
}
           
</style>
</head>
<body>

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

 <h2>Books Wagon</h2>

<form action="deleteuser" method="post">

<div class="delete">

 <h4>Delete User  :</h4><br>
<label for="emailid">User Email Id :</label><br><br>
<input type="text" name="emailid" class="emailid"  pattern="[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}" required><br><br>
<button type="submit">Delete</button>
</div>

</form>
</body>
</html>