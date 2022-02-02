<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html lang = "eng">
<head>
<meta charset="ISO-8859-1">
<title>All Books</title>
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
      padding-right: 38px;
      padding-left: 35px;
  }
 
  
  a:hover{
  	opacity: 0.6;
  	color: gold;
  	font-weight: bold;
  }
  .alluser{
  
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
  	opacity: 0.6;
  	background: linear-gradient(to bottom, #009999 0%, #33cccc 100%);
  	font-weight: bold;
  }
           
</style>
</head>
<body>
<ul>
       <li><a href="ViewUser.jsp">View User</a></li>
		
        <li><a href="AddBooks.jsp">Add Books</a></li>
		<li><a href="UpdateBook.jsp">Update Book</a></li>
		<li><a href="ViewAllBook.jsp">All Books</a></li>
		
		<li><a href="AddAuthor.jsp">Add Author</a></li>
		<li><a href="AuthorUpdate.jsp">Update Author</a></li>
		<li><a href="ViewAuthor.jsp">View Author</a></li>
		
		<li><a href="ViewAllOrders.jsp">View ALL Orders</a></li>

</ul>

<div class="alluser">
<table border="2" id="allusers">
<thead>
<tr>
  <th id = "sno">S.no</th>
<th id = "bookid">Book Id</th>
<th id = "category">Category</th>
<th id = "description">Description</th>
<th id = "booktitle">Book Title</th>
<th id = "bookcode">Book Code</th>
<th id = "price">Price</th>
<th id = "publishdate">Publish Date</th>
<th id = "condition">Condition</th>
<th id = "bookimages">Book image</th>
<th id = "status">Status</th>
<th id = "delete">Delete</th>
</tr>
</thead>
<br>
<br>

<tbody>
<c:set var="count" value="0"/>
<c:forEach items="${viewAllBook}" var="viewallBook">
<c:set var="count" value="${count+1}"/>
<tr>

<td>${count}</td>

<td>${viewallBook.bookid}</td>
<td>${viewallBook.category}</td>
<td>${viewallBook.description}</td>
<td>${viewallBook.booktitle}</td>
<td>${viewallBook.bookcode}</td>
<td>${viewallBook.price}</td>
<td>${viewallBook.publishdate}</td>
<td>${viewallBook.condition}</td>
<td>${viewallBook.bookimages}</td>
<td>${viewallBook.status}</td>
 <td><a href = "DeleteBooks?bookid=${viewallBook.bookid}"><button>Remove</button></a></td>
</tr>

</c:forEach>

</tbody>
          </table>


</div>
 
</body>
</html>