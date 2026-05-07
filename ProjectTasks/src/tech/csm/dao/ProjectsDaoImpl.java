package tech.csm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tech.csm.entity.Projects;
import tech.csm.util.DbUtil;

public class ProjectsDaoImpl implements ProjectsDao {
	
	static Connection con=null;
	static PreparedStatement ps=null,ps2=null;
	static ResultSet rs=null;
	

	@Override
	public List<Projects> getAllProjects() {
		List<Projects> projects=null;
		
		try {
			con=DbUtil.getMyConnection();
			ps=con.prepareStatement("select * from projects");
			rs=ps.executeQuery();
			
			if(rs.next()) {
				projects=new ArrayList<>();
				
				do {
					Projects p=new Projects();
					p.setProjectId(rs.getInt(1));
					p.setProjectName(rs.getString(2));
					p.setTotalHours(rs.getInt(3));
				
					projects.add(p);
				}
				while(rs.next());
			}
		}
		catch (SQLException e) {

			e.printStackTrace();
		}
		
		return projects;
	}


	@Override
	public Projects getProjectById(int id) {

		Projects p=null;
		try {
			con=DbUtil.getMyConnection();
			ps=con.prepareStatement("select * from projects where project_id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				
				do {
				    p=new Projects();
					p.setProjectId(rs.getInt(1));
					p.setProjectName(rs.getString(2));
					p.setTotalHours(rs.getInt(3));
				}
				while(rs.next());
			}
		}
		catch (SQLException e) {

			e.printStackTrace();
		}
		return p;
	}


	@Override
	public List<Projects> showProjectDetails() {

		int rc=0;
		
		try {
			con=DbUtil.getMyConnection();
			
			ps=con.prepareStatement("select p.project_id,count(*) from projects p join tasks t using(project_id) group by p.project_id");
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				
				do {

					int id=rs.getInt(1);
					int count=rs.getInt(2);
					
					ps2=con.prepareStatement("update projects set no_of_task=? where project_id=?");
					ps2.setInt(1, count);
					ps2.setInt(2,id);
					rc=ps2.executeUpdate();
					
				}
				while(rs.next());
			}
		}
		catch (SQLException e) {

			e.printStackTrace();
		}
		
		return getAllProjects();
	
		
	
	}

}
