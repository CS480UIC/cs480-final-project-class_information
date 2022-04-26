package assignment.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import assignment.domain.assignment;

/**
 * DDL functions performed in database
 */
public class assignmentDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "class_information"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "cmdv.j.0"; //TODO change password

	public assignment findAssignment(Integer ClassID, Integer AssignmentID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		assignment entity1 = new assignment();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
		    String sql = "select * from assignment where ClassID = ? and  AssignmentID=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,ClassID);
		    preparestatement.setInt(2,AssignmentID);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer cUID = Integer.parseInt(resultSet.getString("ClassID"));
		    	Integer aUID = Integer.parseInt(resultSet.getString("AssignmentID"));
		    	if(ClassID.equals(cUID) && AssignmentID.equals(aUID)){		    		
		    		
		    		entity1.setClassID(Integer.parseInt(resultSet.getString("ClassID")));
		    		entity1.setAssignmentID(Integer.parseInt(resultSet.getString("AssignmentID")));
		    		entity1.setTitle(resultSet.getString("Title"));
		    		entity1.setDescription(resultSet.getString("Description"));
		    	
		    		return entity1;
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}	
	
	
	public void add(assignment form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
			String sql = "insert into assignment(ClassID, AssignmentID, Title, Description) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getClassID());
		    preparestatement.setInt(2,form.getAssignmentID());
		    preparestatement.setString(3,form.getTitle());
		    preparestatement.setString(4,form.getDescription());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	public void update(Integer ClassID, Integer AssignmentID, String Title, String Description) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
			String sql = "UPDATE assignment SET Title = ?, Description= ? where ClassID = ? and AssignmentID = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,Title);
		    preparestatement.setString(2, Description);
		    preparestatement.setInt(3, ClassID);
		    preparestatement.setInt(4, AssignmentID);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void delete(Integer ClassID, Integer AssignmentID ) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
			
			String sql = "delete from assignment where ClassID = ? and AssignmentID = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,ClassID);
		    preparestatement.setInt(2,AssignmentID);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
