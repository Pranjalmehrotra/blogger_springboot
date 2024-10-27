package com.blogging_application.blog.service;

import java.util.List;

import com.blogging_application.blog.model.CategoryModel;

public interface CategoryService {

	// create

	CategoryModel createCategory(CategoryModel categoryModel);

	// update

	CategoryModel updateCategory(CategoryModel categoryModel, Integer categoryId);

	// get

	CategoryModel getCategoryById(Integer categoryId);

	// delete

	void deleteCategoryById(Integer categoryId);

	// getAll
	List<CategoryModel> getAllCategoryData();
}
