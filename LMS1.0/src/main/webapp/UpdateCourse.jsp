<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="org.lms.entity.Course" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/DBController?operation=updateCourse" method="post">
<%
//String courseCode=request.getParameter("courseCode");
Course course=(Course)request.getAttribute("course");
String courseCode="";
String courseName="";
String description="";
int capacity=0;
if(course==null)
{
	course= new Course(courseCode, courseName, description, capacity);
}
%>
<label for="courseCode">Course code: </label><input type="text" name="courseCode" value="<%=course.getCourseCode() %>"  required>
<br/><br/>
<label for="courseName">Course Name: </label><input type="text" name="courseName"  value="<%=course.getCourseName() %>" required>
<br/>
<br/>
<label for="description">Description  : </label><input type="text" name="description" value="<%=course.getDescription() %>" required>
<br/>
<br/>
<label for="capacity">Capacity: </label><input type="number" name="capacity" value="<%=course.getCapacity() %>"required>
<br/>
<br/>
 <input type="hidden" name="courseID" value="<%=course.getCourseCode() %>"  >
 
<input type ="submit" value="Save">


</form>

<script type="text/javascript" src="script.js"></script>
</body>
</html>