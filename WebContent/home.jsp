<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <fmt:setLocale value="en_US" /><!-- fixes date not displaying correctly in Eclipse browser -->
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="include.jsp" />

<title>Insert title here</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<h1>this is the home page</h1>
<h1>${message}</h1>
<h1>Welcome, ${user.getUsername()}</h1>
<h2>${user.getMotto()}</h2>

<form role="form" action="PostServ" method="post" onsubmit="return validate(this);">
    <div class="form-group">  
       <label for="post">Create New Post (141 char):</label> <br />
    <div class = "form-group"> 
       <textarea name= "posttext" id="posttext" maxlength="141" id="posttext" class="form-control" rows="2" placeholder= "Express yourself!"></textarea>
    </div> <br /> <br />
    <div id="textarea_feedback">sheguoaeh</div> <br />
    <div class = "form-group"> 
       <input type="submit" value="Submit" id="submit"/>
       <input type="reset" value="Clear"/>
    </div>  
</form> 
    

<script>
$(document).ready(function() {
    var text_max = 141;
    $('#textarea_feedback').html(text_max + ' characters remaining');

    $('#posttext').keyup(function() {
        var text_length = $('#posttext').val().length;
        var text_remaining = text_max - text_length;

        $('#textarea_feedback').html(text_remaining + ' characters remaining');
    });
});

function validate(form) {
	valid = true;
	if ($('#posttext').val().length==0){
		alert("You may not submit an empty post.");
		valid = false;
	}
	return valid;
}
</script>
    
</body>


</html>