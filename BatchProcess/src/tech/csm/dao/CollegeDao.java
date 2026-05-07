package tech.csm.dao;

import java.util.List;

import tech.csm.entity.College;

public interface CollegeDao {

	List<College> getAllCollege();

	College getCollegeById(Integer collegeId);

	String addCollege(College college);

	String removeCollege(Integer collegeId);

}
