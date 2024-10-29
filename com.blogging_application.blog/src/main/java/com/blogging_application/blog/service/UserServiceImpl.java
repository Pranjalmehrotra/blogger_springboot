package com.blogging_application.blog.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.blogging_application.blog.model.UserModel;
import com.blogging_application.blog.entity.UserEntity;
import com.blogging_application.blog.entity.UserRoleEntity;
import com.blogging_application.blog.exceptions.ResourceNotFoundException;
import com.blogging_application.blog.repository.UserRepository;
import com.blogging_application.blog.repository.UserRoleRepository;
import com.blogging_application.blog.utils.BlogConstants;

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

	/*
	 * @Override public UserModel createUser(UserModel userModel) { // TODO
	 * Auto-generated method stub
	 * 
	 * // Here, we are taking userModel object and convert it into the userEntity
	 * which // is the // required for inserting into the repository. userEntity =
	 * this.modelToEntityModelMapper(userModel); UserEntity newUserEntity =
	 * userRepository.save(userEntity);
	 * 
	 * // Here ,we are now converting the userEntity object to the userModel because
	 * // the return type of the // method is of UserModel. return
	 * this.entityToModel(newUserEntity); }
	 */

	@Override
	public UserModel registerNewUser(UserModel registerUserModel) {
		/*
		 * byte[] salt = new String("622836429").getBytes(); int iterationCount = 10000;
		 * int keyLength = 128;
		 * 
		 * secretKey object = new secretKey(); SecretKeySpec key =
		 * object.generateSecretKey( password.toCharArray(), salt, iterationCount,
		 * keyLength);
		 * 
		 * String originalPassword = password; System.out.println("Original password: "
		 * + originalPassword); String encryptedPassword =
		 * object.encrypt(originalPassword, key);
		 */
		System.out.println("The values of usermodel are::" + registerUserModel.toString());
		/*
		 * if (userEntity.getEmailAddress() != null &&
		 * !(userEntity.getEmailAddress().isEmpty()) &&
		 * userEntity.getEmailAddress().equalsIgnoreCase(registerUserModel.
		 * getEmailAddress())) { System.out.println("Email address matched");
		 * userModel.setEmailAddress("Email address already exists"); return userModel;
		 * }
		 */
		if(findByUserEmail("%"+registerUserModel.getEmailAddress()+"%") != null) {
			System.out.println("user name matched");
			userModel.setEmailAddress("Email address already exists");
			return userModel;
			
		}
		
		if(findByUserName(registerUserModel.getUserName()) != null) {
			System.out.println("user name matched");
			userModel.setUserName("User Name already exists");
			return userModel;
			
		}
		
		if(findByUserPhoneNumber(registerUserModel.getMobileNumber()) != null) {
			System.out.println("user name matched");
			userModel.setMobileNumber("Mobile number already exists");
			return userModel;
			
		}
		 else {

			// Encoding the password send from the frontend
			String encodedPassword = bPasswordEncoder.encode(registerUserModel.getPassword());
			System.out.println("The raw-passord is ::" + registerUserModel.getPassword());

			System.out.println("The enocded passord is ::" + encodedPassword);

			UserEntity registerUserEntity = modelMapper.map(registerUserModel, UserEntity.class);
			registerUserEntity.setPassword(encodedPassword);

			// Setting the predefined roles to the user.
			UserRoleEntity userRoleEntity = this.userRoleRepository.findById(BlogConstants.NORMAL_USER).get();
			registerUserEntity.getRoles().add(userRoleEntity);

			UserEntity registeredUser = this.userRepository.save(registerUserEntity);
			// TODO Auto-generated method stub
			return this.modelMapper.map(registeredUser, UserModel.class);
		}
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

	/*
	 * @Override public UserEntity findByUserEmail(String userEmail) {
	 * 
	 * // TODO Auto-generated method stub userEntity =
	 * this.userRepository.findByUserEmail("%" + userEmail + "%") .orElseThrow(() ->
	 * new UsernameNotFoundException("User Name not found is ::" + userEmail));
	 * return userEntity; // return this.entityToModel(userEntity); }
	 */
	
	@Override
	public UserEntity findByUserEmail(String userEmail) {

		// TODO Auto-generated method stub
		userEntity = this.userRepository.findByUserEmailRegisterUser("%" + userEmail + "%");
		return userEntity;
		// return this.entityToModel(userEntity);
	}
	
	
	/*
	 * @Override public UserEntity findByUserName(String userName) { // TODO
	 * Auto-generated method stub userEntity =
	 * this.userRepository.findByUserName(userName). orElseThrow(()-> { return new
	 * UsernameNotFoundException("User name not found is::" + userName); }); return
	 * userEntity; }
	 */
	
	@Override
	public UserEntity findByUserName(String userName) {
		// TODO Auto-generated method stub
		userEntity = this.userRepository.findByUserName(userName);
		return userEntity;
	}

	/*
	 * @Override public UserEntity findByUserPhoneNumber(String userPhoneNumber) {
	 * 
	 * // TODO Auto-generated method stub userEntity =
	 * this.userRepository.findByMobileNumber(userPhoneNumber). orElseThrow(()->{
	 * return new UsernameNotFoundException("User name not found is::" +
	 * userPhoneNumber); }); return userEntity; }
	 */
	
	@Override
	public UserEntity findByUserPhoneNumber(String userPhoneNumber) {
		
		// TODO Auto-generated method stub
		userEntity = this.userRepository.findByMobileNumber(userPhoneNumber);
				return userEntity;
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
