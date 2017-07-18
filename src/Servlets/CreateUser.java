package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DbPosts;
import customTools.DbUser;
import model.Bhpost;

/**
 * Servlet implementation class CreateUser
 */
@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String action = request.getParameter("action");
		String nextPage = "/error.jsp";//someplace to go if things don't work
		String message = "";
		HttpSession session = request.getSession();
		
		List<Bhpost> posts = null;
		
		
		//did they click the logout link?
		//first... check that the action variable contains something
		//then the code below will determine if they clicked logout and kill the session
		//before sending the user back to the login page
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

		posts = DbPosts.bhPost();
		session.setAttribute("posts",posts);
		
		//putting a blank message just ensures I have a blank message.Since the message is set in the session
		//it could still exist as the user navigates between pages so at the top of each page I should endure
		//the message attribute contains nothing. Alternatively, I could just remove it if it exists.
		session.setAttribute("message",message);

		//Existential question: Does the user exist? Are they really who they say they are???
		//And while you're at it... what is the meaning of life?
		if (DbUser.isValidUser(email,password)){
			//add the valid user to the session
			session.setAttribute("user", DbUser.getUserByEmail(email));
			nextPage = "/home.jsp";
		}else{
			//probably not necessary but you can clear all session variables just to be sure nobody can access them 
			session.invalidate();
			//they put in the wrong password or don't exist in the database
			nextPage = "/login.jsp";
		}

		//Your work here is done. Redirect to next page as indicated by the value of the nextURL variable
		response.sendRedirect(request.getContextPath() + nextPage);
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
