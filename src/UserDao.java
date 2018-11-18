import java.sql.*;
import java.util.ArrayList;

public class UserDao {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://localhost:5432/cmpe279";

	// Database credentials
	static final String USER = "postgres";
	static final String PASS = "root";

	public static boolean validate(String name, String pass) {
		boolean status = false;
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

			Statement ps = con.createStatement();
			String sql = "select * from Users where uname='"+name+"' and password='"+pass+"'";
			ResultSet rs = ps.executeQuery(sql);
			
			status = rs.next();
			rs.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static ArrayList<String[]> get_user_info(String name) {
		ArrayList<String[]> data = new ArrayList<>();
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

			Statement ps = con.createStatement();
			String sql = "select fname, lname from Users where uname='"+name+"'";
			ResultSet rs = ps.executeQuery(sql);
			
			while(rs.next()) {
				String[] d =  {rs.getString("fname"), rs.getString("lname")};
				data.add(d);
			}
			rs.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return data;
	}
	
	
	public static boolean insert_user_info(String name, String fname, String lname, String pass) {
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

			Statement ps = con.createStatement();
			String sql = "insert into users (uname,fname, lname,password) values('"+name+"','"+fname+"','"+lname+"','"+pass+"')";
			ps.executeUpdate(sql);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
}
