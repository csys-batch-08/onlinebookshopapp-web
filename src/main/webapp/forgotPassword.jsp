<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang = "eng">
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
<style>
body{
    background-image: url(image/book.jpg);
    background-repeat: no-repeat;
    background-size: cover;
    color: white;
}
.forgot{
    position: absolute;
    top: 140px;
    right: 40%;
    padding-right: 30px;
    padding-left: 30px;
    border-style: solid;
    border-color: silver;
    
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
h3{
font-size: 20px;
}

</style>
</head>
<body>
<form action="forgotpassword" method="post">
<div class="forgot">
<h3>Reset your password here!...</h3>
<label for="userid">Email Id :</label><br>
<input type="text" class="textfield" name="userId" pattern="[a-z]+[0-9.]+[@][a-z]+[.][a-z]+{8,15}"><br><br>
<label for="pass" >Phone number :</label><br>
<input type="text"  name="mobNo"  class="textfield"pattern="[6-9][0-9]{9}"><br><br>
<label for="pass" >Password :</label><br>
<input type="password"  name="password" class="textfield" pattern="[A-Za-z0-9]{8,10}">

<br>
<br>                
<button type ="submit">Log In</button><br><br>
</div>
</form>
</body>
</html>