<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="org.lms.entity.Course" %>
<%@ page import="java.util.List" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
String tempURL=null;
for(Course course:courses)
{
	out.print("<tr>");
	out.print("<td>"+course.getCourseCode()+"</td>");
	out.print("<td>"+course.getCourseName()+"</td>");
	out.print("<td>"+course.getDescription()+"</td>");
	out.print("<td>"+course.getCapacity()+"</td>");
	tempURL=request.getContextPath()+"/SiteController?page=updateCourse&courseCode="+course.getCourseCode();

	out.print("<td>"+"<a  href="+tempURL+">"+"Update </a>" +"</td>");
	out.print("</tr>");
}



%>


</table>

</body>
</html>