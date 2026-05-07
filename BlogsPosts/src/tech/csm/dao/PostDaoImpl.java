package tech.csm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tech.csm.entity.Blogs;
import tech.csm.entity.Posts;
import tech.csm.util.DbUtil;
import tech.csm.dao.*;

public class PostDaoImpl implements postDao {

	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;

	@Override
	public String addPost(Posts posts) {

		int rc=0;
		try {
			con = DbUtil.getMyConnection();

			ps = con.prepareStatement("insert into posts(post_id,content,created_on,blog_id) values(?,?,?,?)");
			ps.setInt(1, posts.getPostId());
			ps.setString(2, posts.getContent());
			ps.setDate(3, new java.sql.Date(posts.getCreatedOn().getTime()));
			ps.setInt(4, posts.getBlogs().getBlogId());
			rc = ps.executeUpdate();
			
			ps.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}
		if(rc==1)
			return  "1 post added";
		else
			return "Admission not successful!!";
		
	
	}

	@Override
	public List<Posts> getAllPosts() {

		List<Posts> l=null;
		
		try {
			
		
		con=DbUtil.getMyConnection();
		ps=con.prepareStatement("select p.post_id,p.content,p.created_on, b.blog_id,b.blog_title,b.author_name from posts p join blogs b on p.blog_id=b.blog_id;");
		rs=ps.executeQuery();
		
		if(rs.next()) {
			l=new ArrayList<>();
			do {
				
			
			Posts post=new Posts();
			post.setPostId(rs.getInt(1));
			post.setContent(rs.getString(2));
			post.setCreatedOn(rs.getDate(3));
			
			Blogs blogs=new Blogs();
			blogs.setBlogId(rs.getInt(4));
			blogs.setBlogTitle(rs.getString(5));
			blogs.setAuthorName(rs.getString(6));			

			post.setBlogs(blogs);
			l.add(post);
			
		}while(rs.next());
		}
		ps.close();
		rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return l;
	

}

	@Override
	public Posts getPostById(int postId) {


		Posts posts=null;
		
		try {
			con=DbUtil.getMyConnection();
			ps=con.prepareStatement("Select p.post_id,p.content,p.created_on,p.blog_id,b.blog_title,b.author_name from posts p join blogs b on p.blog_id=b.blog_id");
			rs=ps.executeQuery();
			
			if(rs.next()) {
				
			    posts=new Posts();
				posts.setPostId(rs.getInt(1));
				posts.setContent(rs.getString(2));
				posts.setCreatedOn(rs.getDate(3));

				Blogs blogs=new Blogs();
				blogs.setBlogId(rs.getInt(4));
				blogs.setBlogTitle(rs.getString(5));
				blogs.setAuthorName(rs.getString(6));	
				posts.setBlogs(blogs);
			}
		}
		catch (SQLException e) {

			e.printStackTrace();
		}
		return posts;
	}

	@Override
	public String deletePosts(int id) {

		int rc=0;
		try {
			con=DbUtil.getMyConnection();
			ps=con.prepareStatement("Delete from posts where post_id=?");
			ps.setInt(1, id);
			rc=ps.executeUpdate();
			
			
		}
		catch (SQLException e) {

			e.printStackTrace();
		}
		if(rc==1) {
			return "Post got deleted";
			
		}
		else {
			return "Posts not deleted";
		}
	}
}