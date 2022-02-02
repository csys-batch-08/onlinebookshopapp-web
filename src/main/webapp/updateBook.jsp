<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang = "eng">
<head>
<meta charset="ISO-8859-1">
<title>Update Book</title>
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
      padding-right: 47px;
      padding-left: 47px;
  }
 
  
  a:hover{
  	opacity: 0.6;
  	color: gold;
  	font-weight: bold;
  }
        
         .set        {
        	margin: 100px 400px;
        }
        form
        {
        	
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
        .booktitle{
            margin-left: 32px;
        }
        
        .price{
           margin-left: 62px;
        } 
button{
    
    padding: 8px;
  	border-radius: 4px;
  	background: linear-gradient(to bottom, #33ccff 45%, #006666 100%);
  	color: white;
  	font-weight: bold;
  	border-color: transparent;
  	margin-right: 10px;
}
button:hover{
  	opacity: 0.6;
  	background: linear-gradient(to bottom, #009999 0%, #33cccc 100%);
  	font-weight: bold;
  }   
        
</style>
</head>
<body>

<ul>
        <li><a href="ViewUserServlet">View User</a></li>
		
        <li><a href="addBooks.jsp">Add Books</a></li>
		
		<li><a href="ViewAllBookServlet">All Books</a></li>		
		<li><a href="AddAuthor.jsp">Add Author</a></li>
		<li><a href="AuthorUpdate.jsp">Update Author</a></li>
		<li><a href="ViewAuthor.jsp">View Author</a></li>
		
		<li><a href="ViewAllOrders.jsp">View ALL Orders</a></li>
</ul>

<form action="updatebook" method="post">

<h1>Update Book!...</h1><br>
<label for="booktitle">Book title :</label>
<input type="text" name="booktitle" id="booktitle" class="booktitle" required><br><br>

<label for="price">Price :</label>
<input type="text" name="price" id="price" class="price" required><br><br>

<button type ="submit">update</button>

</form>

</body>
</html>