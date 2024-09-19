package com.blogging.application.blog.model;

import java.util.Date;

public class PostModel {

	private String postTitle;
	
	private Integer postId;

	

	private String postContent;

	private String imageName;
	
	private CategoryModel categoryModel;
	
	private UserModel userModel;
	
	private Date postDate;
	
	

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date addedDate) {
		this.postDate = addedDate;
	}

	public PostModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	@Override
	public String toString() {
		return "PostModel [postTitle=" + postTitle + ", postContent=" + postContent + ", imageName=" + imageName
				+ ", categoryModel=" + categoryModel + ", userModel=" + userModel + "]";
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public CategoryModel getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(CategoryModel categoryModel) {
		this.categoryModel = categoryModel;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	
	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public PostModel(String postTitle, String postContent, String imageName, CategoryModel categoryModel,
			UserModel userModel,Integer postId) {
		super();
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.imageName = imageName;
		this.categoryModel = categoryModel;
		this.userModel = userModel;
		this.postId = postId;
	}

	
}
