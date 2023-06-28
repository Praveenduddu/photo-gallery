<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>
<h1>Delete The Photo</h1>
<form action="deletecontrol">
<label>Image Id : </label>
<input type = "number" name = "id" value = <%= request.getParameter("id") %>></input>
<br></br>
<input type = "submit"></input>
</form>
</body>
</html>