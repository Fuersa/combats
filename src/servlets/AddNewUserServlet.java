package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AddNewUserServlet
 */
@WebServlet("/adduser")
public class AddNewUserServlet extends HttpServlet {
	Connection con;
	PreparedStatement ps;
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/userAdded.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("|||||||||*** START SERVLET [--AddUserServlet.java--] ***|||||||||");
		System.out.println("START -- public Void init");
		super.init(config);
		try {

			// START -- connection to database
			String url = "jdbc:mysql://localhost:3306/mmclub";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "root");

			// "START -- reading CON"
			System.out.println("START -- reading CON");
			System.out.println(con.toString());
			// "END reading CON"

			// "Create statement and query select from."
			System.out.println("Create statement and query select from.");
			Statement st = (Statement) con.createStatement();
			
			// Select USER_ID from USERS
			System.out.println("Select USER_ID from USERS");
			ResultSet rs = (ResultSet) st.executeQuery("SELECT USER_ID FROM users"); 
			int id = 0;

			// Create new USER ID with last one + 1
			System.out.println("Create new USER ID with last one + 1");
			if (rs.last()) { // Select Last USER_ID from TABLE
			}

			//"Creation prepared statement."
			System.out.println("Creation prepared statement");
			ps = con.prepareStatement("insert into users value(" + id + ",?,?,?,?,?,?,?,?,?,?)");
			System.out.println("END -- public void init");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("START -- 'doGet' method. in AddNewUserServlet");
		
		/* Get parameters */
		System.out.println("Get parameters from REQUEST.");
		System.out.println("get LOGIN");
		String login = request.getParameter("login");
		System.out.println("get PASSWORD");
		String password = request.getParameter("password");
//		String sessionId = request.getParameter("sessionId");
//		String sessionId = request.getSession().getId();
		System.out.println("get EMAIL");
		String email = request.getParameter("email");
		System.out.println("get NAME");
		String name = request.getParameter("name");
//		String question = request.getParameter("question");
		System.out.println("get ANSWER");
		String answer = request.getParameter("answer");
		System.out.println("get GENDER");
		String gender= request.getParameter("gender");
		System.out.println("get CITY");
		String city= request.getParameter("city");
//		String icq= request.getParameter("icq");
		//Need to ADD birthday or the user to the querty
		//Need to ADD birthday of the CharacterServlet to the query
		System.out.println("set BDAYUSER and BDAYCHARACTER");
		String bdayuser = "1999-02-02";
		String bdaychar = "1999-02-02";
		int sessionId = 5;
		// String choice [] = request.getParameterValues("choice");
		System.out.println("request gettin parameter names");
		request.getParameterNames();
		int num = 0;

		/* Add parameters to PARAMETER STATEMENT */
		System.out.println("Set ATTRIBUTES to PREPARED STATEMENT");
		try {
			System.out.println("try block is started***");
			ps.setString(1, login);
			ps.setString(2, password);
			ps.setInt(3, sessionId);
			ps.setString(4, email);
			ps.setString(5, answer);
			ps.setString(6, name);
			ps.setString(7, bdayuser);
			ps.setString(8, bdaychar);
			ps.setString(9, gender);
			ps.setString(10, city);
			//
			// String temp = null;
			// for(String str:choice){
			// temp+=str;
			// }
			//
			// ps.setString(4, temp);
			
			System.out.println("EXECUTE QUERY ---");
			num = ps.executeUpdate();
			System.out.println("Querty executed ***");

			/* set attribute to REQUEST */
			System.out.println("SET ATTRIBUTES TO 'REQUEST'");
			request.setAttribute(request.getParameter("login"), "login");
			request.setAttribute(request.getParameter("name"), "name");
			request.setAttribute(request.getParameter("city"), "city");
			request.setAttribute(request.getParameter("email"), "email");
			request.setAttribute(request.getParameter("gender"), "gender");
			System.out.println("SET ATTRIBUTES TO 'REQUEST' = DONE ***");

			/* PUSH REQUESTDISPATCHER FORWARD TO "UserAddedScreen"*/
			System.out.println("START -- REQUEST DISPATCHER");
			RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
			
			//"PUSH requst & response FORWARD"
			dispatcher.forward(request, response);
			System.out.println("PUSH requst & response FORWARD = DONE");
			System.out.println("END -- doGet");
			System.out.println("|||||||||*** END SERVLET [--AddUserServlet.java--] ***|||||||||");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* Destroy connection */
	@Override
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(request.getParameter("lastname") request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
