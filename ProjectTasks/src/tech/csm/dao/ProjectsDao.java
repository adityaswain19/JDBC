package tech.csm.dao;

import java.util.List;

import tech.csm.entity.Projects;

public interface ProjectsDao {

	List<Projects> getAllProjects();

	Projects getProjectById(int id);

	List<Projects> showProjectDetails();

}
