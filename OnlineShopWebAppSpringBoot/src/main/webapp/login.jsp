<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body style = 'text-align: center;background-color: lightgreen'>
	<h2 style ="color:red"> ${logonerror } </h2>
	<h2 style ="color:blue"> ${chaU } </h2>
	<h3 style = 'color:Blue'>Login</h3>
	<form action = "login" method = "post">
		<p style = 'color: blue'>Username:<input type = "text" name = "username" ></p>
		<p style = 'color: blue'>Password:<input type = "password" name = "password" ></p>
		<input type = "submit" value = "Login" style="background-color: green; 
													  border: none;
  													  color: white;
  													  padding: 10px 12px;
  													  font-size:15px;
  													  text-align: center;">
	</form>
		<p style='color: red'>Don't Have an Account? <a href = "SignUp.jsp">Sign Up</a></p>
</body>
</html>