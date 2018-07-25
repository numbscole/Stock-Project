<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP result</title>
</head>
<body>
<form action="http://localhost:8080/project3/DataServlet" method="get">
<%=request.getAttribute("servletResponse") %>
<input type="submit" name="submit2">
</form>

</body>
</html>
