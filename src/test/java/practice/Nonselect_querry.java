package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Nonselect_querry {
	public static void main(String[] args) throws Throwable {
		Connection conn=null;
		int result=0;
		try {
			Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		System.out.println("connections is done");
		Statement stat = conn.createStatement();
		String query = "insert into project value('TY_PROJ_004','manny','13/01/2022','apple','completed',15)";
		 result= stat.executeUpdate(query);
	}catch(Exception e) {		
	}finally {
		if(result==1)
		{
			System.out.println("project inserted successfully");
		}
		else {
			System.out.println("project is not inserted");
		}
		conn.close();
		System.out.println("*********close db connection**********");
	}
		
	}

}
