package content.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import content.domain.content;
import grade.domain.grade;

/**
 * DDL functions performed in database
 */
public class contentDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "class_information"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "cmdv.j.0"; //TODO change password

	public content findAssignment(Integer FileID, Integer ClassID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		content entity1 = new content();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
		    String sql = "select * from course_content where FileID = ? and  ClassID=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,FileID);
		    preparestatement.setInt(2,ClassID);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer fUID = Integer.parseInt(resultSet.getString("FileID"));
		    	Integer cUID = Integer.parseInt(resultSet.getString("ClassID"));
		    	if(FileID.equals(fUID) && ClassID.equals(cUID)){		    		
		    		
		    		entity1.setFileID(Integer.parseInt(resultSet.getString("FileID")));
		    		entity1.setFile(resultSet.getString("File"));
		    		entity1.setDescription(resultSet.getString("Description"));
		    		entity1.setLectureDate(resultSet.getString("LectureDate"));
		    		entity1.setLectureID(Integer.parseInt(resultSet.getString("LectureID")));
		    		entity1.setContentType(resultSet.getString("ContentType"));
		    		entity1.setClassID(Integer.parseInt(resultSet.getString("ClassID")));

		    	
		    		return entity1;
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}	
	
	
	public void add(content form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
			String sql = "insert into course_content(FileID, File, Description, LectureDate, LectureID, ContentType, ClassID) values(?,?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getFileID());
		    preparestatement.setString(2,form.getFile());
		    preparestatement.setString(3,form.getDescription());
		    preparestatement.setString(4,form.getLectureDate());
		    preparestatement.setInt(5,form.getLectureID());
		    preparestatement.setString(6,form.getContentType());
		    preparestatement.setInt(7,form.getClassID());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	public void update(Integer FileID, String File, String Description,
			String LectureDate,Integer LectureID, String ContentType,
			Integer ClassID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
			String sql = "UPDATE course_content SET File = ?, Description= ?, LectureDate= ?, LectureID= ?, ContentType= ? where FileID = ? and ClassID = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,File);
		    preparestatement.setString(2,Description);
		    preparestatement.setString(3,LectureDate);
		    preparestatement.setInt(4,LectureID);
		    preparestatement.setString(5,ContentType);
		    preparestatement.setInt(6,FileID);
		    preparestatement.setInt(7,ClassID);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void delete(Integer FileID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
			
			String sql = "delete from course_content where FileID = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,FileID);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
