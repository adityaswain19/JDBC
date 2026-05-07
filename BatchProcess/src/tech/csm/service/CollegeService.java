package tech.csm.service;

import java.util.List;

import tech.csm.entity.College;

public interface CollegeService {

	List<College> getAllCollege();

	College getCollegeById(Integer collegeId);
	
	String addCollege(College college);

	String removeCollege(Integer collegeId);

}
