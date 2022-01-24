<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Update</title>
<style>
body{
    background-image: url(image/book.jpg);
    background-repeat: no-repeat;
    background-size: 1350px 800px; 
    color: white;
}
fieldset{
            position: absolute;
            top: 120px;
            right: 40%;
            padding-right: 30px;
            padding-left: 30px;
            padding-top: 20px;
            padding-bottom:20px;
            
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
  
  .set1{
      margin-right: 10px;
  }
 </style>
</head>
<body>
<form action="updateprofile" method="post">
<div class="nav">
    <ul>
        
        <li><a href="ShowCart.jsp" class="set1">My Cart</a></li>
        <li><a href="MyProfile.jsp">User profile</a></li>
        <li><a href="RechargeWallet.jsp">Recharge Wallet</a><li>
        <li><a href="Ratings.jsp">Add Ratings</a></li>
        <li><a href="ViewMyOrders.jsp">View My Order</a></li>
        
    </ul>
</div>
<fieldset>
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
</fieldset>
</form>
</body>
</html>