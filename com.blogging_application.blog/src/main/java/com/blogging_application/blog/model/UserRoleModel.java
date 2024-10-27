package com.blogging_application.blog.model;

import java.util.Objects;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class UserRoleModel {
	private Integer roleId;
	private String roleName;
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


	public UserRoleModel() {
		// TODO Auto-generated constructor stub
	}

	public UserRoleModel(Integer userid) {
		super();
		this.roleId = userid;
	}

	public UserRoleModel(String userName, String userDescription) {
		super();
		// this.userid = roleId;
		this.roleName = userName;
		this.roleDescription = userDescription;
	}

	public UserRoleModel(Integer roleId, String roleName, String roleDescription) {
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
