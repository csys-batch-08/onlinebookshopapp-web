<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang = "eng">
<title>Products</title>
<head>
<meta charset="ISO-8859-1">
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
       
        <li><a href="ShowBook.jsp">Home</a></li>
        <li><a href="FilterByCondition.jsp">Old Books</a></li>
        <li><a href="ShowCartServlet" class="set1">My Cart</a></li>
        <li><a href="MyProfile.jsp">User profile</a></li>
        <li><a href="RechargeWallet.jsp">Recharge Wallet</a><li>
        
        <li><a href="ViewMyOrders.jsp">View My Order</a></li>
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
                                        <p><b class="cat">CATEGORY   :   </b>${book.category}<br></p>
                                        <p><b class="desc">DESCRIPTION :</b>${book.description}<br></p>
                                        <p><b class="title">BOOK TITLE  :   </b>${book.booktitle}<br></p>
                                        <p><b class="title">BOOK CODE  :   </b>${book.bookcode}<br></p>
                                        <p><b class="price">PRICE :  </b>${book.price}<br></p>
                                        <p><b class="date">PUBLISH DATE   :   </b>${book.publishdate}<br></p>
                                        <p><b class="condition">CONDITION   :   </b>${book.condition}<br></p>
                                        <p><b class="aname">AUTHOR NAME   :  </b>${book.name}<br></p>
                                        <p><b class="aemail">AUTHOR EMAIL   :  </b>${book.emailid}<br></p>
                                         
                                         
                                         <p><b class="rating">RATINGS    :</b>${book.rating}<br><br></p>
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