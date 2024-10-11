package com.blogging_application.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blogging.application.blog.model.CommentModel;

@Service
public class CommentServiceImpl implements CommentService {

	@Override
	public CommentModel createComment(CommentModel commentModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentModel updateComment(CommentModel commentModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCommentByUserid(Integer userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCommentByPostId(Integer postId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCommentByCommentId(Integer commentId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CommentModel> getCommentsByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentModel> getCommentsByPostId(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentModel> getCommentByCommentId(Integer commentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
