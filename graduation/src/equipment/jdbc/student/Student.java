package equipment.jdbc.student;

public class Student {
	 private String name;
	 private String class1;
	 private String studentid;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClass1() {
		return class1;
	}
	public void setClass1(String class1) {
		this.class1 = class1;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", class1=" + class1 + ", studentid="
				+ studentid + "]";
	}
	 
}
