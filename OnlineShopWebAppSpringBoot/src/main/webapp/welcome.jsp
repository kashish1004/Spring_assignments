<%@page import="com.phoenix.entities.Product ,java.util.List ,com.phoenix.services.ProductService ,com.phoenix.services.ProductServiceImpl " %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body style = 'text-align: center;background-color: cyan' >
<%@ include file="header.html" %>
<h2 style='color:blue'>Hello ${uname}, Shop the best products available</h2>
<% 	
	String uname = request.getParameter("username");
	session.setAttribute("user",uname);
	//session.setMaxInactiveInterval(5);
%>
<h2 style='color:blue'>Session Expires in: <%=session.getMaxInactiveInterval()%> Seconds</h2>
<p style='color:blue'>To go to Shopping page <a href ="products">Click Here</a></p>
<a href ="change.jsp">Change Password</a><br><br>
<form action ="deleteAcc" method ="post">
<input type = "submit" value = "delete your account">
</form>
</body>
</html>
<%@ include file="footer.html" %>