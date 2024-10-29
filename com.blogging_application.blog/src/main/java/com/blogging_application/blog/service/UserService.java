package com.blogging_application.blog.service;

import java.util.List;

import com.blogging_application.blog.model.UserModel;
import com.blogging_application.blog.entity.UserEntity;

public interface UserService {

	// UserModel createUser(UserModel userModel);

	UserModel updateUser(UserModel userModel, Integer userId);

	UserModel getUserById(Integer userId);

	List<UserModel> getAllUers();

	void deleteUser(Integer userId);

	UserEntity findByUserEmail(String userEmail);

	UserEntity findByUserName(String userName);

	UserEntity findByUserPhoneNumber(String userPhoneNumber);

	UserModel registerNewUser(UserModel registerUserModel);

}
