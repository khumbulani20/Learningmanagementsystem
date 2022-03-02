package org.lms.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.lms.entity.*;
public class LMSDatabase {
	
 
 

 

public static Connection Connect()
{
	Connection con=null;
	
	try {
		//load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lms?"+"user=root&password=");
		return con;
		
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
}
public List<Course> courseList(Connection con)
{
	String query="select * from courses"; 
	ResultSet rs=null;
	Statement st;
	List<Course> courses= new ArrayList<Course>();
	try {
		st = con.createStatement();
		rs=st.executeQuery(query);
		while(rs.next()) 
		{
			// Course(String courseCode, String courseName, String description, int capacity)
			  Course course= new Course(rs.getString("courseCode"), rs.getString("courseName"),rs.getString("description"),rs.getInt("capacity"));
			  courses.add(course); 
		}  

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	

	return courses;
}

public void addCourse()
{
	
}

public void deleteCourse()
{
	
}
public void updateCourse()
{
	
}
 

}
