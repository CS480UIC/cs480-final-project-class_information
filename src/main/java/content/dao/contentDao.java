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
		    String sql = "select * from content where FileID = ? and  ClassID=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,FileID);
		    preparestatement.setInt(2,ClassID);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer fUID = Integer.parseInt(resultSet.getString("FileID"));
		    	Integer cUID = Integer.parseInt(resultSet.getString("ClassID"));
		    	if(FileID.equals(fUID) && ClassID.equals(cUID)){		    		
		    		
		    		entity1.setFileID(Integer.parseInt(resultSet.getString("FileID")));
		    		entity1.setFile(resultSet.getString("FileID"));
		    		entity1.setDescription(resultSet.getString("FileID"));
		    		entity1.setLectureDate(resultSet.getString("FileID"));
		    		entity1.setLectureID(Integer.parseInt(resultSet.getString("FileID")));
		    		entity1.setContentType(resultSet.getString("FileID"));
		    		entity1.setClassID(Integer.parseInt(resultSet.getString("FileID")));

		    	
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
			String sql = "insert into content(FileID, File, Description, LectureDate, LectureID, ContentType, ClassID) values(?,?,?,?,?,?,?)";
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
			String LectureDate, String ContentType,
			Integer ClassID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
			String sql = "UPDATE content SET File = ?, Description= ?, LectureDate= ?, ContentType= ? where FileID = ? and ClassID = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,File);
		    preparestatement.setString(2,Description);
		    preparestatement.setString(3,LectureDate);
		    preparestatement.setString(4,ContentType);
		    preparestatement.setInt(5,FileID);
		    preparestatement.setInt(6,ClassID);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void delete(Integer LectureID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
			
			String sql = "delete from content where LectureID = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,LectureID);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
