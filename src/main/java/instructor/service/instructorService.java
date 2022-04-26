package instructor.service;


import instructor.dao.instructorDao;
import instructor.domain.instructor;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class instructorService {
	private instructorDao instructorDao = new instructorDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(instructor form) throws instructorException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		instructor entity1 = instructorDao.findByclassID(form.getClassID());
		if(entity1 != null) {
			throw new instructorException("This user has been registered!");
		}
		
//		if(entity1.getUID()!=null && entity1.getUID().equals(form.getUID())) throw new instructorException("This user name has been registered!");
		instructorDao.add(form);
	}
}
