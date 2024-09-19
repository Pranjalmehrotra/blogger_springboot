package com.blogging_application.blog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.blogging_application.blog.repository.UserRepository;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void repoTest() {
		
		String className = this.userRepository.getClass().getName();
		String packageName = this.userRepository.getClass().getPackageName();
		System.out.println("Class Name is ::" + className);
		System.out.println("Package Name is ::" + packageName);
		
		//Output of the above Programme:
		//Class Name is ::jdk.proxy2.$Proxy119
		//It is the class name of the UserRepoImpl which has been created by 
		//the Spring container during runtime itself.
		//Package Name is ::jdk.proxy2
		
	}

}
