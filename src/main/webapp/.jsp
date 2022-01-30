<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang = "eng">
<head>
<meta charset="ISO-8859-1">
<title>Filter By Name</title>
<style>
body{
    background-image: url(image/back5.jpeg);
    background-repeat:repeat;
    color:white;
    background-size:2600px 900px ;
    font-weight: 1000;
    font-size: 15px;
    font-weight: 100px;  
}

img{
width: 250px;
padding:20px;
border-radius: 14%;

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
padding-top: 5px;
padding-bottom: 5px;
}
ul
    {
        list-style: none;
        background-color:rgb(72,72,72);
        margin:0;
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
      padding-right: 10px;
      padding-left: 10px;
  }
 li  button{
      margin-right: 350px;
      
  }
  
  .set1{
      margin-right: 10px;
  }
</style>
</head>
<body>

<div class="nav">
    <ul>
       
        
        <li><a href="ShowCart.jsp" class="set1">My Cart</a></li>
        <li><a href="MyProfile.jsp">User profile</a></li>
        <li><a href="RechargeWallet.jsp">Recharge Wallet</a><li>
        
        <li><a href="ViewMyOrders.jsp">View My Order</a></li>
        <li><a href="FilterByCondition.jsp">Old Books</a></li>
        <li><a href="login.jsp">Log Out</a></li>
    </ul>
</div>


<table>
            <tbody>
                <tr>
                
                <c:set var="count" value="1"/>
                <c:forEach items="${filternamelist}" var="filterName">
                	
                    <td>
                        <table id="producttable">
                            <tbody>
                                <tr>
                                    <td><a href = "ShowProduct.jsp?BookId=${filterName.bookid}"><img src="image/${filterName.bookimages}" width=50 height=350 alt="book"></a></td>    
                                    <td class="book">
                                        <p><strong>CATEGORY   :   </strong>${filterName.category}<br></p>
                                        
                                        <p><strong>BOOK TITLE  :   </strong>${filterName.booktitle}<br></p>
                                        
                                        <p><strong>PRICE :  </strong>${filterName.price}<br></p>
                                       
                                         <p><strong>Ratings :</strong>${filterName.rating}<br></p>
                                        
                                         
                                         
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