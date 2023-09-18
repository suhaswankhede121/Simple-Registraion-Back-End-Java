package sample;
import java.sql.*;
public class ConCheck {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.cj.Driver");
			Connection con=null;
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/suhas","root","root");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(con!=null) {
				System.out.println("hence it is good");
			}
			System.out.println("not connected");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        
	}

}
