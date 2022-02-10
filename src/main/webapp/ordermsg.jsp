<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang = "eng">
<head>
<meta charset="ISO-8859-1">
<title>Order success</title>
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
    position: fixed;
     
}

h1{
margin-left: 380px;
padding-top: 200px;
}
h2{
  margin-left: 490px
}
a{
    text-decoration: none;
    color: white;
}
button{

   padding: 7px;
  	border-radius: 4px;
  	background-color: GoldenRod;
  	color: black;
  	font-weight: bold;
  	border-color: transparent;
}
ul
    {
        list-style: none;
        background-color:SaddleBrown;
        margin:0;
        color: black;
        width: 136.3%;
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
      padding-left: 55px;
  }
   li a:hover{
  	opacity: 0.7;
  	color: black;
  	font-weight: bold;
  }
      a:hover{
  	opacity: 0.7;
  	color: gold;
  	font-weight: bold;
  }
  
 
  .set1{
      margin-right: 10px;
  }

</style>
</head>
<body>
<div class="nav">
    <ul>   
        <li><a href="ShowBookServlet" class="set1">Home</a></li>
        <li><a href="FilterByConditionServlet">Old Books</a></li>            
        <li><a href="ShowCartServlet">My Cart</a></li>
        <li><a href="MyProfileServlet">User profile</a></li>
        <li><a href="rechargeWallet.jsp">Recharge Wallet</a><li>
        <li><a href="ViewMyOrderServlet">View My Order</a></li>
        <li><a href="login.jsp">Log Out</a></li>
    </ul>
</div>
<h1>Your Order is successfully Placed !...</h1>
<h2>Available Balance : ${newwallet}</h2>
</body>
</html>