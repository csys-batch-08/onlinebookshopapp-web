<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang = "eng">
<head>
<meta charset="ISO-8859-1">
<title>Profile Update</title>
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
  button{

    padding: 10px;
  	border-radius: 4px;
  	background-color: GoldenRod;
  	color: black;
  	font-weight: bold;
  	border-color: transparent;
}
 
.set1 {
	margin-right: 10px;
}
.profile{
    border-style:solid;
    border-color:threedlightshadow;
    position: absolute;
    top: 140px;
    right: 40%;
    padding-right: 30px;
    padding-left: 30px;
    
}
 </style>
</head>
<body>
<form action="updateprofile" method="post">
<div class="nav">
    <ul>
        
         <li><a href="ShowBookServlet" class="set1">Home</a></li>     
        <li><a href="ShowCartServlet">My Cart</a></li>
        <li><a href="MyProfileServlet">User profile</a></li>
        <li><a href="rechargeWallet.jsp">Recharge Wallet</a><li>
        <li><a href="ViewMyOrderServlet">View My Order</a></li>
        <li><a href="FilterByConditionServlet">Old Books</a></li>
        <li><a href="login.jsp">Log Out</a></li>
        
    </ul>
</div>
<div class = "profile">
<label for="name">Name :</label><br>
<input type="text" name="username" class="username" pattern="[A-Za-z]{5,}" required><br><br>
<label for="phoneno">Phone number :</label><br>
<input type="text" name="phoneno" class="phoneno" pattern="[6-9][0-9]{9}" required><br><br>
<label for="address">Address :</label><br>
<input type="text" name="address" class="address" pattern="[A-Za-z0-9]{4,}+[,][A-Za-z]{4,}+[,][0-9]{6}+{20,}" required><br><br>
<label for="email">Email ID :</label><br>
<input type="text" name="email" class="email" pattern="[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}" required><br><br>
<label for="password">Password :</label><br>
<input type="text" name="password" class="password" pattern="[A-Za-z0-9]{8,10}" required><br><br>
<button type="submit">Update</button>
</div>
</form>
</body>
</html>