package grade.service;


import grade.dao.gradeDao;
import grade.domain.grade;


public class gradeService {
	private gradeDao entity1Dao = new gradeDao();

	public void create(grade form) throws gradeException,ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		grade entity1 = entity1Dao.findAssignment(form.getStudentUID(),form.getAssignmentID());
		if(entity1 != null) throw new gradeException("This grade has been registered!");
		entity1Dao.add(form);
	}
}
