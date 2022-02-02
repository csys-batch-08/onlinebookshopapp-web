<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang = "eng">
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
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
        margin-top: 20px;
    }
  li{
      display:inline-block;
      padding-top: 16px;
      padding-bottom: 16px;
      text-align: center;
      font-size: 18px;
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
      padding-right: 38px;
      padding-left: 35px;
  }
 
  
  a:hover{
  	opacity: 0.6;
  	color: gold;
  	font-weight: bold;
  }
        
        h1{
        margin-top: 250px;
        }
        
</style>
</head>
<body>
<ul>
        <li><a href="ViewUserServlet">View User</a></li>
		
        <li><a href="addBooks.jsp">Add Books</a></li>
		<li><a href="updateBook.jsp">Update Book</a></li>
		<li><a href="ViewAllBookServlet">All Books</a></li>
		
		<li><a href="addAuthor.jsp">Add Author</a></li>
		<li><a href="authorUpdate.jsp">Update Author</a></li>
		<li><a href="ViewAuthorServlet">View Author</a></li>
		
		<li><a href="ViewAllOrderServlet">View ALL Orders</a></li>
		<li><a href="CancelledOrdersServlet">Cancelled Orders</a></li>
</ul>
	
	<marquee><h1>Welcome Admin!...</h1></marquee>
</body>
</html>