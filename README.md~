# Redirect from Servlet Example
This example illustrates many of the concepts of a Java EE application. We still have not connected to the database yet but we'll do that soon. To account for the database I've created classes such as `DbUser` which will be modified to connect to the database. DbUser will not go away... it will be the class that calls the database.

### Use the following command to clone this project from GitHub

```console
git clone https://<YOUR_GITHUB_USERNAME>@github.com/dave45678/BullhornStarter
```
### Use the following commands to modify the git configuaration 
Be sure to create your own git repository. If you call it anything other than
BullhornStarter then change the url below to match.
```console
git remote set-url origin https://<YOUR_GITHUB_USERNAME>@github.com/<YOUR_GITHUB_USERNAME>/BullhornStarter
```

### Add the following blocks of code back to the project to make it work again
I created the complete application and tested it. So it was working. Then I decided to make your day ~~difficult~~ fun by removing some blocks of code from somewhere in the project. Only I know where. And by tomorrow I'll have forgotten. 

Each block of code below is the complete code that was removed. I did not introduce any errors other than removing it from where it was and placing it below. You will not need to write any new code. 
You only have to cut each block of code below and paste it back where it belongs.

```java
@WebServlet("/ProfileServlet")
```
```html
<li><a href="feedback.jsp">Feedback</a></li>
```

```java
if(!action.isEmpty()||!(action==null)){
    if (request.getParameter("action").toString().equals("logout")){
        //Go back to login.jsp. 
        nextPage = "/login.jsp";
        response.sendRedirect(request.getContextPath() + nextPage);
        return;//return here exits the method and prevents an error
    }else{
        nextPage = "/home.jsp";
    }
}
```

```java
getServletContext().getRequestDispatcher(nextURL).forward(request,response);
```

```java
public static boolean isValidUser(String email, String password) {
    //at this point your code would query the database to see if this user
    //and password are valid then return either true or false
    //for the moment we'll assume they are valid
    return true;
}
```


### Review
#### By now you should have the application working again. Answer the following questions:
* what is the action of the login form?
* right-click on LoginServlet and select Run as. You should see the error page. Do you know why?
* Now, right-click on the login.jsp and select Run as. You will see the login page. 
* The title on every page is different. What are some ways you could use to make the title consistent on every page? Think about what would happen if you wanted to change the title on every page. How would you modify your application to allow you to change the title in only one place?
* is the data for the login form sent through the url or embedded in the form object that is sent to the web server?
*  what is the name of the web server we are using?
* when the data is sent from login.jsp to the web server what does the web server do next?
* when is the login data (email and password) actually sent to the web server?
* what data is sent to the web server?
* write down the different methods that are executed (in order) once the user clicks "Login"
* when using JSTL (the Java Standard Tag Library) which page directive must you include at the top of the JSP page?
* modify this application to add another JSP for adding a new user. Create the JSP, name it adduser.jsp. Add it to the login page. That way if a user finds the login page but hasn't joined the site they would click on the "New User" link and go to the adduser.jsp. When adduser.jsp opens the user will see a form prompting for their username, email, password and motto. Don't worry about making the form work yet. We'll get to that later.
* Make the addUser.jsp work. Since we haven't added the database to the site yet you only have to create a servlet to receive the data for addUser.jsp. You should be able to do that by now. Use login.jsp to motivate you.

### Modifications
Things you should do now...

Modify feedback.jsp to contain the following form. Then modify this form to make it go to a servlet called Feedback.java. You will need to create the Feedback servlet.

This servlet will receive the feedback from the form and store the values in variables. After we connect the database we will put the values of these variables in the database. So you should modify the doPost method of the FeedbackServlet to receive the data from this form and store it in Java variables.

```html
<form action="" method="post">
  <input type="radio" name="subject" value="Question" checked> Question<br>
  <input type="radio" name="subject" value="Complaint"> Complaint<br>
  <input type="radio" name="subject" value="Comment"> Comment<br><br>
  <textarea name="feedback" rows="6" cols="50"></textarea><br><br>
  <input type="submit" value="Send Feedback">
</form> 
```
---
Look at navbar.jsp. You will see several list items in the unordered list. Each is denoted with an `<li>` tag. 
Modify each `<li>` tag to include a style attribute to display inline as follows:

```html
<li style="display: inline;">
 ```
 Notice how this changes the display of your unordered list when you refresh a page that uses the navbar.
 
 ---
The following code can be found in the ProfileServlet. You can put this code in any servlet that to ensure the user is logged in. Then if they are not they will be redirected to login.jsp. Make that modification now. BUt don't check the LoginServlet! They won't be logged in there!

```java
//make sure a user is in the session. If they don't exist then go back to the login page.
if (session.getAttribute("user")==null){
    //http://stackoverflow.com/questions/13638446/checking-servlet-session-attribute-value-in-jsp-file
    nextURL = "/login.jsp";
    response.sendRedirect(request.getContextPath() + nextURL);
    return;//return prevents an error; Don't believe me? Take it out.
}
 ```
---
Create the Newsfeed servlet. It will be called from the navbar. When the servlet is called it will go to the database and get all the posts as an arraylist. The arraylist will be sent to the newsfeed.jsp using `request.setAttribute("posts",posts)`.

**Example Code**

```java
ArrayList<Post> posts = new ArrayList<Post>();
//create a class called Post that contains email and text fields.
Post p = new Post();
p.setEmail("lisa@fox.net");
p.setText("This is the text of my post");
posts.add(p);
```

### How to create the tables in Oracle
Run the included scripts. You'll find them in the SQLScripts folder

### How to add JPA to the project
* copy JAR files to /WEB-INF/lib 
* add JAR files to the build path
* right-click on project and select properties then Project Facets then JPA
* modify persistence.xml
* generate JPA entities from tables
* create DbUtil in customTools package

### How to check for a valid user in login servlet

```java
if (action.equals("logout")){
	session.invalidate();
	nextURL = "/login.jsp";
	
}else{
	user = DbUser.getUserByEmail(useremail);
	if (DbUser.isValidUser(user)){
		session.setAttribute("user", user);
		int size = 30;
		String gravatarURL = DbUser.getGravatarURL(useremail, size);
		System.out.println(gravatarURL);
		session.setAttribute("gravatarURL", gravatarURL);
		nextURL = "/home.jsp";
	}else{
		nextURL = "/login.jsp";
	}
	
}
```

### Display the user's name and gravatar on the Home page


### Create a form for the user to submit a post

```java
<form role="form" action="PostServ" method="post">
    <div class="form-group">  
       <label for="post">Create New Post (141 char):</label>
       <textarea name= "posttext" id="posttext" class="form-control" rows="2" placeholder= "Express yourself!"></textarea>
    </div> 
    <div class = "form-group"> 
       <input type="submit" value="Submit" id="submit"/>
       <input type="reset" value="Clear"/>
    </div>  
</form> 
```
### Make the above form work
Notice the form's action is PostServ. That means it goes to the servlet called PostServ. Since the method is Post you need to next add the following code to doPost() in the PostServ servlet.

```java
	Date postdate = new Date();
		String posttext = request.getParameter("posttext");
		String nextURL = "/error.jsp";
		//need a reference to the session
		//get user out of session. If they don't exist then send them back to the login page.
		//kill the session while you're at it.
		HttpSession session = request.getSession();
		if (session.getAttribute("user")==null){
			//http://stackoverflow.com/questions/13638446/checking-servlet-session-attribute-value-in-jsp-file
			nextURL = "/login.jsp";
			session.invalidate();
			response.sendRedirect(request.getContextPath() + nextURL);
		    return;//return prevents an error
		}
		
		//get user information from session so we can connect to the db
		Bhuser user = (Bhuser)session.getAttribute("user");
		
		
		//get  a populated bhuser object since we'll add that to the post
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		String query = "select u from Bhuser u where u.useremail=:email";
		TypedQuery<Bhuser> q = em.createQuery(query,Bhuser.class);
		q.setParameter("email",user.getUseremail());
		
		Bhuser bhUser = null;
		try {
			bhUser = q.getSingleResult();
			System.out.println("The user id is: " + bhUser.getBhuserid());
			nextURL = "/Newsfeed";
		} catch (NoResultException e){
			System.out.println(e);
		} catch (NonUniqueResultException e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		//insert the post
		Bhpost bhPost = new Bhpost();
		bhPost.setBhuser(bhUser);
		bhPost.setPostdate(postdate);
		bhPost.setPosttext(posttext);
		
		DbBullhorn.insert(bhPost);
		
		//go to the newsfeed or error
		getServletContext().getRequestDispatcher(nextURL).forward(request, response);
```
### How to limit a post to 141 characters
 
Add the following attribute to the textarea on the form
```java
 maxlength="141"
 ```
 
### How to use JavaScript to show the number of remaining characters

Add the following DIV tag below the textarea on the form. This will be changed by the JavaScript to display the number of remaining characters.

```html
<div id="textarea_feedback"></div>
```

Add the following script to the bottom of body on home.jsp. The script tags should end before the body and html tags end.

```java
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
</script>
```

### How to add another function to ensure the user doesn't submit an empty post

Modify the form tag as follows:

```java
<form role="form" action="PostServ" method="post" onsubmit="return validate(this);">
```

Add the following JavaScript function between the script tags at the bottom of the page:

```java
function validate(form) {
	valid = true;
	if ($('#posttext').val().length==0){
		alert("You may not submit an empty post.");
		valid = false;
	}
	return valid;
}
```		
		            

### The newsfeed servlet
The newsfeed servlet displays all the posts. It can also display a filtered set of posts if it is called with the userid or searchtext parameters.

```java
		
		long filterByUserID = 0; 
		String searchtext = "";
		
		String nextURL = "/error.jsp";
		//get user out of session. If they don't exist then send them back to the login page.
		//kill the session while you're at it.
		HttpSession session = request.getSession();
		if (session.getAttribute("user")==null){
			//http://stackoverflow.com/questions/13638446/checking-servlet-session-attribute-value-in-jsp-file
			nextURL = "/login.jsp";
			session.invalidate();
			response.sendRedirect(request.getContextPath() + nextURL);
		    return;//return prevents an error
		}
		
		//get posts based on parameters; if no parameters then get all posts
		List<Bhpost> posts = null;
		if (request.getParameter("userid")!=null){
			filterByUserID = Integer.parseInt(request.getParameter("userid"));
			posts = DbBullhorn.postsofUser(filterByUserID);
		}else if (request.getParameter("searchtext")!=null){
			searchtext = request.getParameter("searchtext").toString();
			posts = DbBullhorn.searchPosts(searchtext);
		}else{
			posts = DbBullhorn.bhPost();
		}
		
		//add posts to session
		session.setAttribute("posts", posts);
		//display posts in newsfeed.jsp
		nextURL = "/newsfeed.jsp";
		//redirect to next page as indicated by the value of the nextURL variable
		getServletContext().getRequestDispatcher(nextURL).forward(request,response);
```

### How to display a list of posts in the newsfeed.jsp page

```html
<div class="container">
<table class="table table-bordered">
    <thead>
        <tr><th>User</th><th>Post</th><th>Date</th></tr>
    </thead>
    <tbody>
    <c:forEach var="post" items="${posts}">
        <tr><td><a href="ProfileServlet?action=viewprofile&userid=<c:out value="${post.bhuser.bhuserid}"/>"><c:out value="${post.bhuser.useremail}"/></a></td>
        <td><c:out value="${post.posttext}"/></td>
        <td><fmt:formatDate value="${post.postdate}" pattern="yy-MMM-dd"/></td>
        </tr>
    </c:forEach>
    </tbody>
    </table>

</div>
```


### The completed NavBar

```html
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <img src="images/bullhornlogo50x50.png" alt="Bullhorn Logo"/>&nbsp;<h2>Bullhorn</h2>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
 
      <ul class="nav navbar-nav">
        <li class="active"><a href="home.jsp">Home<span class="sr-only">(current)</span></a></li>
        <li><a href="Newsfeed">News Feed</a></li>      
      </ul>
    
      <form class="navbar-form navbar-right" role="search" action="Newsfeed" method="get">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search" name="searchtext">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
    
      <ul class="nav navbar-nav navbar-right">
      <% if (session.getAttribute("user") != null) { %>
        <li><a href="ProfileServlet?userid=${user.bhuserid}&action=viewprofile"><img alt="${user.username}" src="${gravatarURL}"/>&nbsp;${user.username}</a></li>
      <% } %>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">User Options <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li>
              <!-- <li><a href="LoginServlet?action=logout">Logout</a></li>-->
              <!-- Bootstrap allows me to put a form here and it will show in the navbar.
                   I want to use a form so it can call the servlet with the Post method.              
               -->
               <form class="navbar-form navbar-left" role="form" action="LoginServlet" method="post">
                  <input type="hidden" name="action" id="action" value="logout"/>
                  <button class="btn btn-default" id="addBookButton">Logout</button>        
               </form>
            </li>
            <li><a href="Newsfeed?userid=${user.bhuserid }">Show my Posts</a></li>
            <li><a href="ProfileServlet?userid=${user.bhuserid }&action=editprofile">Edit Profile</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="support.jsp">Feedback</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
```


 

