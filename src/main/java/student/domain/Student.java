package student.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Student{
	/*
	 * Correspond to the user table
	 */
	
	private Integer UID;
	private Integer ClassID; 
	private String enrolled;
	private String DegreeType;
	
	
	public Integer getUID() {
		return UID;
	}

	public void setUID(Integer UID) {
		this.UID = UID;
	}

	public Integer getClassID() {
		return ClassID;
	}

	public void setClassID(Integer ClassID) {
		this.ClassID= ClassID;
	}

	public String getEnrolled() {
		return enrolled;
	}

	public void setEnrolled(String enrolled) {
		this.enrolled = enrolled;
	}
	
	public String getDegreeType() {
		return DegreeType;
	}

	public void setDegreeType(String DegreeType) {
		this.DegreeType= DegreeType;
	}

}
