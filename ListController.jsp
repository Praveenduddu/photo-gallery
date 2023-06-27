<%@page import="de.zeroco.album.Service"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gallery</title>
</head>
<body>
<%
request.setAttribute("photoAlbum", Service.list());
%>
<jsp:forward page="view"></jsp:forward>
</body>
</html>