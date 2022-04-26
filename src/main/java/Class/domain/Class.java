package Class.domain;

public class Class {
	/*
	 * Correspond to the class table
	 */
	private Integer ClassID;
	private String ClassName;
	private Integer InstructorID;
	private String Semester;

	public void setClassID(Integer id) {
		this.ClassID = id;
	}

	public void setClassName(String name) {
		this.ClassName = name;
	}

	public void setInstructorID(Integer id) {
		this.InstructorID = id;
	}

	public void setSemester(String sem) {
		this.Semester = sem;
	}

	public Integer getClassID() {
		return this.ClassID;
	}

	public String getClassName() {
		return this.ClassName;
	}

	public Integer getInstructorID() {
		return this.InstructorID;
	}

	public String getSemester() {
		return this.Semester;
	}

}
