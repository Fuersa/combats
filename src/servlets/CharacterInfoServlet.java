package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserBean;
import daos.DAOUser;

/**
 * THIS SERVLET IS NEED TO BE COMPLETED
 * ADD CHARACTER INFO
 * ADD HOROSCOPE
 * ADD SOCIAL NETWORK PAGE
 * ADD EXTRA INFO 
 * 	like QUOTE
 * 	
 */
@WebServlet("/inf")
public class CharacterInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/info.jsp";
	
	String login, password, sessionID;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/* [START DO GET METHOD IN  {LoginServlet}]*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/");
		
		// ****[COOKIES]****
		try{
			System.out.println("(LOGINSRVLET): Start try block of - COOKIES");
			//Set cookies: Parameters LOGIN and PASSWORD
			
			System.out.println("(LOGINSRVLET): Getting parameters from REQUEST: login, password");
			login = request.getParameter("login");
			password = request.getParameter("password");
			
			System.out.println("(LOGINSRVLET): Setting KEY and VALUE to cookies: usn = username and pas = password");
			Cookie usn = new Cookie("user", login);
			Cookie pas = new Cookie("pw", password);
			
			System.out.println("(LOGINSRVLET): Settin max age of the cookies: usn and pas to 24 hours");
			usn.setMaxAge(60*60*24); // 24 hours 
			pas.setMaxAge(60*60*24);
			
			System.out.println("(LOGINSRVLET): adding cookie to the response.");
			response.addCookie(usn);
			response.addCookie(pas);
			
			try {
				
				System.out.println("(LOGINSRVLET): start the second TRY - BLOCK in COOKIES");
				
				System.out.println("(LOGINSRVLET): Setting creating new cookie and list cookies");
				Cookie cookie = null;
				Cookie cookies [] = request.getCookies();
				
				System.out.println("(LOGINSRVLET): Start reading COOKIES");
				if(cookies!=null){
					System.out.println("(LOGINSRVLET): if(cookies!=null){  IS STARTED");
					//Iterating through Cookies to get all items from the Cookies array
					
					for(int i = 0; i<cookies.length; i++){
						System.out.println("(LOGINSRVLET): for(int i = 0; i<cookies.length; i++){ IS STARTED");
						cookie = cookies[i];
						
						//Getting the JSESSIONID from the cookie
						if(cookie.getName().toString().equals("JSESSIONID")){
							System.out.println("(LOGINSRVLET): if(cookie.getName().toString().equals('JSESSIONID')){ IS STARTED");
							System.out.println("(LOGINSRVLET): JSESSION ID IS: " + cookie.getValue());
							
							//Setting the JSESSIONID to our variable sessionID
							System.out.println("(LOGINSRVLET): Setting the value of SESSIONID variable");
							sessionID = cookie.getValue();
							
						}
						System.out.println("(LOGINSRVLET): GETTING: NAME and VALUE");
						System.out.println("(LOGINSRVLET): Name : " + cookie.getName());
						System.out.println("(LOGINSRVLET): Value :" + cookie.getValue());
					}
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}catch (Exception e){
			
		}

		System.out.println("(LOGINSRVLET): Started TRY-BLOCK of LOGIN USER");
		//********LOGIN USER *******
		try {
			
			// Creation UserBean object
			System.out.println("(LOGINSRVLET): Creation USER BEAN");
			UserBean user = new UserBean();

			// Setting to user: Login, Password
			System.out.println("(LOGINSRVLET): SETTING LOGIN AND PASSWORD to the USER (getting information from request)");
			user.setLogin(request.getParameter("login"));
			user.setUser_Pass(request.getParameter("password"));
			user.setSessionID(sessionID);

			// User getting logged through DAOUser login
			System.out.println("(LOGINSRVLET): User getting LOGGED by DAOUser login: user = DAOUser.login(user);");
			user = DAOUser.login(user);

			System.out.println("(LOGINSRVLET): ***AFTER METHOD DAOUser.login is finished (LOGINSRVLET)");
			System.out.println("(LOGINSRVLET): start IF block to check if the user is VALID (LOGINSRVLET)");
			if (user.isValid()) {

				System.out.println("(LOGINSRVLET): User is VALID, now setting the attributes to the request. (LOGINSRVLET)");
				request.setAttribute("login", user.getLogin());
				request.setAttribute("name", user.getFull_Name());
				request.setAttribute("bday", user.getUser_Birth_Day());
				request.setAttribute("id", user.getUserId());
				request.setAttribute("buildingId", user.getBuildingId());
				request.setAttribute("sessionID", sessionID);
				System.out.println("(LOGINSRVLET): Attributes SETTED (LOGINSRVLET)");
				
			    response.setHeader("Cache-Control","no-cache");  
			    response.setHeader("Cache-Control","no-store");  
			    response.setDateHeader("Expires", -1);  
			
			
				
				System.out.println("(LOGINSRVLET): Starting DISPATCHER and sending it to VIEW loggedIn.jsp (LOGINSRVLET)");
				RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
				System.out.println("(LOGINSRVLET): push dispatcher forward (LOGINSRVLET)");
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
		
		System.out.println("(LOGINSRVLET): DO POST starting doGet(request, response);");
		doGet(request, response);

	}
}