<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang = "eng">
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="Register.css">
</head>
<body>

<form action="RegisterServlet" method="post">
<fieldset>
        <h2>Sign In</h2>
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
        <button type="submit">Sign in :</button>
    </fieldset>
</form>
</body>
</html>