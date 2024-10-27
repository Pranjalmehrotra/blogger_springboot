package com.blogging_application.blog.model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryModel {
	
	private Integer categoryId;
	
	@NotBlank(message = "category description cannot be empty")
	@Size(min = 4,max = 200,message = "category description cannot be less than 4 characters and more than 200 characters")
	private String categoryDescription;
	
	@NotBlank(message = "category title cannot be empty")
	@Size(min = 4,max = 200,message = "category title cannot be less than 4 characters and more than 100 characters")
	private String categoryTitle;
	
	
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	
	@Override
	public String toString() {
		return "CategoryModel [categoryId=" + categoryId + ", categoryDescription=" + categoryDescription
				+ ", categoryTitle=" + categoryTitle + "]";
	}
	public CategoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryModel(Integer categoryId, String categoryDescription, String categoryTitle) {
		super();
		this.categoryId = categoryId;
		this.categoryDescription = categoryDescription;
		this.categoryTitle = categoryTitle;
	}
	
	

}
