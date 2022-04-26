package Class.service;


import Class.dao.ClassDao;
import Class.domain.Class;


public class ClassService {
	private ClassDao entity1Dao = new ClassDao();

	public void create(Class form) throws ClassException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Class entity1 = entity1Dao.findByClassID(form.getClassID());
		if(entity1 != null) throw new ClassException("This class has been registered!");
		entity1Dao.add(form);
	}
}
