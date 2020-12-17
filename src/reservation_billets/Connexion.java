package reservation_billets;

import java.sql.*;

public class Connexion {
	private static Connection conn;
	static
	{
		try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation_billet","root","");
	}
	 catch(Exception e ) {
		System.out.println(e.getMessage());
	}
	}
	public static Connection getConnection(){
		return conn;
	}
	
}
