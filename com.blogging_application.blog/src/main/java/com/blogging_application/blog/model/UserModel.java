package com.blogging_application.blog.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.checkerframework.common.aliasing.qual.Unique;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserModel {
	
	private Integer userid;
	
	@NotBlank(message = "First Name cannot be empty")
	@Size(min = 4, max = 20, message = "first name must be minimum of 4 characters")
	private String firstName;
	
	@NotBlank(message = "Last Name cannot be empty")
	@Size(min = 4, max = 20, message = "first name must be minimum of 4 characters")
	private String lastName;

	@NotBlank(message = "Username cannot be empty")
	@Size(min = 4, max = 20, message = "User name must be minimum of 4 characters")
	private String userName;

	@NotBlank(message = "Mobile Number cannot be empty")
	@Size(min = 10, max = 10, message = "Mobile Number must be of 10 digits")
	private String mobileNumber;

	@NotBlank(message = "Email cannot be empty")
	@Email(message = "Your email address is not valid")
	private String emailAddress;

	private Integer termsOfUseAcceptance;

	private Integer privacyAcceptance;

	@NotBlank(message = "password cannot be empty")
	@Size(min = 8, max = 12, message = "Password must be minimum of 8 charcaters and maximum of 12 characters")
	private String password;

	@NotBlank(message = "about cannot be empty")
	private String about;

	private Set<UserRoleModel> roles = new HashSet<>();

	public Set<UserRoleModel> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRoleModel> roles) {
		this.roles = roles;
	}

	public Integer getUserId() {
		return userid;
	}

	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setUserId(Integer userid) {
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
	
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getFirstName() {
		return firstName;
	}

	@Override
	public String toString() {
		return "UserModel [userid=" + userid + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", mobileNumber=" + mobileNumber + ", emailAddress=" + emailAddress
				+ ", termsOfUseAcceptance=" + termsOfUseAcceptance + ", privacyAcceptance=" + privacyAcceptance
				+ ", password=" + password + ", about=" + about + ", roles=" + roles + "]";
	}

	public UserModel(Integer userid,
			@NotBlank(message = "First Name cannot be empty") @Size(min = 4, max = 20, message = "first name must be minimum of 4 characters") String firstName,
			@NotBlank(message = "Last Name cannot be empty") @Size(min = 4, max = 20, message = "first name must be minimum of 4 characters") String lastName,
			@NotBlank(message = "Username cannot be empty") @Size(min = 4, max = 20, message = "User name must be minimum of 4 characters") String userName,
			@NotBlank(message = "Mobile Number cannot be empty") @Size(min = 10, max = 10, message = "Mobile Number must be of 10 digits") String mobileNumber,
			@NotBlank(message = "Email cannot be empty") @Email(message = "Your email address is not valid") String emailAddress,
			Integer termsOfUseAcceptance, Integer privacyAcceptance,
			@NotBlank(message = "password cannot be empty") @Size(min = 8, max = 12, message = "Password must be minimum of 8 charcaters and maximum of 12 characters") String password,
			@NotBlank(message = "about cannot be empty") String about, Set<UserRoleModel> roles) {
		super();
		this.userid = userid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress;
		this.termsOfUseAcceptance = termsOfUseAcceptance;
		this.privacyAcceptance = privacyAcceptance;
		this.password = password;
		this.about = about;
		this.roles = roles;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

}
