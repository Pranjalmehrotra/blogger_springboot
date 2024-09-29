package com.blogging.application.blog.model;

public class CommentModel {

	private Integer commentId;
	private PostModel postModel;
	private UserModel userModel;
	private String commentDescription;

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public PostModel getPostModel() {
		return postModel;
	}

	public void setPostModel(PostModel postModel) {
		this.postModel = postModel;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public String getCommentDescription() {
		return commentDescription;
	}

	public void setCommentDescription(String commentDescription) {
		this.commentDescription = commentDescription;
	}

	public CommentModel(Integer commentId, PostModel postModel, UserModel userModel, String commentDescription) {
		super();
		this.commentId = commentId;
		this.postModel = postModel;
		this.userModel = userModel;
		this.commentDescription = commentDescription;
	}

	@Override
	public String toString() {
		return "CommentModel [commentId=" + commentId + ", postModel=" + postModel + ", userModel=" + userModel
				+ ", commentDescription=" + commentDescription + "]";
	}

}
