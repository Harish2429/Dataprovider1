package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class Selectquerry_Sample {
	public static void main(String[] args) throws Throwable {
		Connection conn=null;
		try {
			Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		System.out.println("connections is done");
		Statement stat = conn.createStatement();
		String query = "select * from project";
		ResultSet resultset = stat.executeQuery(query);
		System.out.println(resultset);
		while (resultset.next()) {
			System.out.println(resultset.getString(1)+"\t"+resultset.getString(2));
		}
	}catch(Exception e) {		
	}finally {
		conn.close();
		System.out.println("**********close db*****");
		
	}

}
}
