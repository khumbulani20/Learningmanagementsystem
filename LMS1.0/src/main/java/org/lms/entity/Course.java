package org.lms.entity;

public class Course {
	
private String courseCode;
private String courseName;
private String description;
private int capacity;

public Course(String courseCode, String courseName, String description, int capacity) {
	super();
	this.courseCode = courseCode;
	this.courseName = courseName;
	this.description = description;
	this.capacity = capacity;
}

public String getCourseCode() {
	return courseCode;
}
public void setCourseCode(String courseCode) {
	this.courseCode = courseCode;
}
public String getCourseName() {
	return courseName;
}
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getCapacity() {
	return capacity;
}
public void setCapacity(int capacity) {
	this.capacity = capacity;
}

@Override
public String toString() {
	return "Course courseCode :" + courseCode + ", courseName: " + courseName + ", description :" + description
			+ ", capacity:" + capacity ;
}





}
