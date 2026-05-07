package tech.csm.dao;

import java.util.List;

import tech.csm.entity.Posts;

public interface postDao {

	public String addPost(Posts posts);

    List<Posts> getAllPosts();

	 Posts getPostById(int postId);

	  String deletePosts(int id);
}

