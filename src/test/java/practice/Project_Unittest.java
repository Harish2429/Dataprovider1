package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.mysql.jdbc.Driver;

public class Project_Unittest {
	@Test
	public void ProjectunitTest() throws Throwable {
	    String ProjectName = "Jobrace";
	     Connection conn= null;
		try {
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
		     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			System.out.println("connection is done");
			Statement stat = conn.createStatement();  
			String query = "select* from project";
			ResultSet resultset = stat.executeQuery(query);
			Boolean flag=false;
			while (resultset.next()) {
				String actProjectname = resultset.getString(4);
				if(actProjectname.equals(ProjectName)) {
					flag=true;
				}
			}
			Assert.assertTrue(flag);
		}catch(Exception e) {
			
		}finally {
			conn.close();
			System.out.println("***********close db*************");
		}
	}

}
