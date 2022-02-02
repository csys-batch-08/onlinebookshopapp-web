<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang = "eng">
<head>
<meta charset="ISO-8859-1">
<title>USERS LIST PAGE</title>
<style>
body{
    background-image: url(image/new8.jpg);
    background-repeat: no-repeat;
    background-size:1400px 625px;
    color: white;
    background-attachment: fixed;
}
*{
			margin:0;
			padding:0;
		}
.nav
    {
        list-style: none;
          background: linear-gradient(to bottom, #33cccc 7%, #006666 74%);
        color: black;
        margin-top: 10px;
    }
  li{
      display:inline-block;
      padding-top: 12px;
      padding-bottom: 12px;
      text-align: center;
      font-size: 16px;
  }
  li a:hover{
  	opacity: 0.6;
  	color: black;
  	font-weight: bold;
  }
  li a{
      text-decoration: none;
      color:white;
      display:block;
      padding-right: 20px;
      padding-left: 30px;
  }
 
  
  a:hover{
  	opacity: 0.6;
  	color: gold;
  	font-weight: bold;
  }



button{

    padding: 10px;
  	border-radius: 4px;
  	background: linear-gradient(to bottom, #33ccff 45%, #006666 100%);
  	color: white;
  	font-weight: bold;
  	border-color: transparent;
  	margin-right: 50px;
  	margin-left: 30px;
}
h1{
text-align: center;
}
.viewprofile{
            border-style:solid;
            border-color:silver;
            position: absolute;
            top: 120px;
            right: 24%;
            padding-right: 30px;
            padding-left: 30px;
            padding-top: 20px;
            padding-bottom:20px;
            font-size: 18px;
        }

</style>
</head>
<body>
<div class="nav">	
		<ul>
		    <li><a href="admin.jsp">Home</a></li>
	        <li><a href="ViewUserServlet">View User</a></li>
			<li><a href="AddBooks.jsp">Add Books</a></li>
			<li><a href="UpdateBook.jsp">Update Book</a></li>
			<li><a href="ViewAllBookServlet">All Books</a></li>

			<li><a href="AddAuthor.jsp">Add Author</a></li>
			<li><a href="AuthorUpdate.jsp">Update Author</a></li>
			<li><a href="ViewAuthor.jsp">View Author</a></li>
            <li><a href="ViewAllOrderServlet">View ALL Orders</a></li>
		    <li><a href="CancelledOrdersServlet">Cancelled Orders</a></li>

		</ul>
</div>
<div class="head">
<h1>User Details</h1>
</div>
<c:set var="count" value="0" />
<c:forEach items="${userlist}" var="userList">
<c:set var="count" value="${count+1}" />



<div class="viewprofile">
	<pre>
        <strong>Customer Id       :  </strong>${userList.cusid}<br>
	<strong>Name              :  </strong>${userList.name}<br>
	<strong>PhoneNo           :  </strong>${userList.phoneNo}<br>
	<strong>Address           :  </strong>${userList.address}<br>
	<strong>Email Id          :  </strong>${userList.emailid}<br>
	<strong>Password          :  </strong>${userList.password}<br>
	<strong>Wallet            :  </strong>${userList.wallet}<br>
	<strong>Role              :  </strong>${userList.role}</pre><br><br>
   <a href="deleteuser?emailid=${userList.emailid}"><button>Inactive</button></a>
	<a href="activeuser?emailid=${userList.emailid}"><button>Active</button></a>
					
</div>
</c:forEach>

	

</body>
</html>