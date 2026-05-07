package tech.csm.service;

import java.util.List;

import tech.csm.dao.BlogsDao;
import tech.csm.entity.Blogs;

public class BlogsServiceImpl implements BlogsService {

	private BlogsDao blogsDao;
	
	public BlogsServiceImpl(BlogsDao blogsDao) {
		this.blogsDao = blogsDao;
	}



	@Override
	public List<Blogs> getAllBlogs() {
		return blogsDao.getAllBlogs();
	}



	@Override
	public Blogs getBlogById(int id) {
		return blogsDao.getBlogById(id);
	}

}
