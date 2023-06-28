<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Update Details</h1>
<form action="update" method = "post" enctype="multipart/form-data">
<label>ID</label>
<input type = "number" name = "id" value = <%= request.getParameter("id") %>></input>
<br></br>
<label>Update File Path</label>
<input type = "file" name = "file"></input>
<br></br>
<input type = "submit"></input>
</form>
</body>
</html>