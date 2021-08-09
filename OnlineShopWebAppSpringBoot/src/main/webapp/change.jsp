<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<body style = 'text-align: center;background-color: cyan'>
<%
	HttpSession session =request.getSession(false);
	if(session!=null) {%>
<h2 style ="color:red"> ${reenter } </h2>
	<form action = "changePass" method = "post">
		New Password:<input type="password" name = "newpasswd" required><br><br>
		Confirm New Password:<input type = "password" name ="cfmnewpasswd" required><br><br>
		<input type = "submit" value = "Confirm">
	</form>
	<% } else {
			out.println("<h2 style ='color:red'>Session Expired</h2>");
		}%>
</body>
</html>