package org.lms.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import org.lms.entity.Course;
import org.lms.model.*;

/**
 * Servlet implementation class DBController
 */
public class DBController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LMSDatabase db;
	 Connection con;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBController() {
     db= new LMSDatabase();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String operation=request.getParameter("operation");
		switch(operation)
		{
		case "courseList":
		 
			listCourses(request,response);
			break;
		case "addCourse":
		 //get data from the form
			
			String courseCode= request.getParameter("courseCode");
			String courseName= request.getParameter("courseName");
			String description= request.getParameter("description");
			int capacity= Integer.parseInt(request.getParameter("capacity"));
			
			Course course=new Course(courseCode,courseName,description,capacity);
			
			db.addCourse(course);
			//display the list of courses after
			
			
			break;
		case "addUser":
			 
			break;
		case "deleteCourse":
			deleteCourse(request, response);
			break;
		case "updateCourse":
			//get courseCode
			String courseID= request.getParameter("courseID");
			Course updatedCourse=new Course(request.getParameter("courseCode"),request.getParameter("courseName"),request.getParameter("description"),Integer.parseInt(request.getParameter("capacity")));
			//forward to updatePage
			updateCourse(updatedCourse,courseID);
			
			
			listCourses(request,response);
			break;
			default:
				break;
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void updateCourse(Course course,String courseID)
	{
		db.updateCourse(course, courseID);
		
		
	}
	public void listUsers()
	{
		
	}
	public void listCourses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 request.setAttribute("courseList", db.courseList());
		 request.getRequestDispatcher("CourseList.jsp").forward(request, response);
	}
	public void deleteCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		//delete 
		String courseCode= request.getParameter("courseCode");
		db.deleteCourse(courseCode);
		
		//redirect to list
		 request.setAttribute("courseList", db.courseList());
		 request.getRequestDispatcher("CourseList.jsp").forward(request, response);
	}

}
