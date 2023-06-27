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
for (PhotoAlbum album : list) 
{  
    out.println("<td><image src = " + album.getFilePath() + " alt =" + "Not Found" + "></img></td>");
}
%>
</tr>
</table>
</form>
</body>
</html>