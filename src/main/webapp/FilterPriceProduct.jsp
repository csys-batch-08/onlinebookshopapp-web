<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang ="eng">
<head>
<meta charset="ISO-8859-1">
<title>Filter by Price</title>
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

img{
width: 250px;
padding:20px;
border-radius: 14%;
margin-top: 50px;
margin-left:60px;

}
span{
position : relative;
top:280px;
left: -300px;
font-size: 16px;

}
table td{
padding-bottom: 60px;
}
b{
padding-right: 20px;
}
.book{
text-align: left;

}
.btn {
margin-right: 30px;
margin-left: 30px;
}
button{

   padding: 7px;
  	border-radius: 4px;
  	background-color: GoldenRod;
  	color: black;
  	font-weight: bold;
  	border-color: transparent;
}
 a:hover{
  	opacity: 0.7;
  	color: gold;
  	font-weight: bold;
  }

ul
    {
        list-style: none;
        background-color:SaddleBrown;
        margin:0;
        color: black;
        width: 97%;
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
      padding-left: 40px;
  }
   li a:hover{
  	opacity: 0.7;
  	color: black;
  	font-weight: bold;
  }
  
  .set1{
      margin-right: 10px;
  }
  .text{
  	padding: 7px;
  	border-radius: 4px;
  	border-color: transparent;
  }
  li button{
  	padding: 5.5px;
  	border-radius: 4px;
  	background-color: SandyBrown;
  	color: White;
  	font-weight: bold;
  	border-color: transparent;
  }
</style>
</head>
<body>
<form action="filterprice" method="post">
<div class="nav">
    <ul>
        <li><a href="ShowBook.jsp">Home</a></li>
        <li><a href="ShowCart.jsp" class="set1">My Cart</a></li>
        <li><a href="MyProfile.jsp">User profile</a></li>
        <li><a href="RechargeWallet.jsp">Recharge Wallet</a><li>
        
        <li><a href="ViewMyOrders.jsp">View My Order</a></li>
        <li><a href="FilterByCondition.jsp">Old Books</a></li>
        <li><a href="login.jsp">Log Out</a></li>
    </ul>
</div>
</form>
 
<table>
            <tbody>
                <tr>
                
                <c:set var="count" value="1"/>
                
                <c:forEach items="${filterpricelist}" var="filterPrice">
                	
                	%>
                    <td>
                        <table id="producttable">
                            <tbody>
                                <tr>
                                    <td><a href = "ShowProduct.jsp?BookId=${filterPrice.bookid}"><img src="image/${filterPrice.bookimages}" width=50 height=350 alt="book"></a></td>    
                                    <td class="book">
                                        <p><strong>CATEGORY   :   </strong>${filterPrice.category}<br></p>
                                        
                                        <p><strong>BOOK TITLE  :   </strong>${filterPrice.booktitle}<br></p>
                                        
                                        <p><strong>PRICE :  </strong>${filterPrice.price}<br></p>

                                         <p><strong>class="rating">RATINGS    :</strong>${filterPrice.rating}<br><br></p>
                                        
                                         
                                         
                                    </td>
                                </tr>
                            </tbody>
                        </table>  
                            
                    </td>
                        <c:choose>
                          <c:when test="${count==2}">
                              <c:set var="count" value="1"/>
                    	   </tr>
                    	   <tr> 
                    	   </c:when> 
                    	   <c:otherwise>
                    	   <c:set var="count" value="${count+1}"/>
                    	   </c:otherwise>            
                          
                       </c:choose>
                       </c:forEach> 
                       
                </tr>
            </tbody>
        </table>



</body>