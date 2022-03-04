<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="org.lms.entity.Course" %>
<%@ page import="java.util.List" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.css">
  


</head>
<body>
<table>
<tr>
<th>Course code </th>
<th> Course name</th>
<th> description</th>
<th>Capacity </th>
 <th>Operation </th>
</tr>
<%
List<Course> courses=(List) request.getAttribute("courseList");
String updateURL=null;
String deleteURL=null;
for(Course course:courses)
{
	out.print("<tr>");
	out.print("<td>"+course.getCourseCode()+"</td>");
	out.print("<td>"+course.getCourseName()+"</td>");
	out.print("<td>"+course.getDescription()+"</td>");
	out.print("<td>"+course.getCapacity()+"</td>");
	updateURL=request.getContextPath()+"/SiteController?page=updateCoursePage&courseCode="+course.getCourseCode();
	deleteURL=request.getContextPath()+"/DBController?operation=deleteCourse&courseCode="+course.getCourseCode();
	out.print("<td>"+"<a  href="+updateURL+">"+"Update </a>" +"</td>");
	out.print("<td>"+"<a  href="+deleteURL+">"+"Delete </a>" +"</td>");
	out.print("</tr>");
}



%>


<!-- </table>

 <table id="DT_load" class="table table table-striped table-bordered">
            <thead>
                <tr>
                    <th>Course code </th>
                    <th>Course name </th>
                    <th>description</th>
                    <th>capacity</th>
                    <th>update</th>
                    <th>Delete</th>
                   
                </tr>
            </thead>
            </table>

 
 -->








<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</body>
</html>