package instructor.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import instructor.domain.instructor;
import student.domain.Student;

/**
 * DDL functions performed in database
 */
public class instructorDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "class_information"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "cmdv.j.0"; //TODO change password

	public instructor findByclassID(Integer ClassID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		instructor entity1 = new instructor();
		try {
			java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
		    String sql = "select * from instructor where ClassID=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,ClassID);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer UID = Integer.parseInt(resultSet.getString("ClassID"));
		    	if(UID.equals(ClassID)) {
		    		entity1.setClassID(Integer.parseInt(resultSet.getString("ClassID")));
		    		entity1.setUid(Integer.parseInt(resultSet.getString("UID")));
		    				
		    		return entity1;
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}	
	
	
	public void add(instructor form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
			String sql = "insert into instructor(UID, ClassID) values(?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getUid());
		    preparestatement.setInt(2,form.getClassID());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	public void update(Integer UID, Integer classID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
			String sql = "UPDATE instructor SET ClassID = ? WHERE UID = ? ;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(2,UID);
		    preparestatement.setInt(1, classID);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void delete(Integer UID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
			
			String sql = "delete from instructor where UID = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,UID);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> q2() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
			String sql = "SELECT UID FROM instructor \r\n"
					+ "ORDER by UID; ";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				instructor user = new instructor();
				user.setUid(Integer.parseInt(resultSet.getString("UID")));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> q5() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
			String sql = "SELECT UID FROM instructor \r\n"
					+ "ORDER by UID; ";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				instructor user = new instructor();
				user.setUid(Integer.parseInt(resultSet.getString("UID")));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
}
