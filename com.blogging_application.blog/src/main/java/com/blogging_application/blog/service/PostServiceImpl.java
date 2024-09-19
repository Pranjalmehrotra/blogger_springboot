package com.blogging_application.blog.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.blogging.application.blog.model.PaginationResponse;
import com.blogging.application.blog.model.PostModel;
import com.blogging_application.blog.entity.CategoryEntity;
import com.blogging_application.blog.entity.PostEntity;
import com.blogging_application.blog.entity.UserEntity;
import com.blogging_application.blog.exceptions.ResourceNotFoundException;
import com.blogging_application.blog.repository.CategoryRepository;
import com.blogging_application.blog.repository.PostRepository;
import com.blogging_application.blog.repository.UserRepository;

@Service
public class PostServiceImpl implements PostService {

	private PostRepository postRepository;
	private ModelMapper modelMapper;
	private UserRepository userRepository;
	private CategoryRepository categoryRepository;
	private CategoryEntity categoryEntity = new CategoryEntity();
	private UserEntity userEntity = new UserEntity();
	private PostEntity postEntity = new PostEntity();
	PaginationResponse paginationResponse = new PaginationResponse();

	public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper, UserRepository userRepository,
			CategoryRepository categoryRepository) {
		super();
		this.postRepository = postRepository;
		this.modelMapper = modelMapper;
		this.userRepository = userRepository;
		this.categoryRepository = categoryRepository;
	}

	public void createMappingBetweenModelAndEntity() {

		TypeMap<PostEntity, PostModel> typeMap = this.modelMapper.getTypeMap(PostEntity.class, PostModel.class);
		if (typeMap == null) {
			typeMap = this.modelMapper.createTypeMap(PostEntity.class, PostModel.class);
			typeMap.addMapping(PostEntity::getUserEntity, PostModel::setUserModel)
					.addMapping(PostEntity::getCategoryEntity, PostModel::setCategoryModel);

		}
	}

	@Override
	public PostModel createPost(PostModel postModel, Integer categoryId, Integer userId) {
		// categoryEntity = this.categoryRepository.findById(categoryId).get();
		categoryEntity = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("CategoryEntity", "categoryId", categoryId));

		// userEntity = this.userRepository.findById(userId).get();
		userEntity = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("UserEntity", "userId", userId));

		if (categoryEntity != null && userEntity != null) {

			System.out.println("Category enitty is ::" + categoryEntity.toString());
			System.out.println("User enitty is ::" + userEntity.toString());

			// Method1-->Method reference
			// Method chaining-->Calling multiple methods on the same object.
			this.modelMapper.createTypeMap(PostModel.class, PostEntity.class)
					.addMapping(PostModel::getUserModel, PostEntity::setUserEntity)
					.addMapping(PostModel::getCategoryModel, PostEntity::setCategoryEntity);

			// Method 2 ---->Via lambda expression

			/*
			 * this.modelMapper.createTypeMap(PostModel.class, PostEntity.class)
			 * .addMapping((PostModel)-> { return PostModel.getUserModel();
			 * },(PostEntity)->{ return PostEntity.setPostEntity();
			 * }).addMapping(PostModel:: getCategoryModel, PostEntity::setCategoryEntity);
			 * 
			 */

			postEntity = this.modelMapper.map(postModel, PostEntity.class);
			postEntity.setImageName("default.png");
			postEntity.setPostDate(new Date());
			postEntity.setCategoryEntity(categoryEntity);
			postEntity.setUserEntity(userEntity);
			postRepository.save(postEntity);
		}
		System.out.println("the post entity after setting in db is::" + postEntity.toString());
//		modelMapper.map(postEntity, PostModel.class);
		System.out.println("The post model data after insertion in the db is::" + PostModel.class.toString());

		// TODO Auto-generated method stub
		this.modelMapper.createTypeMap(PostEntity.class, PostModel.class)
				.addMapping(PostEntity::getUserEntity, PostModel::setUserModel)
				.addMapping(PostEntity::getCategoryEntity, PostModel::setCategoryModel);
		return modelMapper.map(postEntity, PostModel.class);
	}

	@Override
	public PostModel updatePost(PostModel postModel, Integer categoryId, Integer userId) {
		// TODO Auto-generated method stub
		categoryEntity = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("CategoryEntity", "categoryId", categoryId));

		// userEntity = this.userRepository.findById(userId).get();
		userEntity = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("UserEntity", "userId", userId));

		if (categoryEntity != null && userEntity != null) {
			System.out.println("Category enitty is ::" + categoryEntity.toString());
			System.out.println("User enitty is ::" + userEntity.toString());
			// postEntity = this.modelMapper.map(postModel, PostEntity.class);
			postEntity.setImageName("default.png");
			postEntity.setPostDate(new Date());
			postEntity.setCategoryEntity(categoryEntity);
			postEntity.setUserEntity(userEntity);
			postRepository.save(postEntity);

		}
		System.out.println("the post entity after setting in db is::" + postEntity.toString());
		modelMapper.map(postEntity, PostModel.class);
		System.out.println("The post model data after insertion in the db is::" + PostModel.class.toString());

		// TODO Auto-generated method stub
		return modelMapper.map(postEntity, PostModel.class);
	}

	@Override
	public void deletePostBycategoryIdAndUserId(Integer categoryId, Integer userId) {
		// TODO Auto-generated method stub
		userEntity = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("UserEntity", "userEntity", userId));

		categoryEntity = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("CategoryEntity", "categoryId", categoryId));

		if (categoryEntity != null && userEntity != null) {

			postRepository.deletePostByCategoryEntityAndUserEntity(categoryEntity, userEntity);

		}

	}

	@Override
	public List<PostModel> getAllPostByUserId(Integer userId) {
		// TODO Auto-generated method stub
		userEntity = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("UserEntity", "userEntity", userId));
		List<PostEntity> postEntityListByUserId = null;
		if (userEntity != null) {
			postEntityListByUserId = this.postRepository.findByUserEntity(userEntity);
		}
		createMappingBetweenModelAndEntity();
		List<PostModel> postModelListByUserId = postEntityListByUserId.stream().map((user) -> {
			return this.modelMapper.map(user, PostModel.class);
		}).collect(Collectors.toList());
		return postModelListByUserId;
	}

	@Override
	public List<PostModel> getAllPostByCategoryId(Integer categoryId) {
		// TODO Auto-generated method stub
		categoryEntity = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("CategoryEntity", "categoryid", categoryId));
		List<PostEntity> postEntityListByCategory = null;
		if (categoryEntity != null) {
			postEntityListByCategory = this.postRepository.findByCategoryEntity(categoryEntity);
		}
		createMappingBetweenModelAndEntity();
		List<PostModel> postModelListByCategory = postEntityListByCategory.stream().map((post) -> {
			return this.modelMapper.map(post, PostModel.class);
		}).collect(Collectors.toList());

		return postModelListByCategory;

	}

	// Normal-->getAllPost without Pagination
	@Override
	public List<PostModel> getAllPost() {
		List<PostEntity> getAllPosts = postRepository.findAll();
		createMappingBetweenModelAndEntity();
		List<PostModel> getAllPostModel = getAllPosts.stream().map((post) -> {
			return this.modelMapper.map(post, PostModel.class);
		}).collect(Collectors.toList());
		// TODO Auto-generated method stub
		return getAllPostModel;
	}

	// PAGINATION CONCEPTS---->IMPLEMENTING THE PAGINATION CONCEPTS
	@Override
	public PaginationResponse getAllPostWithPagination(Integer pageNumber, Integer pageSize, String sortBy,
			String sortDirection) {
		// TODO Auto-generated method stub
		Sort sort = null;
		if (sortDirection.equalsIgnoreCase("asc")) {
			sort = Sort.by(sortBy).ascending();
		} else {
			sort = Sort.by(sortBy).descending();
		}

		Pageable paginationPost = PageRequest.of(pageNumber, pageSize, sort);
		Page<PostEntity> postEntityPagination = this.postRepository.findAll(paginationPost);

		List<PostEntity> postPaginationEntityList = postEntityPagination.getContent();

		createMappingBetweenModelAndEntity();

		List<PostModel> paginationModelList = postPaginationEntityList.stream().map((post) -> {
			return this.modelMapper.map(post, PostModel.class);
		}).collect(Collectors.toList());
		paginationResponse.setPostModelList(paginationModelList);
		paginationResponse.setPageNumber(postEntityPagination.getNumber());
		paginationResponse.setPageSize(postEntityPagination.getSize());
		paginationResponse.setTotalElements(postEntityPagination.getTotalElements());
		paginationResponse.setTotalPages(postEntityPagination.getTotalPages());
		paginationResponse.setLastPage(postEntityPagination.isLast());

		return paginationResponse;
	}

	/*
	 * private PostModel entityToModel(PostEntity postEntity) { //UserModel
	 * PostModel postModel = new PostModel(); System.out.println("UserEntity is::"
	 * +userEntity.toString()); //userEntity.setUserid(userModel.getUserId());
	 * postModel.setCategoryModel(postEntity.get);
	 * 
	 * 
	 * return userModel;
	 * 
	 * }
	 */

}
