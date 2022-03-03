<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/DBController?operation=addUser" method="post">

<label for="courseCode">Course code: </label><input type="text" name="courseCode" required>
<br/><br/>
<label for="courseName">Course code: </label><input type="text" name="courseName" required>
<br/>
<br/>
<label for="description">Course code: </label><input type="text" name="description" required>
<br/>
<br/>
<label for="capacity">Course code: </label><input type="text" name="capacity" required>
<br/>
<br/>
 
 
 <input type ="submit" value="Save">


</form>
</body>
</html>