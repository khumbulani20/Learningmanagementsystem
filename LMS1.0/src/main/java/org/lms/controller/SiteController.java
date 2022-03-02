package org.lms.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SiteController")
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteController() {
        super();
        // TODO Auto-generated constructor stub
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
		case "updateCourse":
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
		request.setAttribute("operation", "updateCourse");
		request.getRequestDispatcher("UpdateCourse.jsp").forward(request, response);
}
	
	

}
