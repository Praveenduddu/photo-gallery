<%@page import="de.zeroco.album.Dao"%>
<%@page import="de.zeroco.album.Service"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Part filePart = request.getPart("photo");
String uploadDirectory = getServletContext().getRealPath("/images/");
out.println(Service.getGeneratedKey(Service.storeUploadedPhotoInAlbum(filePart, uploadDirectory)));
%>
</body>
</html>