package tech.csm.entity;

import java.io.Serializable;
import java.util.Date;

public class Posts implements Serializable {

	private Integer postId;
	private String content;
	private Date createdOn;
	private Blogs blogs;
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Blogs getBlogs() {
		return blogs;
	}
	public void setBlogs(Blogs blogs) {
		this.blogs = blogs;
	}
	@Override
	public String toString() {
		return "Posts [postId=" + postId + ", content=" + content + ", createdOn=" + createdOn + ", blogs=" + blogs
				+ "]";
	}
	
	
}
