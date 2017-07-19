<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="en_US" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="include.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Bullhorn</title>
</head>
<body>
<h1>Login Page</h1>
<c:if test="${Exists != null}">
	<script>
		var exist = "${Exists}";
		
		alert(exist);	
		
		
	</script>
	</c:if>

<div class="row">

		<div class="col-md-6">
			<h2> Login User </h2>
			<form action="LoginServlet" method="post">
				Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="email"
					name="email" value="larry12345@gmail.com"><br />
				Password:&nbsp;<input type="password" name="password"
					value="password"><br /> <input type="hidden" name="action"
					value="login"> <input type="submit" value="Log In">
			</form>
		</div>
		<div class="col-md-6">
			<h2> Create User </h2>
			<form action="CreateUser" method="post" onsubmit="return validate(this);">
				Username: <input type="text" name="nName" id="nName" value="john"> <br />
				Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="email"
					name="nEmail" id="nEmail" value="john@smith.com"><br />
				Password:&nbsp;<input type="password" name="nPass" id="nPass"
					value="password"><br />
				Confirm Password:&nbsp;<input type="password" name="confirm" id="confirm"
					value="password"><br /> 
					<input type="hidden" name="action"
					value="login"> 
					 <input type="submit" value="Create">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <input type="reset" value="Reset">
			</form>
		
		</div>

</div>

		<a href="LoginServlet">What happens if you go directly to login servlet without logging in?</a>
<script>

function validate(form) {
	
	name= document.getElementById("nName").value;
	email=document.getElementById("nEmail").value;
	pass=document.getElementById("nPass").value;
	confirm=document.getElementById("confirm").value;
	
	
	valid = true;
	if (name.length==0 || email.length==0 || pass.length==0 || confirm.length==0){
		alert("You are missing fields!");
		valid = false;
	}
	else if(pass != confirm ){
		alert("Passwords don't match!");
		valid = false;		
	}
	return valid;
}

</script>
<jsp:include page="footer.jsp" />
</body>
</html>