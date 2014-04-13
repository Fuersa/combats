package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.DAOUser;
import beans.UserBean;

/**
 * Servlet implementation class AddStatsServlet
 */
@WebServlet("/addStats")
public class AddStatsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/char.jsp";
	
	Connection con;
	PreparedStatement ps;

	String nickName, nameOfTheStat, query, currentTotalStat,notUsedStats,id;
	boolean valid = false;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserBean user = new UserBean();

		nickName = request.getParameter("nickName");
		currentTotalStat = request.getParameter("stat");
		nameOfTheStat = request.getParameter("setstat");
		notUsedStats = request.getParameter("notUsedStats");
		id = request.getParameter("userId");
		
		user.setLogin(nickName);
		user.setCurrentTotalStat(currentTotalStat);
		user.setNameOfTheStat(nameOfTheStat);
		user.setNotUsedStats(notUsedStats);
		user.setUserId(id);
		
		DAOUser.addStat(user);
		user = DAOUser.getDetails(user);
		
			System.out.println("(CharacterServlet [doGet-Method]):			IF-block started for USER.ISVALID");
			System.out.println("(CharacterServlet [doGet-Method]):			SETTING ATTRIBUTES TO THE REQUEST");
			HttpSession session = request.getSession(true);
			session.setAttribute("currentSessionUser", user);
			
			//HP calculation
			request.setAttribute("curHealth", user.getCurHealth());
			int mxhealth = Integer.parseInt(user.getMaxHealth()) + (3*Integer.parseInt(user.getEndurance()));
			request.setAttribute("maxHealth", mxhealth);
			
			request.setAttribute("sessionID", user.getSessionID()); //Session ID of the logged USER
			
			//Sending the USER bean to JSP
			request.setAttribute("user", DAOUser.getDetails(user));
			
			System.out.println("(CharacterServlet [doGet-Method]):			Creation of the DISPATCHER and sending it to VIEW CHAR.JSP");
			RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
			dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out
				.println("(ADDSTATSSERVLET): DO POST starting doGet(request, response);");
		doGet(request, response);
	}

}
