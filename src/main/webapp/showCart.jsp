<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang = "eng">
<head>
<meta charset="ISO-8859-1">
<title>My Cart</title>
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

img{
width: 250px;
padding:20px;
border-radius: 14%;

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
      a:hover{
  	opacity: 0.7;
  	color: gold;
  	font-weight: bold;
  }
  
 
  .set1{
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
  h3{
  margin-left: 600px;

  font-size: x-large;
  }
  b{
padding-right: 20px;
}
.btn {
margin-right: 30px;
margin-left: 30px;
}

</style>
</head>
<body>
<div class="nav">
    <ul>        
        <li><a href="ShowBookServlet">Home</a></li> 
        <li><a href="MyProfileServlet">User profile</a></li>
        <li><a href="RechargeWallet.jsp">Recharge Wallet</a><li>
        
        <li><a href="ViewMyOrders.jsp">View My Order</a></li>
        <li><a href="FilterByCondition.jsp">Old Books</a></li>
        <li><a href="login.jsp">Log Out</a></li>
        
    </ul>
</div>

<table>
                       

            <tbody>
                <tr>
                 <h3>MY CART</h3>
                       
                <c:set var="count" value="1"/>
                <c:forEach items="${cartList}" var="cart">
                
                    <td>
                        <table id="producttable">
                        
                     
                            <tbody>
                                <tr>
                                    <td><img src="image/${cart.bookimages}" width=150 height=350 alt="book"></td>    
                                    <td class="book">
                                         <p><strong>CATEGORY  :    </strong>${cart.category}<br></p>
                                         <p><strong>DESCRIPTION: </strong>${cart.description}<br></p>
                                         <p><strong>BOOK TITLE: </strong>${cart.booktitle}<br></p>
                                         <p><strong>BOOK CODE:</strong>${cart.bookcode}<br></p>
                                         <p><strong>PRICE:</strong>${cart.price}<br></p>
                                         <p><strong>PUBLISH DATE:</strong>${cart.publishdate}<br></p>
                                         <p><strong>CONDITION:</strong>${cart.condition}<br></p>
                                         <p><strong>AUTHOR NAME:</strong>${cart.name}<br></p>
                                         <p><strong>AUTHOR EMAIL:</strong>${cart.emailid}<br></p>
                                        
                                        <strong>RATINGS:</strong>${cart.rating}<br><br>
                                         <a href = "BuyOrderServlet?bookid=${cart.bookid}"><button class="btn">Buy</button></a>
                                        <a href = "removecart?bookid=${cart.bookid}"><button>Remove</button></a>
                                         
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
</html>