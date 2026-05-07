package tech.csm.entity;

public class Tasks {

	private Integer taskId;
	private String taskName;
	private Integer hoursTaken;
	private Projects projects;
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Integer getHoursTaken() {
		return hoursTaken;
	}
	public void setHoursTaken(Integer hoursTaken) {
		this.hoursTaken = hoursTaken;
	}
	public Projects getProjects() {
		return projects;
	}
	public void setProjects(Projects projects) {
		this.projects = projects;
	}
	@Override
	public String toString() {
		return "Tasks [taskId=" + taskId + ", taskName=" + taskName + ", hoursTaken=" + hoursTaken + ", projects="
				+ projects + "]";
	}
	
	
}
