<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP result</title>
</head>
<body>

<%=request.getAttribute("servletResponse") %>
<br><br>
<form action="http://localhost:8080/project3/DataServlet" method="get">
<input type="submit" name="submit3" value="Return to Selection">
</form>
</body>
</html>
