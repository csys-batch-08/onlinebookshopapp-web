<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang = "eng">
<head>
<meta charset="ISO-8859-1">
<title>Ratings</title>
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

.Rate {

	position: fixed;
	top: 140px;
	right: 190px;
	padding-right: 30px;
	padding-left: 30px;
	border-style: solid;
	border-color: silver;
	padding-bottom: 15px;
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
</style>
</head>
<body>
	<form action="rating">
		<div class="nav">
			<ul>
		<li><a href="ShowBookServlet" class="set1">Home</a></li>     
        <li><a href="ShowCartServlet">My Cart</a></li>
        <li><a href="MyProfileServlet">User profile</a></li>
        <li><a href="rechargeWallet.jsp">Recharge Wallet</a><li>
        <li><a href="ViewMyOrderServlet">View My Order</a></li>
        <li><a href="FilterByConditionServlet">Old Books</a></li>
        <li><a href="login.jsp">Log Out</a></li>
			</ul>
		</div>
		<div class="Rate">
			<h2>Add Your Ratings..</h2>
			<br> <label for="ratings">Ratings :</label><br> 
			<input	type="text" name="ratings" id="ratings" class="ratings" Pattern="[1-9]" title="Positive number between 1-5" required><br>
			<br>
			<button type="submit">Add</button>
			<c:if test="${sessionScope.rating!=null}">
              <h4>${sessionScope.rating}</h4>
            </c:if>        
            <c:remove var="rating" scope="session"/>
		</div>
<table>
<caption></caption>
            <tbody>
                <tr>
                <th id="book">
                <c:set var="count" value="1"/>
               <c:forEach items="${books}" var="booklist">
                    <td>
                        <table id="producttable">
                        <caption></caption>
                            <tbody>
                                <tr>
                                <th id="books">
                                    <td><img src="image/${booklist.bookImages}" width=180 height=350 alt="book"></td>    
                                    <td class="book">
                                        <p><strong class="cat">CATEGORY   :   </strong>${booklist.category}<br></p>
                                        <p><strong class="desc">DESCRIPTION :</strong>${booklist.description}<br></p>
                                        <p><strong class="title">BOOK TITLE  :   </strong>${booklist.bookTitle}<br></p>
                                        <p><strong class="title">BOOK CODE  :   </strong>${booklist.bookCode}<br></p>
                                        <p><strong class="price">PRICE :  </strong>${booklist.price}<br></p>
                                        <p><strong class="date">PUBLISH DATE   :   </strong><fmt:parseDate value="${book.publishDate}" pattern="yyyy-MM-dd" var="publishDates" type="date"/>
                                        <fmt:formatDate pattern="dd-MM-yyyy" value="${publishDates}"/><br></p>
                                        <p><strong class="condition">CONDITION   :   </strong>${booklist.condition}<br></p>
                                        <p><strong class="aname">AUTHOR NAME   :  </strong>${booklist.name}<br></p>
                                        <p><strong class="aemail">AUTHOR EMAIL   :  </strong>${booklist.emailId}<br></p>
                                         <p><strong class="rating">RATINGS    :</strong>${booklist.rating}<br><br></p>                       
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
            </tbody>
        </table>
	</form>
</body>
</html>