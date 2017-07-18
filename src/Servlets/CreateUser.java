package Servlets;

import java.io.IOException;
import java.util.Date;
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
import model.Bhuser;

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
//		
//	
		String email = request.getParameter("nEmail");
		String username = request.getParameter("nName");
		String password = request.getParameter("nPassword");
	
		String nextPage = "/login.jsp";
		Bhuser check = DbUser.getUserByEmail(email);
		List<Bhpost> posts = null;
		HttpSession session = request.getSession();
		String message = "";
		//did they click the logout link?
		//first... check that the action variable contains something
		//then the code below will determine if they clicked logout and kill the session
		//before sending the user back to the login page
	

		
		if(check != null){
			
			String exist = "This email is already registered";
			request.setAttribute("Exists",exist );
			getServletContext().getRequestDispatcher(nextPage).forward(request,response);
	        return;//return here exits the method and prevents an error
		}
		
		Bhuser newUser = new Bhuser();
		Date temp = new Date();
		newUser.setJoindate(temp);
		newUser.setMotto("Hello World");
		newUser.setUseremail(email);
		newUser.setUsername(username);
		newUser.setUserpassword(password);
		DbUser.insert(newUser);
		String worked = "User Created! Please login now!";
		request.setAttribute("Exists",worked );
		
		getServletContext().getRequestDispatcher(nextPage).forward(request,response);
//	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
