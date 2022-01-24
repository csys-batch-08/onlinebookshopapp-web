<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="com.onlinebookshop.model.AuthorDetails"%>
    <%@page import="java.util.*"%>
            <%@page import="com.onlinebookshop.daoimpl.AuthorDetailsDaoimpl"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AUTHOR LIST</title>
<style>
body{
    background-image: url(image/new4.jpg);
    background-repeat: no-repeat;
    background-size: 2000px 2470px;
    color:black;
    font-weight: 100px;
}
*{
			margin:0;
			padding:0;
		}
ul
    {
        list-style: none;
        background-color: #1c1c1c;
        margin:0;
    }
  li{
      display:inline-block;
      padding-top: 10px;
      padding-bottom: 10px;
      text-align: center;
      font-size: 17px;
  }
  li a{
      text-decoration: none;
      color:white;
      display:block;
      padding-right: 40px;
      padding-left: 7px;
  }
 li  button{
      margin-right: 500px;
  }
        h2{
        margin-top:50px;
        text-align: center;
        
        }
        h1{
        margin-top: 100px;
        }
        
fieldset{
    position: absolute;
    top: 140px;
    right: 40%;
    padding-right: 30px;
    padding-left: 30px;
    
}
a{
    text-decoration: none;
    color: white;
}
table {
	margin-left: 450px;
	border-collapse: collapse;
	border: 3px solid black;
}

td, th{
   padding: 10px;

}
</style>
</head>
<body>
<aside>
<ul>
       <li><a href="ViewUser.jsp">View User</a></li>
		<li><a href="DeleteUser.jsp">Delete User</a></li>
		
        <li><a href="AddBooks.jsp">Add Books</a></li>
		<li><a href="UpdateBook.jsp">Update Book</a></li>
		<li><a href="ViewAllBook.jsp">All Books</a></li>
		
		<li><a href="AddAuthor.jsp">Add Author</a></li>
		<li><a href="AuthorUpdate.jsp">Update Author</a></li>
		<li><a href="ViewAuthor.jsp">View Author</a></li>
		
		<li><a href="ViewAllOrders.jsp">View ALL Orders</a></li>
</ul>
</aside>
 <h2>Books Wagon</h2>
</head>
<body>

<%

AuthorDetailsDaoimpl authordao = new AuthorDetailsDaoimpl();
        List<AuthorDetails> authorList = new ArrayList<AuthorDetails>();
        authorList = authordao.showAuthor();
%>


<table border="1" id="allusers">
<thead>
<tr>
  <th >S.no</th>
<th>Name</th>
<th>Email_id</th>
<th>Book_id</th>
</tr>
</thead>
<br>
<br>

<tbody>
<%
int i = 0;
for (AuthorDetails viewAuthor : authorList) {
	i++;
%>
<tr>


<td><%=i%></td>
<td><%=viewAuthor.getName()%></td>
<td> <%=viewAuthor.getEmail_id()%></td>
<td> <%=viewAuthor.getBook_id()%></td>
</tr>

<%
}
%>
</tbody>
          </table>


</body>
</html>
 
</body>
</html>