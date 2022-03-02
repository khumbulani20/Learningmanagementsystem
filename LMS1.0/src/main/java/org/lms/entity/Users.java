package org.lms.entity;

public class Users {
private String userID;
private String useraname;
private String password;
private String firstName;
private String lastName;
private String role;
 
public Users(String userID, String useraname, String password, String firstName, String lastName, String role) {
	super();
	this.userID = userID;
	this.useraname = useraname;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
	this.role = role;
}
public String getUserID() {
	return userID;
}
public void setUserID(String userID) {
	this.userID = userID;
}
public String getUseraname() {
	return useraname;
}
public void setUseraname(String useraname) {
	this.useraname = useraname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
@Override
public String toString() {
	return "User:  " + userID + ",  " + useraname + ",  " + firstName + ",  "
			+ lastName + ",  " + role  ;
}




}
