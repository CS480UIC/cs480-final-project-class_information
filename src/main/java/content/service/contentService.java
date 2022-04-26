package content.service;


import content.dao.contentDao;
import content.domain.content;
import grade.dao.gradeDao;
import grade.domain.grade;


public class contentService {
	private contentDao entity1Dao = new contentDao();

	public void create(content form) throws contentException,ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		content entity1 = entity1Dao.findAssignment(form.getFileID(), form.getClassID());
		if(entity1 != null) throw new contentException("This grade has been registered!");
		entity1Dao.add(form);
	}
}
