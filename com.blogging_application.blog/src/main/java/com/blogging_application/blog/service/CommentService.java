package com.blogging_application.blog.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.blogging_application.blog.model.CommentModel;

public interface CommentService {
	
	public CommentModel createComment(@RequestBody CommentModel commentModel );
	
	public CommentModel updateComment(@RequestBody CommentModel commentModel);
	
	public void deleteCommentByUserid(Integer userId);
	
	public void deleteCommentByPostId(Integer postId);
	
	public void deleteCommentByCommentId(Integer commentId);
	
	public List<CommentModel> getCommentsByUserId(Integer userId);
	
	public List<CommentModel>getCommentsByPostId(Integer postId);
	
	public List<CommentModel>getCommentByCommentId(Integer commentId);
	
	

}
