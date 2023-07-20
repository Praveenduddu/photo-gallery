<%@page import="de.zeroco.album.PhotoAlbum"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="view">
<table border=1 width=100% height=100%>
<tr>
<%
List<PhotoAlbum> list = (List<PhotoAlbum>) request.getAttribute("photoAlbum");
int count = 0;
for (PhotoAlbum album : list) {
	count++;
	%>
	<td><img src="Images/<%= album.getFileName() %>" alt= "No Image" width = "300px" heigth = "300px" <td><a href="deletecontrol?id=<%= album.getId() %>">Delete</a>&nbsp&nbsp&nbsp<a href="select?id=<%= album.getId() %>">Edit</a></td> ></td>
    <%
    if (count % 3 == 0) {
    	%>
    	</tr>
    	<%
    }
}
%>
</table>
</form>
</body>
</html>
