package org.lms.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import org.lms.entity.Course;
import org.lms.model.LMSDatabase;

@WebServlet("/SiteController")
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LMSDatabase db;
	private Connection con;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteController() {
        db= new LMSDatabase();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String page=request.getParameter("page");
		switch(page)
		{
		case "home":
			homePage(request, response);
			break;
		case "addCourse":
			addCoursePage(request, response);
			break;
		case "deleteCourse":
			deleteCoursePage(request, response);
			break;
		case "updateCoursePage":
			updateCoursePage(request, response);
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
	
	
	public void homePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			request.getRequestDispatcher("Home.jsp").forward(request, response);
	}
	public void addCoursePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("operation", "addCourse");
		request.getRequestDispatcher("InsertCourse.jsp").forward(request, response);
}
	public void deleteCoursePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("operation", "deleteCourse");
		request.getRequestDispatcher("DeleteCourse.jsp").forward(request, response);
}
	public void updateCoursePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("operation", "updateCourse");
		
		//get courseCode
		String courseID= request.getParameter("courseCode");
		
		//get course from db
		Course cou=db.getCourseByCode(courseID);
		//forward to updatePage
		request.setAttribute("course", cou);
		
		request.getRequestDispatcher("UpdateCourse.jsp").forward(request, response);
}
	
	

}
