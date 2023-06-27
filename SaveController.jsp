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
out.println(Service.getGeneratedKey(filePart));
%>
</body>
</html>