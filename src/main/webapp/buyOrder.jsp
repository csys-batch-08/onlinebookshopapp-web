<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang = "eng">
<head>
<meta charset="ISO-8859-1">
<title>Buy Books</title>
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

	position: fixed;
	top: 140px;
	right: 190px;
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
      padding-right: 30px;
      padding-left: 55px;
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
form{
            border-style:solid;
            border-color:silver;
            position: absolute;
            top: 140px;
            right: 13%;
            padding-right: 30px;
            padding-left: 30px;
            padding-top: 20px;
            padding-bottom:20px;
            
        }
</style>
</head>
<body>
<div class="nav">
    <ul>
         <li><a href="ShowBookServlet" class="set1">Home</a></li>
         <li><a href="FilterByConditionServlet">Old Books</a></li>  
        <li><a href="ShowCartServlet">My Cart</a></li>
        <li><a href="MyProfileServlet">User profile</a></li>
        <li><a href="rechargeWallet.jsp">Recharge Wallet</a><li>
        <li><a href="ViewMyOrderServlet">View My Order</a></li>
        
        <li><a href="login.jsp">Log Out</a></li>
        
    </ul>
</div>


<form action="OrderServlet">
<h3>Add Quantity!...</h3>
<label for="quantity">Quantity:</label><br>
<input type="text" name="quantity" class="quantity" pattern="[1-9]+" required><br><br>
<button type="submit">Order</button>
</form>

<table>
<caption></caption>
            <tbody>
                <tr>
                
                <c:set var="count" value="1"/>
                <c:forEach items="${orderlist}" var="orderbook">	
                	<th id ="head">
                    <td>
                        <table id="producttable">
                        <caption></caption>
                            <tbody>
                                <tr>
                                   <th id="image"><img src="image/${orderbook.bookimages}" width=50 height=350 alt="book"></th>    
                                    <td class="book">
                                        <p><strong class="cat">CATEGORY   :   </strong>${orderbook.category}<br></p>
                                        <p><strong class="desc">DESCRIPTION :</strong>${orderbook.description}<br></p>
                                        <p><strong class="title">BOOK TITLE  :   </strong>${orderbook.booktitle}<br></p>
                                        <p><strong class="title">BOOK CODE  :   </strong>${orderbook.bookcode}<br></p>
                                        <p><strong class="price">PRICE :  </strong>${orderbook.price}<br></p>
                                        <p><strong class="date">PUBLISH DATE   :   </strong><fmt:parseDate value="${orderbook.publishdate}" pattern="yyyy-MM-dd" var="publishDate" type="date"/>
                                        <fmt:formatDate pattern="dd-MM-yyyy" value="${publishDate}"/><br></p>
                                        <p><strong class="condition">CONDITION   :   </strong>${orderbook.condition}<br></p>
                                        <p><strong class="aname">AUTHOR NAME   :  </strong>${orderbook.name}<br></p>
                                        <p><strong class="aemail">AUTHOR EMAIL   :  </strong>${orderbook.emailid}<br></p>
                                         
                                         
                                         <p><strong class="rating">RATINGS    :</strong>${orderbook.rating}<br><br></p>
                                         
                                    </td>
                                </tr>
                            </tbody>
                        </table>  
                            
                    </td>
                        <c:choose>
                          <c:when test="${count==2}">
                              <c:set var="count" value="1"/>
                    	
                      </c:when> 
                    	   <c:otherwise>
                    	   <c:set var="count" value="${count+1}"/>
                    	   </c:otherwise>            
                          
                       </c:choose>
                       </c:forEach>
                          </tr>
                    	   <tr>              
                </tr>
            </tbody>
        </table>
</body>
</html>