
import java.sql.*;

public class MysqlTest {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = 
					DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/loadtest"
					+ "?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false",
					"root", "root"
					);		
			Statement stmt = conn.createStatement();
			ResultSet rset = 
					stmt.executeQuery("select * from users");
			while(rset.next()) {
				System.out.println(rset.getInt(1)+" "+ rset.getString(2)+" "+rset.getString(6));
			}
			rset.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

