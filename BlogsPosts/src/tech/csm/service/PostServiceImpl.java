package tech.csm.service;

import java.util.List;

import tech.csm.dao.postDao;
import tech.csm.entity.Posts;

public class PostServiceImpl implements PostService {

	private postDao postdao;
	
	public PostServiceImpl(postDao postDao) {
		this.postdao = postDao;
	}

	@Override
	public String addPost(Posts posts) {
		return postdao.addPost(posts);
	}

	@Override
	public List<Posts> getAllPosts() {

		return postdao.getAllPosts();
	}

	@Override
	public String deletePost(int id) {
		return postdao.deletePosts(id);
	}

	@Override
	public Posts getPostById(int postId) {
		return postdao.getPostById(postId);
	}

}
