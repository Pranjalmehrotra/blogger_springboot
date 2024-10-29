package com.blogging_application.blog.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blogging_application.blog.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
	
	@Query("Select userEntity from UserEntity userEntity where userEntity.emailAddress like :userEmail")
	Optional<UserEntity>findByUserEmail(@Param("userEmail") String userEmail);
	
	@Query("Select userEntity from UserEntity userEntity where userEntity.userName = :userName")
	UserEntity findByUserName(@Param("userName")String userName);
	
	@Query("Select userEntity from UserEntity userEntity where userEntity.mobileNumber = :mobileNumber")
	UserEntity findByMobileNumber(@Param("mobileNumber")String mobileNumber);
	
	@Query("Select userEntity from UserEntity userEntity where userEntity.emailAddress like :userEmail")
	UserEntity findByUserEmailRegisterUser(@Param("userEmail") String userEmail);
	
	
	
	

}
