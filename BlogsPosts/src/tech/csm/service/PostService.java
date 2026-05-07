package tech.csm.service;

import java.util.List;

import tech.csm.entity.Posts;

public interface PostService {


	String addPost(Posts posts);

	List<Posts> getAllPosts();

	String deletePost(int id);

	Posts getPostById(int postId);

}
