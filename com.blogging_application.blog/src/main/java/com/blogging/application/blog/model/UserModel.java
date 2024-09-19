package com.blogging.application.blog.model;

import java.util.Objects;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserModel {
	
	@Override
	public int hashCode() {
		return Objects.hash(about, emailAddress, mobileNumber, password, privacyAcceptance, termsOfUseAcceptance,
				userName, userid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserModel other = (UserModel) obj;
		return Objects.equals(about, other.about) && Objects.equals(emailAddress, other.emailAddress)
				&& Objects.equals(mobileNumber, other.mobileNumber) && Objects.equals(password, other.password)
				&& Objects.equals(privacyAcceptance, other.privacyAcceptance)
				&& Objects.equals(termsOfUseAcceptance, other.termsOfUseAcceptance)
				&& Objects.equals(userName, other.userName) && Objects.equals(userid, other.userid);
	}

	private Integer  userid;
	
	@NotBlank(message = "Username cannot be empty")
	@Size(min = 4,max = 20,message = "User name must be minimum of 4 characters")
	private String userName;
	
	@NotBlank(message = "Mobile Number cannot be empty")
	@Size(min = 10,max = 10,message = "Mobile Number must be of 10 digits")
	private String mobileNumber;
	
	@NotBlank(message = "Email cannot be empty")
	@Email(message = "Your email address is not valid")
	private String emailAddress;
	private Integer termsOfUseAcceptance;
	private Integer privacyAcceptance;
	
	@NotBlank(message = "password cannot be empty")
	@Size(min = 8,max=12,message = "Password must be minimum of 8 charcaters and maximum of 12 characters")
	private String password;
	
	@NotBlank(message = "about cannot be empty")
	private String about;
	
	
	
	
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

	@Override
	public String toString() {
		return "UserModel [userid=" + userid + ", userName=" + userName + ", mobileNumber=" + mobileNumber
				+ ", emailAddress=" + emailAddress + ", termsOfUseAcceptance=" + termsOfUseAcceptance
				+ ", privacyAcceptance=" + privacyAcceptance + ", password=" + password + ", about=" + about + "]";
	}

	public UserModel(Integer userid, String userName, String mobileNumber, String emailAddress,
			Integer termsOfUseAcceptance, Integer privacyAcceptance, String password, String about) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress;
		this.termsOfUseAcceptance = termsOfUseAcceptance;
		this.privacyAcceptance = privacyAcceptance;
		this.password = password;
		this.about = about;
	}

	

}
