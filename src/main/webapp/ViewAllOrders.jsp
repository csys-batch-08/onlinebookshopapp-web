<%@page import="com.onlinebookshop.model.OrderDetails"%>
<%@page import="com.onlinebookshop.daoimpl.OrderDetailsDaoimpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="com.onlinebookshop.model.Cart"%>
    <%@page import="java.util.*"%>
            <%@page import="com.onlinebookshop.daoimpl.CartDaoimpl"%>
 
<!DOCTYPE html>
<html>
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
<%

 OrderDetailsDaoimpl orderdao = new OrderDetailsDaoimpl();
        List<OrderDetails> orderList = new ArrayList<OrderDetails>();
        orderList = orderdao.viewOrder();
%>

<div>
<table border="2" id="allusers">
<thead>
<tr>
  <th >S.no</th>
<th>Customer id</th>
<th>Book Id</th>
<th>Quantity</th>
<th>Total Cost</th>
<th>Order Date</th>
<th>Status</th>
</tr>
</thead>
<br>
<br>

<tbody>
<%
int i = 0;
for (OrderDetails viewOrder : orderList) {
	i++;
%>
<tr>


<td><%=i%></td>
<td><%=viewOrder.getCusid()%></td>
<td><%=viewOrder.getBookid()%></td>
<td><%=viewOrder.getQuantity()%></td>
<td><%=viewOrder.getTotalcost()%></td>
<td><%=viewOrder.getOrderdate()%></td>
<td><%=viewOrder.getStatus() %></td>
</tr>

<%
}
%>
</tbody>
          </table>


</div>
 
</body>
</html>