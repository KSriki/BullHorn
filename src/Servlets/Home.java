
package Servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Bhuser;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Home() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//direct to home page
		String nextURL = "/home.jsp";
	
		//and display user information from the session
		HttpSession session = request.getSession();
		//get user out of session
		Bhuser u = (Bhuser) session.getAttribute("user");

		//session.setAttribute("EmailResponse",null);
		String username = u.getUsername();
		//make sure a user is in the session. If they don't exist then go back to the login page.
		if (session.getAttribute("user")==null){
			//http://stackoverflow.com/questions/13638446/checking-servlet-session-attribute-value-in-jsp-file
			nextURL = "/login.jsp";
			response.sendRedirect(request.getContextPath() + nextURL);
			return;//return prevents an error; Don't believe me? Take it out.
		}
		
		
		//create a message to send to the home page
		String message = "Welcome, " + username;
		
		//set the message in the next jsp 		
	    session.setAttribute("message", message);
		
		getServletContext().getRequestDispatcher(nextURL).forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
