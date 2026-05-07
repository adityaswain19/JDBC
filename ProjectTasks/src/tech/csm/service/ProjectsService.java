package tech.csm.service;

import java.util.List;

import tech.csm.entity.Projects;

public interface ProjectsService {

	List<Projects> getAllProjects();

	Projects getProjectById(int id);

	List<Projects> showProjectDetails();

}
