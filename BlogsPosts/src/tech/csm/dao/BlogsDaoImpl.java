package tech.csm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tech.csm.entity.Blogs;
import tech.csm.util.DbUtil;



public class BlogsDaoImpl implements BlogsDao {
	
	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;


	@Override
	public List<Blogs> getAllBlogs() {
		List<Blogs> blogs=null;
		
		try {
			con=DbUtil.getMyConnection();
			ps=con.prepareStatement("select * from blogs");
			rs=ps.executeQuery();
			
			if(rs.next()) {
				blogs=new ArrayList<>();
				
				do {
					Blogs b=new Blogs();
					b.setBlogId(rs.getInt(1));
					b.setBlogTitle(rs.getString(2));
					b.setAuthorName(rs.getString(3));
					b.setCreatedOn(rs.getDate(4));
					blogs.add(b);
					
				}
				while(rs.next());
			}
			ps.close();
			rs.close();
//			con.close();
		}
		catch(SQLException e) {
           e.printStackTrace();
		}
		return blogs;
	}


	@Override
	public Blogs getBlogById(int id) {
		
		Blogs b=null;
		try {
		
			con=DbUtil.getMyConnection();
			ps=con.prepareStatement("select * from blogs where blog_id=? ");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				b=new Blogs();
				b.setBlogId(rs.getInt(1));;
				b.setBlogTitle(rs.getString(2));
				b.setAuthorName(rs.getString(3));
				b.setCreatedOn(rs.getDate(4));;
			}
			rs.close();
			ps.close();
		}catch(SQLException sq) {
			sq.printStackTrace();
		}
		
			
		
		return b;
	}

	

}
