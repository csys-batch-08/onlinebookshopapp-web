<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html lang = "eng">
<head>
<meta charset="ISO-8859-1">
<title>USERS LIST PAGE</title>
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
.myprofile{
            border-style:solid;
            border-color:silver;
            position: absolute;
            top: 120px;
            right: 20%;
            padding-right: 30px;
            padding-left: 30px;
            padding-top: 20px;
            padding-bottom:20px;
            
        }
        
        pre{
        size: 50px;
        }
button{

    padding: 10px;
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
      padding-left: 67px;
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
  h2{
  padding-left: 500px;
  }
</style>
<body>

<div class="nav">
    <ul>
        <li><a href="ShowBookServlet">Home</a></li>
        <li><a href="ShowCartServlet" class="set1">My Cart</a></li>
        <li><a href="rechargeWallet.jsp">Recharge Wallet</a><li>
        
        <li><a href="ViewMyOrderServlet">View My Order</a></li>
        <li><a href="FilterByConditionServlet">Old Books</a></li>
        <li><a href="login.jsp">Log Out</a></li>
        
    </ul>
</div>
<h2>Books Wagon</h2>
<div>


<c:set var="count" value="1"/>
<c:forEach items="${userlist}" var="user">

<c:set var="count" value="${count+1}"/>


<div class = "myprofile">

<pre><strong>Name         :  </strong>${user.name}<br>
<strong>Phone No     :  </strong>${user.phoneNo}<br>
<strong>Address      :  </strong>${user.address}<br>
<strong>Email_id     :  </strong>${user.emailid}<br>
<strong>Password     :  </strong>${user.password}<br>
<strong>Wallet       :  </strong>${user.wallet}<br></pre>

<a href="updateProfile.jsp"><button type="submit">Update Profile</button></a>
</div>

</c:forEach>
</div>
 
</body>
</html>