<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang = "eng">
<head>
<meta charset="ISO-8859-1">
<title>View Orders</title>
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
        margin-top:20px;
        text-align: center;
        
        }
        h1{
        margin-top: 70px;
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
}
table{
margin-top: 10px;
margin-left: 450px;
}
th{
padding: 10px;
}
td{
padding: 10px;
}
h3{
text-align: center;
margin-top: 20px;
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
		
		
</ul>
</aside>
 <h2>Books Wagon</h2>
 <h3>All Orders</h3>

<div>
<table border="2" id="allusers">
<thead>
<tr>
  <th id = "sno">S.no</th>
<th id = "cusid">Customer id</th>
<th id = "bookid">Book Id</th>
<th id = "quantity">Quantity</th>
<th id = "totalcost">Total Cost</th>
<th id = "orderdate">Order Date</th>
<th id = "status">Status</th>
</tr>
</thead>
<br>
<br>

<tbody>
<c:set var="count" value="0"/>
<c:forEach items="${orderlist}" var="viewallorder">
<c:set var="count" value="${count+1}"/>
<tr>


<td>${count}</td>

<td>${viewallorder.cusid}</td>
<td>${viewallorder.bookid}</td>
<td>${viewallorder.quantity}</td>
<td>${viewallorder.totalcost}</td>
<td>${viewallorder.orderdate}</td>
<td>${viewallorder.status}</td>
</tr>

</c:forEach>
</tbody>
          </table>


</div>
 
</body>
</html>