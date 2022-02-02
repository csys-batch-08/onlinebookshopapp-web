<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang = "eng">

<head>
<meta charset="ISO-8859-1">
<title>Products</title>
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
margin-left: 200px;

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
padding-left: 80px;

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
</style>
</head>
<body>

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
      
 
<table>

            <tbody>
                <tr>
                
                <c:set var="count" value="1"/>
                <c:forEach items="${booklist}" var="book">
               
                    <td>
                        <table id="producttable">
                            <tbody>
                                <tr>
                                    <td><img src="image/${book.bookimages}" width=50 height=350 alt="book"></td>    
                                    <td class="book">
                                        <p><strong class="cat">CATEGORY   :   </strong>${book.category}<br></p>
                                        <p><strong class="desc">DESCRIPTION :</strong>${book.description}<br></p>
                                        <p><strong class="title">BOOK TITLE  :   </strong>${book.booktitle}<br></p>
                                        <p><strong class="title">BOOK CODE  :   </strong>${book.bookcode}<br></p>
                                        <p><strong class="price">PRICE :  </strong>${book.price}<br></p>
                                        
                                        <p><strong class="date">PUBLISH DATE   :   </strong><fmt:parseDate value="${book.publishdate}" pattern="yyyy-MM-dd" var="publishDate" type="date"/>
                                        <fmt:formatDate pattern="dd-MM-yyyy" value="${publishDate}"/><br></p>

                                        <p><strong class="condition">CONDITION   :   </strong>${book.condition}<br></p>
                                        <p><strong class="aname">AUTHOR NAME   :  </strong>${book.name}<br></p>
                                        <p><strong class="aemail">AUTHOR EMAIL   :  </strong>${book.emailid}<br></p>
                                         
                                         
                                         <p><strong class="rating">RATINGS    :</strong>${book.rating}<br><br></p>
                                         <a href = "addcartserv?bookid=${book.bookid}"><button class="btn">Add to Cart</button></a>
                                         <a href = "RatingNewServlet?bookd=${book.bookid}"><button>Add Ratings</button></a>
                                         
                                         
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