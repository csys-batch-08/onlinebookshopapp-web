<%@page import="com.onlinebookshop.model.Userdetails"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recharge Wallet</title>

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

img{
width: 250px;
padding:20px;
border-radius: 14%;
margin-left: 10px;


}

fieldset {

	position: absolute;
	top: 180px;
	right: 360px;
	padding-right: 30px;
	padding-left: 30px;
	
}

button{

   padding: 10px;
  	border-radius: 4px;
  	background-color: GoldenRod;
  	color: White;
  	font-weight: bold;
  	border-color: transparent;
}
  a:hover{
  	opacity: 0.7;
  	color: Gold;
  	font-weight: bold;
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
.cat{
     padding-right: 45px;
  }
   .desc{
     padding-right: 25px;
  }
  .title{
     padding-right: 32px;
  }
  .price{
     padding-right: 89px;
  }
  .date{
     padding-right: 15px;
  }
  .condition{
     padding-right: 43px;
  }
  .aname{
     padding-right: 11px;
  }
  .aemail{
     padding-right: 10px;
  }
  .rating{
     padding-right: 77px;
  }
  input[type=text]
        {
        	border-top: none;
        	border-right: none;
        	padding-right: 20px;
        	padding-top: 7px;
            
        }
  h2,h3{
  
  text-align: center;
  }
   </style>
</head>
<body>
<div class="nav">
    <ul>   
        <li><a href="ShowProduct.jsp">Show Product</a></li>      
        <li><a href="ShowCart.jsp" class="set1">My Cart</a></li>
        <li><a href="MyProfile.jsp">User profile</a></li>
        
        <li><a href="ViewMyOrders.jsp">View My Order</a></li>
        <li><a href="FilterByCondition.jsp">Old Books</a></li>
        <li><a href="login.jsp">Log Out</a></li>
        
    </ul>
</div>


<h2>Welcome ${currentuser.name}</h2>
<h3>Available Wallet : ${currentuser.wallet}</h3>

<form action="recharge" method="post">
    <fieldset class="signup">
       <h2>Recharge Your Wallet..</h2>

         <label for="Amount">Amount:</label><br>
         <input type="text" name="Amount" id="amount" placeholder="Enter Amount" Pattern="[1-9][0-9]+{1,5}"  ><br><br>
         
          
         <button type="submit">Recharge Wallet</button>
             
    </fieldset>
    </form>
</body>
</html>
