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
<h1>this is the feedback page</h1>
<form action="" method="post">
  <input type="radio" name="subject" value="Question" checked> Question<br>
  <input type="radio" name="subject" value="Complaint"> Complaint<br>
  <input type="radio" name="subject" value="Comment"> Comment<br><br>
  <textarea name="feedback" rows="6" cols="50"></textarea><br><br>
  <input type="submit" value="Send Feedback">
</form>

</body>
</html>