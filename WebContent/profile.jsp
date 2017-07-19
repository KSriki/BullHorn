<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="include.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<body style="padding: 0 20px;">
	<jsp:include page="navbar.jsp"></jsp:include>
	<h1>this is the profile page</h1>

	<c:if test="${editProfile==null}">
		<h1>the session doesn't exist</h1>
	</c:if>
	
	<c:if test="${Exists != null}">
	<script>
		var exist = "${Exists}";
		
		alert(exist);	
		
		
	</script>
	</c:if>
	
	<c:choose>
		<c:when test="${editProfile==false}">
			<table border="1">
				<tr>
					<td>Name:</td>
					<td><c:out value="${username}" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><c:out value="${useremail}" /></td>
				</tr>
				<tr>
					<td>Motto:</td>
					<td><c:out value="${usermotto}" /></td>
				</tr>
			</table>
		</c:when>
		<c:when test="${editProfile==true}">
			<form action="UpdateUser" method="post">
				<table border="1">
					<tr>
						<td>Name:</td>
						<td><input type="text" name="username" id="username"
							value="<c:out value="${username}"/>"></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><input type="text" name="useremail" id="useremail"
						    value="<c:out value="${useremail}"/>"></td>
					</tr>
					<tr>
						<td>Motto:</td>
						<td><input type="text" name="usermotto" id="usermotto"
						     value="<c:out value="${usermotto}"/>"></td>
					</tr>
				</table>
				<input type="hidden" name="userid" value="${userid}">
				<input type="hidden" name="action" value="updateProfile">
				 <input	type="submit" value="update">
			</form>
		</c:when>
	</c:choose>

<jsp:include page="footer.jsp" />
</body>
</html>