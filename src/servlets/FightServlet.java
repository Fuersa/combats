package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FightServlet
 */
@WebServlet("/fight")
public class FightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/fight.jsp";
	
	int Strength1 = 10;
	int Intelligence1 = 2;
	int Personality1 = 2;
	int Endurance1 = 10; 
	int Accuracy1 = 10;
	int Luck1 = 0; 
	int Speed1 = 15;

	int uvorot1 = (int) (Speed1*2.5+Luck1);
	int antiuvorot1 = Speed1*2+Luck1;
	int krit1 = (int) (Accuracy1*1.5+Luck1);
	int antikrit1 = (int) (Accuracy1*2.2+Luck1);

	//-- Stats of the second char
	int Strength2 = 10;
	int Intelligence2 = 9;
	int Personality2 = 5;
	int Endurance2 = 15; 
	int Accuracy2 = 15;
	int Luck2 = 0; 
	int Speed2 = 10;

	int uvorot2 = (int) (Speed2*2.5+Luck2);
	int antiuvorot2 = Speed2*2+Luck2;
	int krit2 = (int) (Accuracy2*1.5+Luck2);
	int antikrit2 = (int) (Accuracy2*2.2+Luck2);

	int s_attack1, s_attack2, s_defend1, s_defend2;
	
	
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		dispatcher.forward(request, response);

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
