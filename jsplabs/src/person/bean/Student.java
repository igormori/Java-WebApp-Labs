package person.bean;

public class Student {

	private String firstName = null;
	private String lastName = null;
	private int age = 0;
	private String id =null;
	
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	public String getid() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
