package com.blogging_application.blog.controller;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.blogging_application.blog.model.BlogApiResponse;
import com.blogging_application.blog.model.PaginationResponse;
import com.blogging_application.blog.model.PostModel;
import com.blogging_application.blog.service.PostService;

@RestController
public class PostController {

	private PostService postService;

	public PostController(PostService postService) {
		super();
		this.postService = postService;
	}

	// @RequestMapping(value = "/insert-post-details",method = RequestMethod.POST)
	@PostMapping(value = "/insert-post-details/categoryId/{categoryId}/userId/{userId}")
	public ResponseEntity<PostModel> createPostDetails(@RequestBody PostModel postModel,
			@PathVariable Integer categoryId, @PathVariable Integer userId) {
		PostModel postModelCreated = this.postService.createPost(postModel, categoryId, userId);
		return ResponseEntity.ok(postModelCreated);

	}

	@PostMapping(value = "/update-post-details/categoryId/{categoryId}/userId/{userId}")
	public ResponseEntity<PostModel> updatePostDetails(@RequestBody PostModel postModel,
			@PathVariable Integer categoryId, @PathVariable Integer userId) {
		PostModel postModelCreated = this.postService.updatePost(postModel, categoryId, userId);
		return ResponseEntity.ok(postModelCreated);

	}

	@GetMapping(value = "/get-all-posts-users/userId/{userId}")
	public ResponseEntity<List<PostModel>> getAllPostDetailsByUserId(@PathVariable Integer userId) {
		List<PostModel> postModelListByUsers = this.postService.getAllPostByUserId(userId);
		return ResponseEntity.ok(postModelListByUsers);

	}

	@GetMapping(value = "/get-all-posts-category/categoryId/{categoryId}")
	public ResponseEntity<List<PostModel>> getAllPostDetailsCategoryId(@PathVariable Integer categoryId) {
		List<PostModel> postModelListByCategories = this.postService.getAllPostByCategoryId(categoryId);
		return ResponseEntity.ok(postModelListByCategories);

	}

	@GetMapping(value = "/get-all-posts")
	public ResponseEntity<List<PostModel>> getAllPosts() {
		List<PostModel> postModelList = this.postService.getAllPost();
		return ResponseEntity.ok(postModelList);
	}

	@GetMapping(value = "/get-all-posts-pagination")
	public ResponseEntity<PaginationResponse> getAllPostsWithPagination(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "2", required = false) Integer pageSize,
			@RequestParam(value = "sortBy",defaultValue = "postId",required = false) String sortBy,
			@RequestParam(value = "sortDirection", defaultValue = "desc",required = false)String sortDirection) {
		PaginationResponse paginationModelList = this.postService.getAllPostWithPagination(pageNumber, pageSize,sortBy,sortDirection);
		return ResponseEntity.ok(paginationModelList);
	}

	@DeleteMapping(value = "/delete-post/categoryId/{categoryId}/userId/{userId}")
	public ResponseEntity<?> deletePostByCategoryIdAndUserId(@PathVariable("categoryId") Integer categoryId,
			@PathVariable("userId") Integer userId) {
		this.postService.deletePostBycategoryIdAndUserId(categoryId, userId);
		return new ResponseEntity<BlogApiResponse<String>>(
				new BlogApiResponse<String>("Post Deleted Successfully", HttpStatus.OK.value(), "Delete Sucessfully"),
				HttpStatus.OK);
		// return ResponseEntity.ok(null);
	}
	
	@GetMapping(value = "/get-all-posts-keywords/searchWordByTitle/{searchWord}")
	public ResponseEntity<List<PostModel>>getAllPostWithKeywords(@PathVariable("searchWord") String searchWord){
		List<PostModel>postSearchedList = this.postService.searchPostByTitle(searchWord);
		return ResponseEntity.ok(postSearchedList);
		
	}

}
