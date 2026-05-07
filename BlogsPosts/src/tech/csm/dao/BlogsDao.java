package tech.csm.dao;

import java.util.List;

import tech.csm.entity.Blogs;

public interface BlogsDao {


	List<Blogs> getAllBlogs();

	Blogs getBlogById(int id);

}
