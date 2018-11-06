/*********************************************************************************
* Project: < COMP 3095 – Java Web Application Development>
* Assignment: < Assignment -1 >
* Author(s): < Igor Mori, Md Farhad Hossain , Yash  Thanki, Arifur Rahman >
* Student Number: < 101045762, 101056010, 101093832, 100883999>
* Date: 10/28/2018
* Description: <This java class is the user class with all user information needed to create a new user >
*********************************************************************************/
package helperClasses;

public class User {
	

private String firstname;
private String lastname;
private String email;
private final String ROLE="client";
private String username;
private String address;
private String password;

public User(){}

// constructor for userName and password validation
public User(String email, String password) {
	this.email = email;
	this.password = password;
}

// constructor for data base user validation
public User(String email, String password, String firstname) {
	this.email = email;
	this.password = password;
	this.firstname = firstname;
}



// constructor for user creation
public User(String firstname, String lastname, String email, String username, String address, String password)
{
    this.setFirstname(firstname);
    this.setLastname(lastname);
    this.setEmail(email);
    this.setUsername(username);
    this.setAddress(address);
    this.setPassword(password);
}



public String getFirstname() {
	return firstname;
}



public void setFirstname(String firstname) {
	this.firstname = firstname;
}



public String getLastname() {
	return lastname;
}



public void setLastname(String lastname) {
	this.lastname = lastname;
}



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}



public String getRole() {
	return ROLE;
}





public String getUsername() {
	return username;
}



public void setUsername(String username) {
	this.username = username;
}



public String getAddress() {
	return address;
}



public void setAddress(String address) {
	this.address = address;
}



public String getPassword() {
	return password;
}



public void setPassword(String password) {
	this.password = password;
}

}
