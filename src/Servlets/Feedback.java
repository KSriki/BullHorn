package Servlets;

import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Bhuser;

/**
 * Servlet implementation class Feedback
 */
@WebServlet("/Feedback")
public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Feedback() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//make sure a user is in the session. If they don't exist then go back to the login page.
		
		String subject = request.getParameter("subject");
		String body = request.getParameter("feedback");
	
		
		HttpSession sess = request.getSession();
		Bhuser bhuser = (Bhuser) sess.getAttribute("user");
		String nextURL = "/home.jsp";
		if (sess.getAttribute("user")==null){
			//http://stackoverflow.com/questions/13638446/checking-servlet-session-attribute-value-in-jsp-file
			nextURL = "/login.jsp";
			response.sendRedirect(request.getContextPath() + nextURL);
			return;//return prevents an error; Don't believe me? Take it out.
		}
		
		 Properties props = new Properties();
	        props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.host", "localhost");
	        props.put("mail.smtp.port", 2000);
	        props.put("mail.smtp.auth", "false");
	        props.put("mail.smtp.quitwait", "false");
	        //NOTE: Session object is part of javax.mail.Session
	        javax.mail.Session session = javax.mail.Session.getDefaultInstance(props);
		
	        Message message = new MimeMessage(session);
	        try {
				message.setSubject(subject);
			} catch (MessagingException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
	     
	        try {
				message.setText(body);
			} catch (MessagingException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
	       
	        Address fromAddress = null;
			try {
				fromAddress = new InternetAddress(bhuser.getUseremail());
			} catch (AddressException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
	        Address toAddress = null;
			try {
				toAddress = new InternetAddress("admin@bullhorn.com");
			} catch (AddressException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	        try {
				message.setFrom(fromAddress);
			} catch (MessagingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        try {
				message.setRecipient(Message.RecipientType.TO, toAddress);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        Transport transport = null;
			try {
				transport = session.getTransport();
				   transport.connect();
			        transport.sendMessage(message, message.getAllRecipients());
			} catch (NoSuchProviderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				 try {
					transport.close();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	     
			String temp = "Thank you for your feedback! Expect a Response within the next few days!";
			request.setAttribute("EmailResponse", temp);
			
			getServletContext().getRequestDispatcher(nextURL).forward(request,response);
	       	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
