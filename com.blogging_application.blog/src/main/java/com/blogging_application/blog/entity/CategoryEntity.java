package com.blogging_application.blog.entity;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Component
@Entity
@Table(name = "category_tbl")
public class CategoryEntity {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Integer categoryId;
	
	
	@Column(name = "category_title")
	private String categoryTitle;
	
	@Override
	public String toString() {
		return "CategoryEntity [categoryId=" + categoryId + ", categoryTitle=" + categoryTitle
				+ ", categoryDescription=" + categoryDescription + ", listPostForOneCategory=" + listPostForOneCategory
				+ "]";
	}



	@Column(name = "category_description")
	private String categoryDescription;
	
	//categoryEntity is the entity name defined in the post entity for mapping of the category with the post
	@OneToMany(mappedBy = "categoryEntity",cascade = CascadeType.ALL)
	private List<PostEntity>listPostForOneCategory = new ArrayList<>();
	
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public List<PostEntity> getListPostForOneCategory() {
		return listPostForOneCategory;
	}

	public CategoryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setListPostForOneCategory(List<PostEntity> listPostForOneCategory) {
		this.listPostForOneCategory = listPostForOneCategory;
	}

	
	
	public CategoryEntity(Integer categoryId, String categoryTitle, String categoryDescription,
			List<PostEntity> listPostForOneCategory) {
		super();
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
		this.listPostForOneCategory = listPostForOneCategory;
	}

}
