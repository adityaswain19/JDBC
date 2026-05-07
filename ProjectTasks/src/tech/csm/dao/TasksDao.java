package tech.csm.dao;

import java.util.List;

import tech.csm.entity.Tasks;

public interface TasksDao {

	String addTask(Tasks tasks,Integer projectId);

	List<Tasks> getAllTask();

	String changeTasks(int id, String newTask, int hours);

}
