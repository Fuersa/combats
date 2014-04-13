package servlets;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserBean;
import daos.DAOUser;

/**
 * Servlet implementation class CharacterServlet
 */
@WebServlet("/char")
public class CharacterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/char.jsp";
	
	boolean frameIsActive;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		System.out.println("(CharacterServlet [doGet-Method]):			START CharacterServlet");
		try {
			System.out.println("(CharacterServlet [doGet-Method]):			try-catch block is started");
			
			// Creation UserBean object
			System.out.println("(CharacterServlet [doGet-Method]):			Creation USER BEAN");
			UserBean user = new UserBean();

			// Setting to user: Login, Password
			System.out.println("(CharacterServlet [doGet-Method]):			SETTING Nickname, Id, sessionID");
			user.setLogin(request.getParameter("nickname"));
			user.setUserId(request.getParameter("id"));
			user.setSessionID(request.getParameter("sessionID"));

			// User getting loggeg through DAOUser login
			System.out.println("(CharacterServlet [doGet-Method]):			start METHOD by user = DAOUser.getDetails(user)");
			user = DAOUser.getDetails(user);
			

			if(frameIsActive == true){
				frameIsActive = false;
			} else {
				frameIsActive = true;
			}
			request.setAttribute("frameIsActive", frameIsActive);
			
			
			if (user.isValid()) {
				System.out.println("(CharacterServlet [doGet-Method]):			IF-block started for USER.ISVALID");
				System.out.println("(CharacterServlet [doGet-Method]):			SETTING ATTRIBUTES TO THE REQUEST");
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);

				
				request.setAttribute("curHealth", user.getCurHealth());
				int mxhealth = Integer.parseInt(user.getMaxHealth()) + (3*Integer.parseInt(user.getEndurance()));
				request.setAttribute("maxHealth", mxhealth);
				
				
				
				request.setAttribute("sessionID", user.getSessionID()); //Session ID of the logged USER
				request.setAttribute("user", DAOUser.getDetails(user));
				
				System.out.println("(CharacterServlet [doGet-Method]):			Creation of the DISPATCHER and sending it to VIEW CHAR.JSP");
				RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
				dispatcher.forward(request, response);

				//response.sendRedirect("userLogged.jsp"); // logged-in page

				// if (user.getLogin().equals("admin")) {
				// response.sendRedirect("adminMenu.jsp"); // logged-in page as
				// // admin
				// } else {
				// response.sendRedirect("userLogged.jsp");
				// }

			} else {
				response.sendRedirect("invalidLogin.jsp"); // error page
			}
		}

		catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		PrintWriter out = response.getWriter();
		doGet(request, response);

	}
}