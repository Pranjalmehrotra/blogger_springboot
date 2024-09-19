package com.blogging_application.blog.service;

import java.util.List;

import com.blogging.application.blog.model.UserModel;

public interface UserService {
	
	UserModel createUser(UserModel userModel);
	
	UserModel updateUser(UserModel userModel,Integer userId);
	
	UserModel getUserById(Integer userId);
	
	List<UserModel>getAllUers();
	
	void deleteUser(Integer userId);
	
	

}
