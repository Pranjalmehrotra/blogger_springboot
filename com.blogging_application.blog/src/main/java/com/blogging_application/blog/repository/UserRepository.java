package com.blogging_application.blog.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blogging_application.blog.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
	
	@Query("Select userEntity from UserEntity userEntity where userEntity.emailAddress = :userEmail")
	Optional<UserEntity>findByUserEmail(@Param("userEmail") String userEmail);
	
	
	

}
