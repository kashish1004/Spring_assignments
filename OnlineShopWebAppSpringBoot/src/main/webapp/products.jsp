<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List ,com.phoenix.entities.Product ,com.phoenix.services.ProductService ,com.phoenix.services.ProductServiceImpl"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
</html>
		
	<%
		HttpSession sessio = request.getSession(false);
		if(session!=null){%>
			<%@ include file="header.html" %>
		<%
			String user = (String)session.getAttribute("user");
			out.println("<h3 style ='color:blue'>Hi! "+ user +" Enjoy Shopping</h3>");
			List<Product> products = (List<Product>)session.getAttribute("product");
			String s = request.getParameter("sorted");
			if(s!=null)
				session.setAttribute("s",s);
			ProductService ps = new ProductServiceImpl();
		%>
			<html>
				<body bgcolor = 'cyan' style ='text-align: center'>
				<h2 style ="color:blue"> ${chP } </h2>
				<form action="sort" method = "post">
					<label for = "sort">Sort By:</label>
					<select name = "sorted" id = "sorted">
						<option value = "notSorted" <%if(s==null){%>selected<%}%>>Not sorted</option>
						<option value = "Name" <%if(s!=null && s.equals("Name")){%>selected<%}%>>Name</option>
						<option value = "Brand" <%if(s!=null && s.equals("Brand")){%>selected<%}%>>Brand</option>
						<option value = "Price" <%if(s!=null && s.equals("Price")){%>selected<%}%>>Price</option>
						<option value = "PriceDesc" <%if(s!=null && s.equals("PriceDesc")){%>selected<%}%>>PriceDesc</option>
					</select>
					<input type="submit" value = "Apply">
				</form>
					<table border = "1px" bgcolor = 'lightgreen' style ='margin:5px auto'>
						<tr>
							<th>ProductId</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Price</th>
						</tr>
						
						<% for(Product pro:products) {%>
						<tr>
							<td><%= pro.getId() %></td>
							<td><%= pro.getName() %></td>
							<td><%= pro.getBrand() %></td>
							<td><%= pro.getPrice() %></td>
						</tr>
						<% } %>
						
					</table>
					<br><br>
						<a href = update.jsp>Update a Product</a><br><br>
						<a href = delete.jsp>Delete a Product</a><br><br>
						<a href = insert.html>Insert a Product</a><br><br>
				</body>
			</html>
			<%@ include file="footer.html" %>
			<% } else {
					response.sendRedirect("SessionExpire.jsp");
				}%>