package tech.csm.service;

import java.util.List;

import tech.csm.entity.Blogs;

public interface BlogsService {


	List<Blogs> getAllBlogs();

	Blogs getBlogById(int id);

}
