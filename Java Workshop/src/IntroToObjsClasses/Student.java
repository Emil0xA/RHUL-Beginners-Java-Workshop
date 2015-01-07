package IntroToObjsClasses;

/**
 * A Student class.
 * 
 * @author Emil Tan
 */
public class Student {
	private String name; 
	private int age; 
	private String gender; 
	private String department; 
	
	public Student(String stuName, int stuAge, String stuGender) {
		name = stuName; 
		age = stuAge; 
		gender = stuGender;
	}
	
	public Student(String stuName, int stuAge, String stuGender, String stuDepartment) {
		name = stuName; 
		age = stuAge; 
		gender = stuGender; 
		department = stuDepartment;
	}
	
	public void yearOlder() {
		age++; 
	}
	
	public void changeDepartment(String newDepartment) {
		department = newDepartment; 
	}
	
	public String getName() {
		return name; 
	}
	
	public int getAge() {
		return age; 
	}
	
	public String getGender() {
		return gender; 
	}
	
	public String getDepartment() {
		return department; 
	}
}
