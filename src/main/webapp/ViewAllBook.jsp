<%@page import="com.onlinebookshop.daoimpl.BookdetailsDaoimpl"%>
<%@page import ="com.onlinebookshop.model.Bookdetails" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="com.onlinebookshop.model.Userdetails"%>
    <%@page import="java.util.*"%>
            <%@page import="com.onlinebookshop.daoimpl.UserdetailsDao"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Books</title>
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

<%

         BookdetailsDaoimpl bookdetailsdao = new BookdetailsDaoimpl();
        List<Bookdetails> userList = new ArrayList<Bookdetails>();
         userList = bookdetailsdao.ViewAllBook();
%>

<div>
<table border="2" id="allusers">
<thead>
<tr>
  <th >S.no</th>
<th>Book Id</th>
<th>Category</th>
<th>Description</th>
<th>Book Title</th>
<th>Book Code</th>
<th>Price</th>
<th>Publish Date</th>
<th>Condition</th>
<th>Book image</th>
<th>Status</th>
<th>Delete</th>
</tr>
</thead>
<br>
<br>

<tbody>
<%
int i = 0;
for (Bookdetails viewBook : userList) {
	i++;
%>
<tr>


<td><%=i%></td>
<td><%=viewBook.getBookid()%></td>
<td><%=viewBook.getCategory()%></td>
<td><%=viewBook.getDescription()%></td>
<td> <%=viewBook.getBooktitle()%></td>
<td> <%=viewBook.getBookcode()%></td>
<td> <%=viewBook.getPrice()%></td>
<td> <%=viewBook.getPublishdate()%></td>
<td> <%=viewBook.getCondition()%></td>
<td> <%=viewBook.getBookimages()%></td>
<td> <%=viewBook.getStatus()%></td>
 <td><a href = "DeleteBooks?bookid=<%=viewBook.getBookid()%>"><button>Remove</button></a></td>
</tr>

<%
}
%>
</tbody>
          </table>


</div>
 
</body>
</html>