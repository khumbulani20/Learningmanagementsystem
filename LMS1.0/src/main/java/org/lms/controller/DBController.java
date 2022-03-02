package org.lms.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import org.lms.model.*;

/**
 * Servlet implementation class DBController
 */
public class DBController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LMSDatabase db;
       
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
		 Connection con=LMSDatabase.Connect();
		 request.setAttribute("courseList", db.courseList(con));
		 request.getRequestDispatcher("CourseList.jsp").forward(request, response);
			break;
		case "addCourse":
		 
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
