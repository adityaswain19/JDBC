package tech.csm.entity;

public class Projects {

	private Integer projectId;
	private String projectName;
	private Integer totalHours;
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Integer getTotalHours() {
		return totalHours;
	}
	public void setTotalHours(Integer totalHours) {
		this.totalHours = totalHours;
	}
	@Override
	public String toString() {
		return "Projects [projectId=" + projectId + ", projectName=" + projectName + ", totalHours=" + totalHours + "]";
	}
	
	
}
