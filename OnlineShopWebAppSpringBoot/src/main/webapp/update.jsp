<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body style = 'text-align: center;background-color: cyan'>
	<h2 style ="color:red"> ${pnf } </h2>
	<form action="update">
		Product Id You Want to Update:<input type = "text" name="id" required><br><br>
		Name:<input type = "text" name = "name" required><br><br>
		Brand:<input type = "text" name = "brand" required><br><br>
		Price:<input type = "text" name = "price" required><br><br>
		<input type="submit" value = "update">
	</form>
</body>
</html>