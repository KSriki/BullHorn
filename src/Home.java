

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
		String username = u.getUsername();
		
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
