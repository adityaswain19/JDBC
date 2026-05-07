package tech.csm.service;

import java.util.List;

import tech.csm.dao.CollegeDao;
import tech.csm.entity.College;

public class CollegeServiceImpl implements CollegeService {
	
	private CollegeDao collegeDao;
	public CollegeServiceImpl(CollegeDao collegeDao) {
		this.collegeDao=collegeDao;
	}

	@Override
	public List<College> getAllCollege() {
		return collegeDao.getAllCollege();
	}

	@Override
	public College getCollegeById(Integer collegeId) {
		return collegeDao.getCollegeById(collegeId);
	}

	@Override
	public String addCollege(College college) {
		college.setIsDeleted("NO");
		return collegeDao.addCollege(college);
	}

	@Override
	public String removeCollege(Integer collegeId) {
		return collegeDao.removeCollege(collegeId);
	}
	
	

}
