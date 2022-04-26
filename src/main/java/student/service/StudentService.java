package student.service;


import java.util.List;

import student.dao.StudentDao;
import student.domain.Student;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class StudentService {
	private StudentDao studentDao = new StudentDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Student form) throws StudentException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Student entity1 = studentDao.findByID(form.getUID());
		if(entity1 != null) {
			throw new StudentException("This user name has been registered!");
		}
		
//		if(entity1.getUID()!=null && entity1.getUID().equals(form.getUID())) throw new StudentException("This user name has been registered!");
		studentDao.add(form);
	}
	public List<Object> q1() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return studentDao.q1();
		
	}
}
