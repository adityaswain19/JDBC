package tech.csm.entity;

import java.io.Serializable;
import java.util.Date;

public class Blogs implements Serializable {

	private Integer blogId;
	private String blogTitle;
	private String authorName;
	private Date createdOn;
	public Integer getBlogId() {
		return blogId;
	}
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	@Override
	public String toString() {
		return "Blogs [blogId=" + blogId + ", blogTitle=" + blogTitle + ", authorName=" + authorName + ", createdOn="
				+ createdOn + "]";
	}
	
	
}
