package com.blogging_application.blog.service;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blogging_application.blog.model.CategoryModel;
import com.blogging_application.blog.entity.CategoryEntity;
import com.blogging_application.blog.exceptions.ResourceNotFoundException;
import com.blogging_application.blog.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepo;

	private ModelMapper modelMapper;

	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepo, ModelMapper modelMapper) {
		super();
		this.categoryRepo = categoryRepo;
		this.modelMapper = modelMapper;
	}

	CategoryEntity categoryEntity = new CategoryEntity();

	@Override
	public CategoryModel createCategory(CategoryModel categoryModel) {
		// TODO Auto-generated method stub
		categoryEntity = this.modelMapper.map(categoryModel, CategoryEntity.class);
		categoryEntity = categoryRepo.save(categoryEntity);
		return this.modelMapper.map(categoryEntity, CategoryModel.class);
	}

	@Override
	public CategoryModel updateCategory(CategoryModel categoryModel, Integer categoryId) {
		// TODO Auto-generated method stub
		if (categoryId != null) {
			categoryEntity = categoryRepo.findById(categoryId).get();

			if (categoryEntity != null) {
				categoryEntity.setCategoryDescription(categoryModel.getCategoryDescription());
				categoryEntity.setCategoryTitle(categoryModel.getCategoryTitle());
				categoryRepo.save(categoryEntity);
				return this.modelMapper.map(categoryEntity, CategoryModel.class);
			} else {

				categoryModel.setCategoryTitle("Category Title Not found");
				categoryModel.setCategoryId(null);
				categoryModel.setCategoryDescription("CategoryDescription Not found");
			}

		} else {
			categoryModel.setCategoryTitle("Invalid Category Title");
			categoryModel.setCategoryId(null);
			categoryModel.setCategoryDescription("Invalid CategoryDescription");
		}

		return categoryModel;
		// return new ResourceNotFoundException("UserModel","User id",userId);
	}

	@Override
	public CategoryModel getCategoryById(Integer categoryId) {
		// TODO Auto-generated method stub
		CategoryModel categoryModel = new CategoryModel();
		if (categoryId != null) {
			categoryEntity = categoryRepo.findById(categoryId).get();

			if (categoryEntity != null) {
				return this.modelMapper.map(categoryEntity, CategoryModel.class);
			} else {
				categoryModel.setCategoryTitle("Category Title Not found");
				categoryModel.setCategoryId(null);
				categoryModel.setCategoryDescription("CategoryDescription Not found");
			}

		} else {
			categoryModel.setCategoryTitle("Invalid Category Title");
			categoryModel.setCategoryId(null);
			categoryModel.setCategoryDescription("Invalid CategoryDescription");
		}

		return categoryModel;
	}

	@Override
	public void deleteCategoryById(Integer categoryId) {
		// TODO Auto-generated method stub
		categoryEntity = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category Model", "Category id", categoryId));
		this.categoryRepo.delete(categoryEntity);

	}

	@Override
	public List<CategoryModel> getAllCategoryData() {
		// TODO Auto-generated method stub
		List<CategoryEntity> categoryEntityList = this.categoryRepo.findAll();
		List<CategoryModel> categoryModelList = categoryEntityList.stream()
				.map(user -> this.modelMapper.map(user, CategoryModel.class)).collect(Collectors.toList());
		// TODO Auto-generated method stub
		return categoryModelList;
	}

}
