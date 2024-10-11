package com.blogging_application.blog.entity;

import java.util.Objects;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "user_role_tbl")

//Role no --->501------>Normal User
//Role no --->502------>Admin User
public class UserRoleEntity {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Integer roleId;

	

	@Column(name = "role_name", nullable = false, length = 40, unique = true)
	private String roleName;

	@Column(name = "role_description", length = 150, nullable = false)
	private String roleDescription;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer userid) {
		this.roleId = userid;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String userName) {
		this.roleName = userName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String userDescription) {
		this.roleDescription = userDescription;
	}

	@Override
	public int hashCode() {
		return Objects.hash(roleDescription, roleName, roleId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRoleEntity other = (UserRoleEntity) obj;
		return Objects.equals(roleDescription, other.roleDescription) && Objects.equals(roleName, other.roleName)
				&& Objects.equals(roleId, other.roleId);
	}
	
	public UserRoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserRoleEntity(Integer userid) {
		super();
		this.roleId = userid;
	}

	public UserRoleEntity(String userName, String userDescription) {
		super();
		// this.userid = roleId;
		this.roleName = userName;
		this.roleDescription = userDescription;
	}
	
	public UserRoleEntity(Integer roleId, String roleName, String roleDescription) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}

	@Override
	public String toString() {
		return "UserRoleEntity [roleId=" + roleId + ", roleName=" + roleName + ", roleDescription=" + roleDescription
				+ "]";
	}

}
