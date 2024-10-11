package com.blogging_application.blog.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blogging.application.blog.model.UserModel;
import com.blogging_application.blog.entity.UserEntity;
import com.blogging_application.blog.entity.UserRoleEntity;
import com.blogging_application.blog.exceptions.ResourceNotFoundException;
import com.blogging_application.blog.repository.UserRepository;
import com.blogging_application.blog.repository.UserRoleRepository;

import utils.BlogConstants;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	PasswordEncoder bPasswordEncoder;
	
	@Autowired
	private UserRoleRepository userRoleRepository;

	UserEntity userEntity = new UserEntity();
	UserModel userModel = new UserModel();

	@Override
	public UserModel createUser(UserModel userModel) {
		// TODO Auto-generated method stub

		// Here, we are taking userModel object and convert it into the userEntity which
		// is the
		// required for inserting into the repository.
		userEntity = this.modelToEntityModelMapper(userModel);
		UserEntity newUserEntity = userRepository.save(userEntity);

		// Here ,we are now converting the userEntity object to the userModel because
		// the return type of the
		// method is of UserModel.
		return this.entityToModel(newUserEntity);
	}

	@Override
	public UserModel updateUser(UserModel userModel, Integer userId) {
		userEntity = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("UserModel", "User id", userId));
		userEntity.setUserName(userModel.getUserName());
		userEntity.setAbout(userModel.getAbout());
		userEntity.setPassword(userModel.getPassword());
		UserEntity updatedUserEntity = userRepository.save(userEntity);
		// TODO Auto-generated method stub
		return this.entityToModel(updatedUserEntity);
	}

	@Override
	public UserModel getUserById(Integer userId) {
		userEntity = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("UserModel", "User", userId));
		// TODO Auto-generated method stub
		return this.entityToModel(userEntity);
	}

	@Override
	public UserEntity findByUserEmail(String userEmail) {

		// TODO Auto-generated method stub
		userEntity = this.userRepository.findByUserEmail("%" + userEmail + "%")
				.orElseThrow(() -> new UsernameNotFoundException("User Name not found is ::" + userEmail));
		return userEntity;
		// return this.entityToModel(userEntity);
	}

	@Override
	public List<UserModel> getAllUers() {
		List<UserEntity> userEntityList = this.userRepository.findAll();
		List<UserModel> userModelList = userEntityList.stream().map(user -> this.entityToModel(user))
				.collect(Collectors.toList());
		// TODO Auto-generated method stub
		return userModelList;
	}
	
	@Override
	public UserModel registerNewUser(UserModel registerUserModel) {

		//Encoding the password send from the frontend
		String encodedPassword = bPasswordEncoder.encode(registerUserModel.getPassword());
		
		UserEntity registerUserEntity = modelMapper.map(registerUserModel, UserEntity.class);
		registerUserEntity.setPassword(encodedPassword);
		
		//Setting the predefined roles to the user.
		UserRoleEntity userRoleEntity = this.userRoleRepository.findById(BlogConstants.NORMAL_USER).get();
		registerUserEntity.getRoles().add(userRoleEntity);
		
		UserEntity registeredUser = this.userRepository.save(registerUserEntity);
		// TODO Auto-generated method stub
		return this.modelMapper.map(registeredUser, UserModel.class);
	}

	@Override
	public void deleteUser(Integer userId) {
		userEntity = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Model", "User id", userId));
		this.userRepository.delete(userEntity);

	}

	/*
	 * private UserEntity modelToEntity(UserModel userModel) { //UserEntity
	 * userEntity = new UserEntity();
	 * 
	 * //userEntity.setUserid(userModel.getUserId());
	 * userEntity.setEmailAddress(userModel.getEmailAddress());
	 * userEntity.setMobileNumber(userModel.getMobileNumber());
	 * userEntity.setPassword(userModel.getPassword());
	 * userEntity.setAbout(userModel.getAbout());
	 * userEntity.setUserName(userModel.getUserName());
	 * userEntity.setPrivacyAcceptance(userModel.getPrivacyAcceptance());
	 * userEntity.setTermsOfUseAcceptance(userModel.getTermsOfUseAcceptance());
	 * 
	 * return userEntity;
	 * 
	 * }
	 */

	private UserEntity modelToEntityModelMapper(UserModel userModel) {
		// UserEntity userEntity = new UserEntity();

		// userEntity.setUserid(userModel.getUserId());
		UserEntity userEntity = this.modelMapper.map(userModel, UserEntity.class);

		return userEntity;

	}

	/*
	 * private UserModel entityToModel(UserEntity userEntity) { //UserModel
	 * userModel = new UserModel(); System.out.println("UserEntity is::" +
	 * userEntity.toString()); //userEntity.setUserid(userModel.getUserId());
	 * userModel.setEmailAddress(userEntity.getEmailAddress());
	 * userModel.setMobileNumber(userEntity.getMobileNumber());
	 * userModel.setPassword(userEntity.getPassword());
	 * userModel.setAbout(userEntity.getAbout());
	 * userModel.setUserName(userEntity.getUserName());
	 * userModel.setPrivacyAcceptance(userEntity.getPrivacyAcceptance());
	 * userModel.setTermsOfUseAcceptance(userEntity.getTermsOfUseAcceptance());
	 * 
	 * return userModel;
	 * 
	 * }
	 */

	private UserModel entityToModel(UserEntity userEntity) {

		UserModel userModel = this.modelMapper.map(userEntity, UserModel.class);

		return userModel;

	}

	

}
