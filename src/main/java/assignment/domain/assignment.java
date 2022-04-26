package assignment.domain;

public class assignment {
	private Integer ClassID; 
	private Integer AssignmentID; 
	private String Title;
	private String Description; 
	
	public void setClassID(Integer id) { this.ClassID = id;}
	public void setAssignmentID(Integer id) { this.AssignmentID = id;}
	public void setTitle(String title) { this.Title = title;}
	public void setDescription(String description) { this.Description = description;}
	
	public Integer getClassID() {return this.ClassID;}
	public Integer getAssignmentID() { return this.AssignmentID;} 
	public String getTitle() { return this.Title;}
	public String getDescription() { return this.Description; } 
}
