package com.blogging_application.blog.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comment_tbl")
public class CommentEntity {

	@Column(name = "comment_id")
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer commentId;

	@ManyToOne()
	@JoinColumn(name = "post_id")
	private PostEntity postEntity;

	@ManyToOne()
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;

	@Column(name = "comment_description")
	private String commentDescription;

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public PostEntity getPostEntity() {
		return postEntity;
	}

	public void setPostEntity(PostEntity postEntity) {
		this.postEntity = postEntity;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public String getCommentDescription() {
		return commentDescription;
	}

	public void setCommentDescription(String commentDescription) {
		this.commentDescription = commentDescription;
	}

	public CommentEntity(Integer commentId, PostEntity postEntity, UserEntity userEntity, String commentDescription) {
		super();
		this.commentId = commentId;
		this.postEntity = postEntity;
		this.userEntity = userEntity;
		this.commentDescription = commentDescription;
	}

}
