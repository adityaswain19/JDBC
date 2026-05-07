package tech.csm.service;

import java.util.List;

import tech.csm.dao.TasksDao;
import tech.csm.entity.Tasks;

public class TasksServiceImpl implements TasksService {

	TasksDao tasksDao;
	
	public TasksServiceImpl(TasksDao tasksDao) {
		this.tasksDao = tasksDao;
	}

	@Override
	public String addTask(Tasks tasks ,Integer projectId) {
		
		return tasksDao.addTask(tasks,projectId);
	}

	@Override
	public List<Tasks> getAllTask() {
		return tasksDao.getAllTask();
	}

	@Override
	public String changeTasks(int id, String newTask, int hours) {
		return tasksDao.changeTasks(id,newTask,hours);
	}

}
