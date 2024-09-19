package com.blogging_application.blog.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blogging.application.blog.model.BlogApiResponse;
import com.blogging.application.blog.model.UserModel;
import com.blogging_application.blog.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")


public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	//1.Create User
	@PostMapping("/create-user-detail")
	public ResponseEntity<UserModel>createUserDeatil(@Valid @RequestBody UserModel userModel)
	{
		UserModel createUser = this.userService.createUser(userModel);
		return new ResponseEntity<>(createUser,HttpStatus.CREATED);
		
	}
	
	//2. Update User
	@PutMapping("/update-user/{userId}")
	//2. PUT--->Update User
	public ResponseEntity<UserModel>updateUser(@Valid @RequestBody UserModel userModel,@PathVariable("userId")Integer userId)
	{
		UserModel updateUserModel = this.userService.updateUser(userModel, userId);
		return ResponseEntity.ok(updateUserModel);
		
	
	}
	
	//3. Delete User
	@DeleteMapping("/delete-user/{userId}")
		public ResponseEntity<?>deleteUser(@PathVariable("userId")Integer userId){
		this.userService.deleteUser(userId);
		//BlogApiResponse blogApiResponse = new BlogApiResponse<String>();
		//return new ResponseEntity(Map.of("message","User Deleted Successfully"),HttpStatus.OK);
		return new ResponseEntity<BlogApiResponse>(new BlogApiResponse<String>("User Deleted Successfully",HttpStatus.OK.value(),"Delete Sucessfully"),HttpStatus.OK);
		
	}
	
	
	//4. Get All Users
	@GetMapping("/fetch-all-users")
	public ResponseEntity<List<UserModel>>getAllUsers(){
		List<UserModel>getAllUserList = this.userService.getAllUers();
		return ResponseEntity.ok(getAllUserList);
		}
	
	
	// 5.Get Single User
	@GetMapping("/single-user/{userId}")
	public ResponseEntity<UserModel>getSingleUserDeatil(@PathVariable("userId") Integer userId){
		UserModel singleUser = this.userService.getUserById(userId);
		return ResponseEntity.ok(singleUser);
		
		
	}
	
}
