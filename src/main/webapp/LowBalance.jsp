<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang = "eng">
<head>
<meta charset="ISO-8859-1">
<title>Low Balance</title>
<style>
	
body{
    background-image: url(image/book.jpg);
    background-repeat:repeat;
    color:white;
    background-size:1700px 700px;
    background-attachment: fixed;
    font-weight: 1000; 
    font-size: 18px;
    font-weight:bold;  
}
h1{
text-align:center;
padding-top: 200px;
}
h2{
  margin-left: 490px
}
a{
    text-decoration: none;
    color: white;
}
ul
    {
        list-style: none;
        background-color:SaddleBrown;
        margin:0;
        color: black;
        position: fixed;
    }
  li{
      display:inline-block;
      padding-top: 12px;
      padding-bottom: 12px;
      text-align: center;
      font-size: 17px;
  }
  li a:hover{
  	opacity: 0.7;
  	color: black;
  	font-weight: bold;
  }
  li a{
      text-decoration: none;
      color:white;
      display:block;
      padding-right: 50px;
      padding-left: 47px;
  }  
  .set1{
      margin-right: 10px;
  }
  .text{
  	padding: 7px;
  	border-radius: 4px;
  	border-color: transparent;
  }
  
</style>
</head>
<body>
<div class="nav">
    <ul>        
        <li><a href="ShowBookServlet" class="set1">My Cart</a></li>
        <li><a href="ShowCartServlet" class="set1">My Cart</a></li>
        <li><a href="MyProfileServlet">User profile</a></li>
        <li><a href="RechargeWallet.jsp">Recharge Wallet</a><li>
        
        <li><a href="ViewMyOrderServlet">View My Order</a></li>
        <li><a href="FilterByConditionServlet">Old Books</a></li>
        <li><a href="login.jsp">Log Out</a></li>
        
        
    </ul>
</div>
<h1>NOT ENOUGH AMOUNT IN YOUR WALLET !...</h1>
<h2>Recharge Your Wallet..</h2>

<h2>Available Balance : ${availwallet}</h2>
</body>
</html>