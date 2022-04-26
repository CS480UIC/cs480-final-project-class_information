package assignment.service;


import Class.dao.ClassDao;
import Class.domain.Class;
import assignment.dao.assignmentDao;
import assignment.domain.assignment;


public class assignmentService {
	private assignmentDao entity1Dao = new assignmentDao();

	public void create(assignment form) throws assignmentException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		assignment entity1 = entity1Dao.findAssignment(form.getClassID(), form.getAssignmentID());
		if(entity1 != null) throw new assignmentException("This class has been registered!");
		entity1Dao.add(form);
	}
}
