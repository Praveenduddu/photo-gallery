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
<h1>Image Details</h1>
<form action="update" method = "post" enctype="multipart/form-data">
<%PhotoAlbum album = (PhotoAlbum) request.getAttribute("photoAlbum");%>
<img src="Images/<%= album.getFileName() %>" alt= "No Image" width = "300px" heigth = "300px" >
<br></br>
<input type = "hidden" name = "id" value = <%= album.getId() %>></input>
<label>Replace Image</label>
<input type = "file" name = "file"></input>
<br></br>
<input type = "submit"></input>
</form>
</body>
</html>