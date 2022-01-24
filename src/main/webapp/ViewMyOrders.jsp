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
    background-image: url(image/book.jpg);
    background-repeat:repeat;
    color:white;
    background-size:cover;
    background-attachment: fixed;
    font-weight: 1000;
    font-size: 18px;
    font-weight:bold; 
   
     
}
ul
    {
        list-style: none;
        background-color:SaddleBrown;
        margin:0;
        color: black;
        width: 136.3%;
         position: fixed;
    }
  li{
      display:inline-block;
      padding-top: 12px;
      padding-bottom: 12px;
      text-align: center;
      font-size: 17px;
  }
  li a{
      text-decoration: none;
      color:white;
      display:block;
      padding-right: 40px;
      padding-left: 60px;
  }
   li a:hover{
  	opacity: 0.7;
  	color: black;
  	font-weight: bold;
  }
  button:hover{
   opacity: 0.7;
   color: gold;
   font-weight: bold;
  }
 
.set1 {
	margin-right: 10px;
}
  h3{
  margin-left: 600px;  
  font-size: 30px;
  }
  table {
    
	margin-left: 380px;
	top: 5px;
}
table,td,th{
border: 1px solid black;
padding: 6px 6px;
margin-top: 5px;

}

  
</style>
</head>
<body>
<div class="nav">
    <ul>       
        <li><a href="ShowBook.jsp">Home</a></li>   
        <li><a href="ShowCart.jsp" class="set1">My Cart</a></li>
        <li><a href="MyProfile.jsp">User profile</a></li>
        <li><a href="RechargeWallet.jsp">Recharge Wallet</a><li>
        
        <li><a href="FilterByCondition.jsp">Old Books</a></li>
        <li><a href="login.jsp">Log Out</a></li>
        
    </ul>
</div>

<%
int userid = (int) session.getAttribute("userId");
        OrderDetailsDaoimpl orderdao = new OrderDetailsDaoimpl();
        List<OrderDetails> orderList = new ArrayList<OrderDetails>();
        orderList = orderdao.viewUserOrder(userid);
%>

<div>
<h3>My Orders</h3>
<table id="allusers">
<thead>
<tr>
  <th >S.no</th>

<th>Book Id</th>
<th>Quantity</th>
<th>Total Cost</th>
<th>Order Date</th>
<th>Status</th>
<th>Cancel Order</th>
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

<td><%=viewOrder.getBook_id()%></td>
<td><%=viewOrder.getQuantity()%></td>
<td><%=viewOrder.getTotal_cost()%></td>
<td><%=viewOrder.getOrder_date()%></td>
<td><%=viewOrder.getStatus() %></td>
<td><span><a href = "cancelorder?orderid=<%=viewOrder.getOrder_id()%>"><button>Cancel</button></a></span><td>
</tr>

<%
}
%>


</tbody>
          </table>


</div><br><br>
              
</body>
</html>
