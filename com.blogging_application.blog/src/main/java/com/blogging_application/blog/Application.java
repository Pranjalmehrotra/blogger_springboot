package com.blogging_application.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blogging_application.blog.entity.UserRoleEntity;
import com.blogging_application.blog.repository.UserRoleRepository;

@SpringBootApplication

//public class Application implements CommandLineRunner {
public class Application {
	@Autowired
	UserRoleEntity userRoleEntity;

	@Autowired
	UserRoleRepository userRoleRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	/*
	 * @Override public void run(String... args) throws Exception { UserRoleEntity
	 * adminRole = new UserRoleEntity(BlogConstants.ADMIN_USER, "ADMIN ROLE",
	 * "Admin has rights of everything.It can update,create,delete any resources");
	 * UserRoleEntity normalRole = new UserRoleEntity(BlogConstants.NORMAL_USER,
	 * "NORMAL ROLE", "Normal user has normal rights"); List<UserRoleEntity>
	 * roleList = List.of(adminRole, normalRole);
	 * userRoleRepository.saveAll(roleList); }
	 */

}
