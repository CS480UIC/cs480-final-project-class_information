package Class.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Class.domain.Class;
import student.domain.Student;

/**
 * DDL functions performed in database
 */
public class ClassDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "class_information"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "cmdv.j.0"; //TODO change password

	public Class findByClassID(Integer ID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class entity1 = new Class();
		try {
			java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
		    String sql = "select * from class where ClassID=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,ID);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer UID = Integer.parseInt(resultSet.getString("ClassID"));
		    	if(UID.equals(ID)){		    		
		    		entity1.setClassID(Integer.parseInt(resultSet.getString("ClassID")));
		    		entity1.setClassName(resultSet.getString("ClassName"));
		    		entity1.setInstructorID(Integer.parseInt(resultSet.getString("InstructorID")));
		    		entity1.setSemester(resultSet.getString("Semester"));
		    		return entity1;
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}	
	
	
	public void add(Class form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
			String sql = "insert into class(ClassID, ClassName, InstructorID, Semester) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getClassID());
		    preparestatement.setString(2,form.getClassName());
		    preparestatement.setInt(3,form.getInstructorID());
		    preparestatement.setString(4,form.getSemester());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	public void update(Integer ClassID, String ClassName, Integer InstructorID, String Semester) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
			String sql = "UPDATE class SET ClassName = ?, InstructorID= ?, Semester= ? where ClassID = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,ClassName);
		    preparestatement.setInt(2, InstructorID);
		    preparestatement.setString(3, Semester);
		    preparestatement.setInt(4, ClassID);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void delete(Integer ClassID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
			
			String sql = "delete from Class where ClassID = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,ClassID);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> q3() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
			String sql = "SELECT ClassName FROM class\r\n"
					+ "WHERE semester = \"Fall 2021\"\r\n"
					+ "ORDER BY ClassID; ";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Class user = new Class();
				user.setClassName(resultSet.getString("ClassName"));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> q4() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
			String sql = "Select ClassID, count(*) FROM student as count WHERE ClassID IS NOT NULL GROUP BY ClassID;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Student user = new Student();
				user.setClassID(Integer.parseInt(resultSet.getString("ClassID")));
				user.setUID(resultSet.getInt(2));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
}
