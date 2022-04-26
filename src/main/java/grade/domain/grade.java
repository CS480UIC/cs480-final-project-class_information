package grade.domain;

public class grade {

	private Integer StudentUID;
	private Integer  AssignmentID ;
	private Integer TotalPoints;
	private Integer PointsEarned;
	
	public Integer getStudentUID() {
		return this.StudentUID;
	}
	
	public Integer getAssignmentID() {
		return this.AssignmentID;
	}
	
	public Integer getTotalPoints() {
		return this.TotalPoints;
	}
	
	public Integer getPointsEarned() {
		return this.PointsEarned;
	}
	

	public void setStudentUID(Integer uid) {
		this.StudentUID = uid;
	}
	
	public void setAssignmentID(Integer id) {
		this.AssignmentID = id;
	}
	
	public void setTotalPoints(Integer pts) {
		this.TotalPoints = pts;
	}
	
	public void setPointsEarned(Integer pts) {
		this.PointsEarned = pts;
	}
}
