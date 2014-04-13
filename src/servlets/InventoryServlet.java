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

import daos.DAOUser;
import beans.UserBean;

/**
 * Servlet implementation class InventoryServlet
 */
@WebServlet("/inventory")
public class InventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/inventory.jsp";
	
	Connection con;
	PreparedStatement ps;
	
	String nickName, id;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserBean user = new UserBean();
		
		nickName = request.getParameter("nickName");
		id = request.getParameter("userId");
		
		user.setLogin(nickName);
		user.setUserId(id);
		
		
		System.out.println(DAOUser.getAllItemsOfThePlayer(user));
		
		request.setAttribute("itemsList", DAOUser.getAllItemsOfThePlayer(user));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
