package tech.csm.service;

import java.util.List;

import tech.csm.dao.ProjectsDao;
import tech.csm.entity.Projects;

public class ProjectsServiceImpl implements ProjectsService {

	ProjectsDao projectsDao;
	
	
	public ProjectsServiceImpl(ProjectsDao projectsDao) {
		this.projectsDao = projectsDao;
	}


	@Override
	public List<Projects> getAllProjects() {
		return projectsDao.getAllProjects();
	}


	@Override
	public Projects getProjectById(int id) {

		return projectsDao.getProjectById(id);
	}


	@Override
	public List<Projects> showProjectDetails() {
		return projectsDao.showProjectDetails();
	}

}
