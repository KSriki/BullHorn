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

import customTools.DbUser;
import model.Bhpost;
import model.Bhuser;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//direct to home page

		String email = request.getParameter("useremail");
		String username = request.getParameter("username");
		String motto = request.getParameter("usermotto");
	
		String nextPage = "/home.jsp";
		Bhuser check = DbUser.getUserByEmail(email);
		
		HttpSession session = request.getSession();
	
		String exist = "Failed to update profile!";
	
		//did they click the logout link?
		//first... check that the action variable contains something
		//then the code below will determine if they clicked logout and kill the session
		//before sending the user back to the login page
	

		
		if(check == null){
			request.setAttribute("Exists",exist );
			//set update fail alert
			getServletContext().getRequestDispatcher(nextPage).forward(request,response);
	        return;//return here exits the method and prevents an error
		}
		exist = "Update Succeeded!";
		request.setAttribute("Exists",exist );
		//session.setAttribute("editProfile", true);
		check.setUseremail(email);
		check.setUsername(username);
		check.setMotto(motto);
		DbUser.update(check);
		nextPage="/home.jsp";
		getServletContext().getRequestDispatcher(nextPage).forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
