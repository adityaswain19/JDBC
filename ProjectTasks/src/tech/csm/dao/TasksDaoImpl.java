package tech.csm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tech.csm.entity.Projects;
import tech.csm.entity.Tasks;
import tech.csm.util.DbUtil;

public class TasksDaoImpl implements TasksDao {

	static Connection con=null;
	static PreparedStatement ps=null,ps1=null,ps2=null;
	static ResultSet rs=null;
	

	@Override
	public String addTask(Tasks tasks,Integer projectId) {
		int rc=0,rc1=0;
		
		try {
			
			con=DbUtil.getMyConnection();
			ps=con.prepareStatement("insert into tasks (task_name,hours_taken,project_id) values (?,?,?)");
			ps.setString(1, tasks.getTaskName());
			ps.setInt(2, tasks.getHoursTaken());
			ps.setInt(3, projectId);
			rc=ps.executeUpdate();
			ps1=con.prepareStatement("Update projects set total_hours=(select sum(hours_taken) from tasks where project_id=?) where project_id=?");
			ps1.setInt(1, projectId);
			ps1.setInt(2, projectId);

			rc1=ps1.executeUpdate();
		}
		catch (SQLException e) {

			e.printStackTrace();
		}
		if(rc==1) {
			return "Tasks added succesfully";
					}
		else {
			return "Tasks not added";
		}
	}


	@Override
	public List<Tasks> getAllTask() {
		
		List<Tasks> l=null;
		
         try {
			
			con=DbUtil.getMyConnection();
			ps=con.prepareStatement("select "
					+ "t.task_id,t.task_name,t.hours_taken,p.project_id,p.project_name ,total_hours "
					+ " from tasks t join projects p using (project_id)");
			rs=ps.executeQuery();
			if(rs.next()) {
				l=new ArrayList<>();
				do {
					
					Tasks task=new Tasks();
					task.setTaskId(rs.getInt(1));
					task.setTaskName(rs.getString(2));
					task.setHoursTaken(rs.getInt(3));
					
					Projects p=new Projects();
					p.setProjectId(rs.getInt(4));
					p.setProjectName(rs.getString(5));
					p.setTotalHours(rs.getInt(6));
					
					task.setProjects(p);
					
					l.add(task);
				}
				while(rs.next());
			}
					}
		catch (SQLException e) {

			e.printStackTrace();
		}

		
		return l;
	}


	@Override
	public String changeTasks(int id, String newTask, int hours) {
		
		int rc=0,rc1=0;
		
		try {
			
			con=DbUtil.getMyConnection();
			ps=con.prepareStatement("update tasks set task_name=? ,hours_taken=? where task_id=?");
			ps.setString(1, newTask);
			ps.setInt(2, hours);
			ps.setInt(3,id);
			rc=ps.executeUpdate();
			
			ps2=con.prepareStatement("select project_id from tasks where task_id=?");
			ps2.setInt(1, id);
			rs=ps2.executeQuery();
			int pId=0;
			if(rs.next()) {
				pId=rs.getInt(1);
	
			}
			
			
			ps1=con.prepareStatement("update projects set total_hours=(select sum(hours_taken) from tasks where project_id=?)where project_id=?");
			
			ps1.setInt(1, pId);
			ps1.setInt(2, pId);

			rc1=ps1.executeUpdate();
		}
		catch (SQLException e) {

			e.printStackTrace();
		}
		if(rc==1) {
			return "Task updated";
			}
		else {
			return "Task not updated ";
		}
	
		
	}

}
