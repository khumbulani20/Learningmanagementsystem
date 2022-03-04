package org.lms.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.lms.entity.*;
public class LMSDatabase {
	
private Connection con; 
 

 

public LMSDatabase() {
	try {
		//load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lms?"+"user=root&password=mbeki2019");
		 
		
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/*public static Connection Connect()
{
	Connection con=null;
	
	try {
		//load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lms?"+"user=root&password=mbeki2019");
		return con;
		
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
}*/
public List<Course> courseList()
{
	String query="select * from course"; 
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
		System.out.print(  "List displayed ");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	

	return courses;
}

public  Boolean addCourse(Course course)
{
	//insert into course values(courseCode, courseName, description, capacity)
	/*String query="insert into course values('"+course.getCourseCode()+"','"+course.getCourseName()+"','"+course.getDescription()+"',"+course.getCapacity()+")";
	try {
		Statement st = con.createStatement();
		st.execute(query);
		System.out.print(course+"course added ");
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	*/
	
	String query ="insert into course(courseCode, courseName, description, capacity) values(?,?,?,?)";
	try {
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, course.getCourseCode());
		st.setString(2, course.getCourseName());
		st.setString(3, course.getDescription());
		st.setInt(4, course.getCapacity());
		return st.execute();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	 
	
}

public void deleteCourse(String courseCode)
{
	String query="delete from course where courseCode= ?";
	PreparedStatement st= null;
	try {
		st=con.prepareStatement(query);
		st.setString(1, courseCode);
		st.execute();
		System.out.print("course deleted");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void updateCourse(Course updatedCourse,String courseID)
{
	PreparedStatement st=null;
	String courseCode=updatedCourse.getCourseCode();
	String courseName= updatedCourse.getCourseName();
	String description=updatedCourse.getDescription();
	int capacity=updatedCourse.getCapacity();
	//create a sql statement
	String query="update course set courseCode=?, courseName=?,description=?,capacity=? where courseCode=?";
	
	try {
		st= con.prepareStatement(query);
		
		st.setString(1, courseCode);
		st.setString(2, courseName);
		st.setString(3, description);
		st.setInt(4, capacity);
		st.setString(5, courseID);
		st.execute();
		System.out.print("course updated to  "+updatedCourse);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public Course getCourseByCode(String courseCode ) {
	Course course= null;
	
	String query= "select * from course where courseCode='"+courseCode+"'";
	
try {
	Statement st = con.createStatement();

	ResultSet rs= st.executeQuery(query);
	if(rs.next())
	{
		course= new Course(rs.getString("courseCode"),rs.getString("courseName"),rs.getString("description"),rs.getInt("capacity"));
	}
	return course;
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	return null;
 
	
}
 

}
