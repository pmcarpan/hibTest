<%@ page pageEncoding="UTF-8" import = "java.util.List, model.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success!</title>
</head>
<body>
	<h2>Success!</h2>
	<table>
	<%
		List<Product> products = (List<Product>) request.getAttribute("products");
		for (Product p : products) {
			out.println("<tr><td>" + p.getId() + "</td><td>" + p.getName() + "</td><td>" + p.getPrice() + "</td></tr>");
		}
	%>
	</table>
</body>
</html>