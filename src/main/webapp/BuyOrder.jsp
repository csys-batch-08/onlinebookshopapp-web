<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.onlinebookshop.daoimpl.BookdetailsDaoimpl"%>
<%@page import="com.onlinebookshop.model.Bookdetails" %>
<%@page import="com.onlinebookshop.model.ProductDetails" %>
<%@page import="com.onlinebookshop.model.Rating"%>
<%@page import="com.onlinebookshop.daoimpl.Ratingdaoimpl"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
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
</style>
</head>
<body>
<div class="nav">
    <ul>
        <li><a href="ShowBook.jsp" class="set1">Home</a></li>
        <li><a href="ShowCart.jsp" class="set1">My Cart</a></li>
        <li><a href="MyProfile.jsp">User profile</a></li>
        <li><a href="RechargeWallet.jsp">Recharge Wallet</a><li>
        <li><a href="ViewMyOrders.jsp">View My Order</a></li>
        <li><a href="FilterByCondition.jsp">Old Books</a></li>
        <li><a href="login.jsp">Log Out</a></li>
        
    </ul>
</div>
<%!double rate;%>
<%
 int bookid=Integer.parseInt(request.getParameter("bookid"));
 session.setAttribute("Book",bookid);
 BookdetailsDaoimpl bookdetailsDaoimpl = new BookdetailsDaoimpl();
	List<ProductDetails> bookdetail = bookdetailsDaoimpl.ratingproducts(bookid);
	
	Ratingdaoimpl ratingdaoimpl = new Ratingdaoimpl();
%>

	
<fieldset>
<form action="OrderServlet" method="post">
<h3>Add Quantity!...</h3>
<label for="quantity">Quantity:</label><br>
<input type="text" name="quantity" class="quantity" pattern="[1-9]+" required><br><br>
<button type="submit">Order</button>
</form>
</fieldset>
<table>
            <tbody>
                <tr>
                
                <%int count=0;
                for(ProductDetails bookdetails : bookdetail){
                	
                	%>
                    <td>
                        <table id="producttable">
                            <tbody>
                                <tr>
                                    <td><img src="image/<%=bookdetails.getBookimages()%>" width=180 height=350 alt="book"></td>    
                                    <td class="book">
                                        <p><b class="cat">CATEGORY   :   </b><%=bookdetails.getCategory() %><br></p>
                                        <p><b class="desc">DESCRIPTION :</b><%=bookdetails.getDescription()%><br></p>
                                        <p><b class="title">BOOK TITLE  :   </b><%=bookdetails.getBook_title()%><br></p>
                                        <p><b class="title">BOOK CODE  :   </b><%=bookdetails.getBook_code() %><br></p>
                                        <p><b class="price">PRICE :  </b><%=bookdetails.getPrice() %><br></p>
                                        <p><b class="date">PUBLISH DATE   :   </b><%=bookdetails.getPublish_date()%><br></p>
                                        <p><b class="condition">CONDITION   :   </b><%=bookdetails.getCondition() %><br></p>
                                        <p><b class="aname">AUTHOR NAME   :  </b><%=bookdetails.getName() %><br></p>
                                        <p><b class="aemail">AUTHOR EMAIL   :  </b><%=bookdetails.getEmail_id() %><br></p>
                                        <%
                     
                                         Rating rating = new Rating();
                                         rating.setBook_id(bookdetails.getBookid());
                                         rate = ratingdaoimpl.fetchrating(rating);
                                         
                                         %>
                                         
                                         <p><b class="rating">RATINGS    :</b><%=rate %><br><br></p>
                                         
                                    </td>
                                </tr>
                            </tbody>
                        </table>  
                            
                    </td>
                       <% count ++;
                       if(count==2){ %> 
                    	   </tr>
                    	   <tr>              
                     <%count=0; }}%>  
                       
                </tr>
            </tbody>
        </table>
</body>
</html>