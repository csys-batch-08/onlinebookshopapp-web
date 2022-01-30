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
    background-image: fixed;
}
*{
			margin:0;
			padding:0;
		}
ul
    {
        list-style: none;
          background: linear-gradient(to bottom, #33cccc 7%, #006666 74%);
        color: black;
        position: fixed;
        margin-bottom: 300px;
        margin-top: 10px;
    }
  li{
      display:inline-block;
      padding-top: 12px;
      padding-bottom: 12px;
      text-align: center;
      font-size: 15px;
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
      padding-right: 55px;
      padding-left: 56px;
  }
 
  
  a:hover{
  	opacity: 0.6;
  	color: gold;
  	font-weight: bold;
  }


table {
	border: solid silver;
	margin: 30px 50px;
}

th, td {
	padding: 10px;
	font-weight: bold;
	font-size: 17px;
}

button{

    padding: 5px;
  	border-radius: 4px;
  	background: linear-gradient(to bottom, #33ccff 45%, #006666 100%);
  	color: white;
  	font-weight: bold;
  	border-color: transparent;
}
</style>
</head>
<body>
	
		<ul>
			
			<li><a href="AddBooks.jsp">Add Books</a></li>
			<li><a href="UpdateBook.jsp">Update Book</a></li>
			<li><a href="ViewAllBook.jsp">All Books</a></li>

			<li><a href="AddAuthor.jsp">Add Author</a></li>
			<li><a href="AuthorUpdate.jsp">Update Author</a></li>
			<li><a href="ViewAuthor.jsp">View Author</a></li>

			<li><a href="ViewAllOrders.jsp">View ALL Orders</a></li>
		</ul>	

	<div class="table">

		<table id="allusers">
			<thead>
				<tr>
					<th id = "sno">S.no</th>
					<th id = "cusid">Customer ID</th>
					<th id = "name">Name</th>
					<th id = "phoneno">Phone No</th>
					<th id = "address">Address</th>
					<th id = "emailid">Email_id</th>
					<th id = "password">Password</th>
					<th id = "wallet">Wallet</th>
					<th id = "role">Role</th>
					<th id = "inactive">Inactive</th>
					<th id = "inactive">Active</th>
				</tr>
			</thead>
			<br>
			<br>

			<tbody>
				<c:set var="count" value="0" />
				<c:forEach items="${userlist}" var="userList">
					<c:set var="count" value="${count+1}" />

					<tr>


						<td>${count}</td>

						<td>${userList.cusid}</td>
						<td>${userList.name}</td>
						<td>${userList.phoneNo}</td>
						<td>${userList.address}</td>
						<td>${userList.emailid}</td>
						<td>${userList.password}</td>
						<td>${userList.wallet}</td>
						<td>${userList.role}</td>
						<td><a href="deleteuser?emailid=${userList.emailid}"><button>Inactive</button></a></td>
						<td><a href="activeuser?emailid=${userList.emailid}"><button>Active</button></a></td>
					</tr>

				</c:forEach>

			</tbody>
		</table>


	</div>

</body>
</html>