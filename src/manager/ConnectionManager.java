package manager;

import java.sql.*;
import java.util.*;

public class ConnectionManager {

	static Connection con;
	static String url;

	public static Connection getConnection() throws SQLException {
System.out.println("$$$$(ConnectionMannager.java [getConnection-Method]):     START THE FILE");
		try {
			String url = "jdbc:mysql://localhost:3306/mmclub";
			// assuming "DataSource" is your DataSource name

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "root");
			System.out.println("$$$$(ConnectionMannager.java [getConnection-Method]):     Start reading CON");
			System.out.println("$$$$(ConnectionMannager.java [getConnection-Method]):     " +con.toString());
			System.out.println("$$$$(ConnectionMannager.java [getConnection-Method]):     END reading CON");

		}

		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		Statement st = con.createStatement();
		
		ResultSet res = st.executeQuery("SELECT * FROM  users");
		//return the connection
		System.out.println("$$$$(ConnectionMannager.java [getConnection-Method]):     RETURN THE CONNECTION: "+ con);
		return con;
	}
}
