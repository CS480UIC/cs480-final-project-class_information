package grade.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import grade.domain.grade;

/**
 * DDL functions performed in database
 */
public class gradeDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "class_information"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "cmdv.j.0"; //TODO change password

	public grade findAssignment(Integer StudentUID, Integer AssignmentID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		grade entity1 = new grade();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
		    String sql = "select * from grade where StudentUID = ? and  AssignmentID=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,StudentUID);
		    preparestatement.setInt(2,AssignmentID);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer sUID = Integer.parseInt(resultSet.getString("StudentUID"));
		    	Integer aUID = Integer.parseInt(resultSet.getString("AssignmentID"));
		    	if(StudentUID.equals(sUID) && AssignmentID.equals(aUID)){		    		
		    		
		    		entity1.setStudentUID(Integer.parseInt(resultSet.getString("StudentUID")));
		    		entity1.setAssignmentID(Integer.parseInt(resultSet.getString("AssignmentID")));
		    		entity1.setTotalPoints(Integer.parseInt(resultSet.getString("TotalPoints")));
		    		entity1.setPointsEarned(Integer.parseInt(resultSet.getString("PointsEarned")));
		    	
		    		return entity1;
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}	
	
	
	public void add(grade form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
			String sql = "insert into grade(StudentUID, AssignmentID, TotalPoints, PointsEarned) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getStudentUID());
		    preparestatement.setInt(2,form.getAssignmentID());
		    preparestatement.setInt(3,form.getTotalPoints());
		    preparestatement.setInt(4,form.getPointsEarned());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	public void update(Integer StudentUID, Integer AssignmentID, Integer PointsEarned, Integer TotalPoints) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
			String sql = "UPDATE grade SET TotalPoints = ?, PointsEarned= ? where StudentUID = ? and AssignmentID = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,PointsEarned);
		    preparestatement.setInt(2, TotalPoints);
		    preparestatement.setInt(3, StudentUID);
		    preparestatement.setInt(4, AssignmentID);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void delete(Integer StudentUID, Integer AssignmentID ) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
			
			String sql = "delete from grade where StudentUID = ? and AssignmentID = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,StudentUID);
		    preparestatement.setInt(2,AssignmentID);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
