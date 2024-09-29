package com.blogging_application.blog.service;
import java.util.List;
import com.blogging.application.blog.model.PaginationResponse;
import com.blogging.application.blog.model.PostModel;

public interface PostService {

	PostModel createPost(PostModel postModel, Integer categoryId, Integer userId);

	PostModel updatePost(PostModel postModel, Integer categoryId, Integer userId);

	void deletePostBycategoryIdAndUserId(Integer categoryId, Integer userId);

	List<PostModel> getAllPostByUserId(Integer userId);

	List<PostModel> getAllPostByCategoryId(Integer categoryId);

	List<PostModel> getAllPost();

	PaginationResponse getAllPostWithPagination(Integer pageNumber, Integer pageSize,String sortBy,String sortDirection);
	
	List<PostModel>searchPostByTitle(String searchWord);
	

}
