package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.RoomBean;
import beans.UserBean;
import daos.DAOUser;

/**
 * Servlet implementation class RoomServlet
 */
@WebServlet("/room")
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/room.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("|||||||||*** START SERVLET [--ROOM SERVLET--] ==>(METHOD)=> [--doGet--]  ***|||||||||");
		try {
			
			System.out.println("Start TRY in ROOMSERVLET  --  Creation UserBean and RoomBean Object");
			// Creation UserBean object
			UserBean user = new UserBean();
			RoomBean room = new RoomBean();
			RoomBean room2 = new RoomBean();
			Map userList = new HashMap();
			
			// Setting to user: Login, Password
			room.setUserLogin(request.getParameter("nickname"));
			room.setBuilding_id(request.getParameter("buildingId"));
			
			// User getting logged through DAOUser login
			room = DAOUser.getRoomDetails(room);
			room2 = DAOUser.getRoomCount(room);
			userList = DAOUser.getPlayersInCurrentRoom(room);
			
			System.out.println("+++++++++++++++++++++++ USER LIST PRINT: " + userList);
			
//			Iterator it = userList.entrySet().iterator();
//		    while (it.hasNext()) {
//		        Map.Entry pairs = (Map.Entry)it.next();
//		        System.out.println("Name :" +pairs.getKey() + " [" + pairs.getValue()+"]");
//		        it.remove(); // avoids a ConcurrentModificationException
//		    }
			

			HttpSession session = request.getSession(true);
			session.setAttribute("currentSessionUser", user);

			request.setAttribute("login", room.getUserLogin());
			request.setAttribute("building", room.getBuilding_id());
			request.setAttribute("roomName", room.getRoom_name());
			request.setAttribute("count", room2.getCount());
			request.setAttribute("myMap", userList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
			dispatcher.forward(request, response);
		}

		catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		doGet(request, response);

	}
}