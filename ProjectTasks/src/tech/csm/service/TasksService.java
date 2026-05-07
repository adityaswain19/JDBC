package tech.csm.service;

import java.util.List;

import tech.csm.entity.Tasks;

public interface TasksService {

	String addTask(Tasks tasks, Integer projectId);

	List<Tasks> getAllTask();

	String changeTasks(int id, String newTask, int hours);


	}
