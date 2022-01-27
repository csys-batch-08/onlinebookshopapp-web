
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
padding-top: 5px;
padding-bottom: 5px;
}
ul
    {
        list-style: none;
        background-color:SaddleBrown;
        margin:0;
        color: black;
        position: fixed;
    }
  li{
      display:inline-block;
      padding-top: 12px;
      padding-bottom: 12px;
      text-align: center;
      font-size: 17px;
  }
  li a:hover{
  	opacity: 0.7;
  	color: black;
  	font-weight: bold;
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
  a:hover{
  	opacity: 0.7;
  	color: gold;
  	font-weight: bold;
  }
  
</style>
</head>
<body>
<form action="filterprice" method="post">
<div class="nav">
    <ul>
        <li><input type="text" name="search" class="text" placeholder="Enter price"></li>
        <li><a href=><button>Search</button></a></li>
        
        <li><a href="ShowCartServlet" class="set1">My Cart</a></li>
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
                
                <c:forEach items="${bookList}" var="booklist">
                	
                    <td>
                        <table id="producttable">
                            <tbody>
                                <tr>
                                    <td><a href = "ShowProductServlet?BookId=${booklist.bookid}"><img src="image/${booklist.bookimages}" width=50 height=350 alt="book"></a></td>    
                                    <td class="book">
                                        <p><b>CATEGORY   :   </b>${booklist.category}<br></p>
                                        
                                        <p><b>BOOK TITLE  :   </b>${booklist.booktitle}<br></p>
                                        
                                        <p><b>PRICE :  </b>${booklist.price}<br></p>
                                      
                                        <p><b>Ratings :</b>${booklist.rating}<br></p>
                                                                           
                                         
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