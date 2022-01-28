<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
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


		<li><a href="ShowBookServlet">Home</a></li>
        <li><a href="FilterByCondition.jsp">Old Books</a></li>
        <li><a href="ShowCartServlet" class="set1">My Cart</a></li>
        <li><a href="MyProfile.jsp">User profile</a></li>
        <li><a href="RechargeWallet.jsp">Recharge Wallet</a><li>
        
        <li><a href="ViewMyOrders.jsp">View My Order</a></li>
        <li><a href="login.jsp">Log Out</a></li>

			</ul>
		</div>

		<fieldset>
			<h2>Add Your Ratings..</h2>
			<br> <label for="ratings">Ratings :</label><br> 
			<input	type="text" name="ratings" class="ratings" Pattern="[1-9]" title="Positive number between 1-5" required><br>
			<br>
			<button type="submit">Add</button>
			
			<c:if test="${sessionScope.rating!=null}">
              <h4>${sessionScope.rating}</h4>
            </c:if>
        
            <c:remove var="rating" scope="session"/>
		</fieldset>
<table>
            <tbody>
                <tr>
                
                <c:set var="count" value="1"/>
               <c:forEach items="${books}" var="booklist">
                	
        
                    <td>
                        <table id="producttable">
                            <tbody>
                                <tr>
                                    <td><img src="image/${booklist.bookimages}" width=180 height=350 alt="book"></td>    
                                    <td class="book">
                                        <p><b class="cat">CATEGORY   :   </b>${booklist.category}<br></p>
                                        <p><b class="desc">DESCRIPTION :</b>${booklist.description}<br></p>
                                        <p><b class="title">BOOK TITLE  :   </b>${booklist.booktitle}<br></p>
                                        <p><b class="title">BOOK CODE  :   </b>${booklist.bookcode}<br></p>
                                        <p><b class="price">PRICE :  </b>${booklist.price}<br></p>
                                        <p><b class="date">PUBLISH DATE   :   </b>${booklist.publishdate}<br></p>
                                        <p><b class="condition">CONDITION   :   </b>${booklist.condition}<br></p>
                                        <p><b class="aname">AUTHOR NAME   :  </b>${booklist.name}<br></p>
                                        <p><b class="aemail">AUTHOR EMAIL   :  </b>${booklist.emailid}<br></p>
                                         
                                         
                                         <p><b class="rating">RATINGS    :</b>${booklist.rating}<br><br></p>
                                         
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

	</form>
</body>
</html>