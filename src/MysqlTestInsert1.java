
import java.sql.*;

public class MysqlTestInsert1 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = 
					DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/loadtest"
					+ "?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false",
					"root", "root"
					);		
			
			//conn.prepareStatement("TRUNCATE TABLE testloadtable").execute();
			//conn.prepareStatement("ALTER SESSION SET SQL_TRACE=TRUE").execute();
			
			long stTime = System.currentTimeMillis();
			
			PreparedStatement stmt = conn.prepareStatement("INSERT /* conventional insert with commit */ INTO testloadtable (id, text) VALUES (?,?)");
			 
			for (int i=0;i<10000;i++)
			{
			  stmt.setInt(1, i);
			  stmt.setString(2, "test" + i);
			  stmt.execute();
			  if(i%100 == 0){
				  System.out.println("CheckPoint:"+i);
			  }
			  //conn.commit();
			}
			 
			long edTime = System.currentTimeMillis();
			System.out.println(" ed = st : "+(edTime-stTime)+" ms");
			//conn.prepareStatement("ALTER SESSION SET SQL_TRACE=FALSE").execute();

						
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

