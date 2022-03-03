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
        con=LMSDatabase.Connect();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String operation=request.getParameter("operation");
		switch(operation)
		{
		case "courseList":
		 
		 request.setAttribute("courseList", db.courseList(con));
		 request.getRequestDispatcher("CourseList.jsp").forward(request, response);
			break;
		case "addCourse":
		 //get data from the form
			
			String courseCode= request.getParameter("courseCode");
			String courseName= request.getParameter("courseName");
			String description= request.getParameter("description");
			int capacity= Integer.parseInt(request.getParameter("capacity"));
			
			Course course=new Course(courseCode,courseName,description,capacity);
			
			LMSDatabase.addCourse(course, con);
			
			break;
		case "addUser":
			 
			break;
		case "deleteCourse":
			 
			break;
		case "updateCourse":
			 
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

}
