package Servlets;

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DbPosts;
import customTools.DbUtil;
import model.Bhpost;
import model.Bhuser;

/**
 * Servlet implementation class PostServ
 */
@WebServlet("/PostServ")
public class PostServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
				
				DbPosts.insert(bhPost);
				
				//go to the newsfeed or error
				getServletContext().getRequestDispatcher(nextURL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
