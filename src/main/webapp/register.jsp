<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang = "eng">
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style>
body{
            background-image: url(image/book.jpg);
            background-repeat: no-repeat;
            background-size: cover;
            color: white;
        }
.register{
            border-style:solid;
            border-color:threedlightshadow;
            position: absolute;
            top: 120px;
            right: 40%;
            padding-right: 30px;
            padding-left: 30px;
            padding-bottom: 10px;
            
}
button{

    padding: 7px;
  	border-radius: 4px;
  	background-color: GoldenRod;
  	color: black;
  	font-weight: bold;
  	border-color: transparent;
}
button:hover{
opacity: 0.7;
  	color: gold;
  	font-weight: bold;
}
 a{
            text-decoration: none;
            color: white;
}
        
  h1{
    text-align: center;
  }
  </style>
</head>
<body>

<form action="RegisterServlet" method="post">
<h1>Register Here!...</h1>
<div class="register">
        <h2>Sign In!...</h2>
        <label for="username">User Name :</label><br>
        <input type="text" name="username" class="username" pattern="[A-Za-z]{5,}" required><br><br>
        <label for="phonenumber">Phone number :</label><br>
        <input type="phone" name="phonenumber" class="phonenumber" pattern="[6-9][0-9]{9}" required><br><br>
        <label for="email">Email Id :</label><br>
        <input type="text" name="email" class="email" pattern="[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}" required><br><br>
        <label for="address">Address :</label><br>
        <input type="text" name="address" class="address" pattern="[A-Za-z0-9]{4,}+[,][A-Za-z]{4,}+[,][0-9]{6}+{20,}" required><br><br>
        <label for="password">Password :</label><br>
        <input type="text" name="password" class="password" pattern="[A-Za-z0-9]{8,10}"  required><br><br>
        <label for="password">Repeat Password :</label><br>
        <input type="password" name="repeat" class="repeat"  pattern="[A-Za-z0-9]{8,10}" required><br><br>
        <button type="submit" class ="sign">Sign in </button>
 </div>
</form>
</body>
</html>