<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body style = 'text-align: center;background-color: cyan'>
	<h2 style ="color:red"> ${pnf } </h2>
	<form action="delete">
		Product Id You Want to Delete:<input type = "text" name="id" required><br><br>
		<input type="submit" value = "delete">
	</form>
</body>
</html>