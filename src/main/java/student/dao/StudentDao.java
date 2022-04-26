package student.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import student.domain.Student;

/**
 * DDL functions performed in database
 */
public class StudentDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "class_information"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "cmdv.j.0"; //TODO change password

	public Student findByID(Integer ID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Student entity1 = new Student();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
		    String sql = "select * from student where UID=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,ID);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer UID = Integer.parseInt(resultSet.getString("UID"));
		    	System.out.println(UID);
		    	if(UID.equals(ID)){
		    		System.out.println("A");
		    		entity1.setClassID(Integer.parseInt(resultSet.getString("ClassID")));
		    		System.out.println("B");
		    		entity1.setUID(Integer.parseInt(resultSet.getString("UID")));
		    		System.out.println("C");
		    		entity1.setEnrolled(resultSet.getString("enrolled"));		
		    		System.out.println("D");
		    		entity1.setDegreeType(resultSet.getString("DegreeType"));	
		    		System.out.println("E");
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}	
	
	/**
	 * insert Student
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Student form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
			System.out.println("Adding Student");
			String sql = "insert into student(ClassID, UID, enrolled, DegreeType) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getClassID());
		    preparestatement.setInt(2,form.getUID());
		    preparestatement.setString(3,form.getEnrolled());
		    preparestatement.setString(4,form.getDegreeType());
		    preparestatement.executeUpdate();
		    System.out.println("Student Added");
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void update(Student form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
			
			String sql = "UPDATE student SET ClassID = ?, enrolled= ?, DegreeType= ? where UID = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getClassID());
		    preparestatement.setInt(2,form.getUID());
		    preparestatement.setString(3,form.getEnrolled());
		    preparestatement.setString(4,form.getDegreeType());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param ID
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(Integer ID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class_information", MySQL_user, MySQL_password);
			
			String sql = "delete from student where UID = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,ID);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
