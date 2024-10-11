package com.blogging_application.blog.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "user_signup_tbl")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer userid;

	@Column(name = "user_name", length = 100)
	private String userName;

	/*
	 * @Column(name = "last_name") String lastName;
	 */

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "email_address")
	private String emailAddress;

	@Column(name = "terms_of_use_acceptance")
	private Integer termsOfUseAcceptance;

	@Column(name = "privacy_acceptance")
	private Integer privacyAcceptance;

	@Column(name = "hashed_password")
	@NotBlank(message = "password cannot be empty")
	private String password;

	@Column(name = "about")
	private String about;

	@Column(name = "created_at", nullable = false, updatable = false)
	@CreationTimestamp
	private Timestamp createdAt;

	@Column(name = "updated_at")
	@UpdateTimestamp
	private Timestamp updatedAt;

	// userEntity is the entity name defined in the post entity for mapping of the
	// users with the post

	@OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
	private List<PostEntity> listPostForOneUser = new ArrayList<>();

	/*
	 * @Column(name = "incorrectloginattempts") int incorrectLogin;
	 */

	/*
	 * @Column(name = "user_access") String userAccess;
	 */
	
	/*
	 * @OneToMany(mappedBy = "userEntity",cascade = CascadeType.ALL)
	 * List<CommentEntity>listCommentForOneUser = new ArrayList<>();
	 */
	
	@OneToMany(mappedBy = "userEntity",cascade = CascadeType.ALL)
	Set<CommentEntity>listCommentForOneUser = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(
			name = "user_roles_tbl",
			joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "role_id")
			)
	private Set<UserRoleEntity> roles = new HashSet<>();

	public List<PostEntity> getListPostForOneUser() {
		return listPostForOneUser;
	}

	public void setListPostForOneUser(List<PostEntity> listPostForOneUser) {
		this.listPostForOneUser = listPostForOneUser;
	}

	public Set<CommentEntity> getListCommentForOneUser() {
		return listCommentForOneUser;
	}

	public void setListCommentForOneUser(Set<CommentEntity> listCommentForOneUser) {
		this.listCommentForOneUser = listCommentForOneUser;
	}

	public Set<UserRoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRoleEntity> roles) {
		this.roles = roles;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Integer getTermsOfUseAcceptance() {
		return termsOfUseAcceptance;
	}

	public void setTermsOfUseAcceptance(Integer termsOfUseAcceptance) {
		this.termsOfUseAcceptance = termsOfUseAcceptance;
	}

	public Integer getPrivacyAcceptance() {
		return privacyAcceptance;
	}

	public void setPrivacyAcceptance(Integer privacyAcceptance) {
		this.privacyAcceptance = privacyAcceptance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(Integer userid, String userName, String mobileNumber, String emailAddress,
			Integer termsOfUseAcceptance, Integer privacyAcceptance, String password, String about, Timestamp createdAt,
			Timestamp updatedAt) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress;
		this.termsOfUseAcceptance = termsOfUseAcceptance;
		this.privacyAcceptance = privacyAcceptance;
		this.password = password;
		this.about = about;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "UserEntity [userid=" + userid + ", userName=" + userName + ", mobileNumber=" + mobileNumber
				+ ", emailAddress=" + emailAddress + ", termsOfUseAcceptance=" + termsOfUseAcceptance
				+ ", privacyAcceptance=" + privacyAcceptance + ", password=" + password + ", about=" + about
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
