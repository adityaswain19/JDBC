package tech.csm.domain;

public class student {
	private String name;
	private int rollNo;
	private String course;
	private int marks;
	private String grade;
	public student(String name, int rollNo, String course, int marks) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.course = course;
		this.marks = marks;
		this.grade = student.grade(marks);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "student [name=" + name + ", rollNo=" + rollNo + ", course=" + course + ", marks=" + marks + ", grade="
				+ grade + "]";
	}
	static String grade(int marks) {
		if(marks>=400) {
			return "A";
		}
		else if(marks>=300) {
			return "B";
		}
		else if(marks>=200) {
			return "C";
		}
		else {
			return "Fail";
		}
	}
	
	public void update(int newmarks) {
		this.marks=newmarks;
		System.out.println(grade(this.marks));
	}
	public void changeCourse(String newCourse) {
		this.course=newCourse;
	}

}
