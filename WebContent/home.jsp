<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<h1>this is the home page</h1>
<h1>${message}</h1>
<h1>Welcome, ${user.getUsername()}</h1>
<h2>${user.getMotto()}</h2>

</body>
</html>