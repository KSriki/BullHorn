<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<h1>Error</h1>
<!-- message is set by the servlet that calls this page -->
<h2>${message}</h2>
<a href="https://en.wikipedia.org/wiki/Matt_Groening">
<img src="images/mistakesweremade.png" alt="Mistakes were made">
</a>
</body>
</html>