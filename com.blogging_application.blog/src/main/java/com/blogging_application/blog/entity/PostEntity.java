package com.blogging_application.blog.entity;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_posts_tbl")
public class PostEntity {
	
	@Column(name = "post_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer postId;
	
	@Column(name = "post_title",length = 100, nullable =  false)
	private String postTitle;
	
	@Column(name = "post_content",length = 100000)
	private String postContent;
	
	@Override
	public String toString() {
		return "PostEntity [postId=" + postId + ", postTitle=" + postTitle + ", postContent=" + postContent
				+ ", imageName=" + imageName + ", postDate=" + postDate + ", categoryEntity=" + categoryEntity
				+ ", userEntity=" + userEntity + "]";
	}

	@Column(name = "post_image")
	private String imageName;
	
	@Column(name = "post_date")
	 private Date postDate;
	
	
	@ManyToOne()
	@JoinColumn(name = "category_id")
	//Name of this entity in the table would be category_id.
	private CategoryEntity categoryEntity;
	
	@ManyToOne()
	@JoinColumn(name = "user_id")
	//Name of this entity in the table would be user_id.
	private UserEntity userEntity;
	

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public PostEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostEntity(Integer postId, String postTitle, String postContent, String imageName, Date postDate,
			CategoryEntity categoryEntity, UserEntity userEntity) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.imageName = imageName;
		this.postDate = postDate;
		this.categoryEntity = categoryEntity;
		this.userEntity = userEntity;
	}



}
