package com.blogging_application.blog.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.blogging_application.blog.model.CategoryModel;
import com.blogging_application.blog.service.CategoryService;

import jakarta.validation.Valid;

@RestController
public class CatgeoryController {

	@Autowired
	CategoryService categoryService;

	// @RequestMapping(method = RequestMethod.POST, value =
	// "/insert-category-details")
	@PostMapping("/insert-category-details")
	public ResponseEntity<CategoryModel> insertCategoryDetails(@Valid @RequestBody CategoryModel categoryModel) {
		CategoryModel categoryModelInerted = this.categoryService.createCategory(categoryModel);
		return ResponseEntity.ok(categoryModelInerted);

	}

	@PutMapping("/update-category/{categoryId}")
	public ResponseEntity<CategoryModel> updateCategoryDetails(@Valid @RequestBody CategoryModel categoryModel,
			@PathVariable Integer categoryId) {
		CategoryModel categoryModelUpdated = this.categoryService.updateCategory(categoryModel, categoryId);
		return ResponseEntity.ok(categoryModelUpdated);

	}

	@GetMapping("/get-all-categories")
	public ResponseEntity<List<CategoryModel>> getAllCategories() {
		List<CategoryModel> categoryModelList = this.categoryService.getAllCategoryData();
		return ResponseEntity.ok(categoryModelList);
	}

	@DeleteMapping("/delete-category/{categoryId}")
	public ResponseEntity<?> deleteCategory(@PathVariable Integer categoryId) {
		this.categoryService.deleteCategoryById(categoryId);
		return ResponseEntity.ok(null);

	}

	@GetMapping("/get-single-category/{categoryId}")
	public ResponseEntity<CategoryModel> getSingleCategory(@PathVariable Integer categoryId) {
		CategoryModel singleCategory = this.categoryService.getCategoryById(categoryId);
		return ResponseEntity.ok(singleCategory);

	}

}
