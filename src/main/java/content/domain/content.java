package content.domain;

public class content {
	/*
	 * Correspond to the class table
	 */
	private Integer FileID;
	private String File;
	private String Description;
	private String LectureDate;
	private Integer LectureID;
	private String ContentType;
	private Integer ClassID;

	public void setFileID(Integer FileID) {
		this.FileID = FileID;
	}

	public Integer getFileID() {
		return this.FileID;
	}
	
	public void setFile(String File) {
		this.File = File;
	}

	public String getFile() {
		return this.File;
	}
	
	public void setDescription(String Description) {
		this.Description = Description;
	}

	public String getDescription() {
		return this.Description;
	}
	
	public void setLectureDate(String LectureDate) {
		this.LectureDate = LectureDate;
	}
	
	public String getLectureDate() {
		return this.LectureDate;
	}
	
	public void setLectureID(Integer LectureID) {
		this.LectureID = LectureID;
	}

	public Integer getLectureID() {
		return this.LectureID;
	}
	
	public void setContentType(String ContentType) {
		this.ContentType = ContentType;
	}

	public String getContentType() {
		return this.ContentType;
	}
	
	public void setClassID(Integer ClassID) {
		this.ClassID = ClassID;
	}

	public Integer getClassID() {
		return this.ClassID;
	}
	
}
