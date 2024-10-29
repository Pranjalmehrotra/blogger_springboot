package com.blogging_application.blog;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.blogging_application.blog.entity.UserRoleEntity;
import com.blogging_application.blog.repository.UserRoleRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRoleRespositoryTest {

	@Autowired
	UserRoleRepository userRoleRepository;

	@Test
	public void testCreateFirstRole() {

		/*
		 * UserRoleEntity userRoleAdminEntity = new
		 * UserRoleEntity("Admin","It will Manage Everything"); UserRoleEntity
		 * adminRoleSaved = userRoleRepository.save(userRoleAdminEntity);
		 * assertThat(adminRoleSaved.getUserid()).isGreaterThan(0);
		 */

		// Method 1 ::Creating the roles by writing each roles separately
		/*
		 * UserRoleEntity userRoleSalesEntity = new
		 * UserRoleEntity("SalesPerson","It will Manage Everything"); UserRoleEntity
		 * saleRoleSaved = userRoleRepository.save(userRoleSalesEntity);
		 * assertThat(saleRoleSaved.getUserid()).isGreaterThan(0);
		 */

		/*
		 * UserRoleEntity userEditorEntity = new UserRoleEntity(
		 * "Editor","It will Manage categories,brands,products,articles and menus");
		 * UserRoleEntity editorRoleSaved = userRoleRepository.save(userEditorEntity);
		 * assertThat(editorRoleSaved.getUserid()).isGreaterThan(0);
		 */

		/*
		 * UserRoleEntity userShipperEntity = new UserRoleEntity(
		 * "Shipper","It will view products,view orders and update order status");
		 * UserRoleEntity shipperRoleSaved = userRoleRepository.save(userShipperEntity);
		 * assertThat(shipperRoleSaved.getUserid()).isGreaterThan(0);
		 */

		/*
		 * UserRoleEntity userAsitantEntity = new
		 * UserRoleEntity("Assitant","It will manage questions and reviews");
		 * UserRoleEntity assitantRoleSaved =
		 * userRoleRepository.save(userAsitantEntity);
		 * assertThat(assitantRoleSaved.getUserid()).isGreaterThan(0);
		 */

	}

	// Another way of doing inserting the roles is ::

	// Method 2-->By Using the concept of List

	/*
	 * @Test public void testCreateRestRoles() {
	 * 
	 * UserRoleEntity userRoleSalesEntity = new UserRoleEntity(502, "Normal User",
	 * "It will access realted to its work only.No controll on other users");
	 * 
	 * UserRoleEntity userEditorEntity = new UserRoleEntity(503, "Admin User",
	 * "It has Admin Rights");
	 * 
	 * userRoleRepository.saveAll(List.of(userEditorEntity, userRoleSalesEntity));
	 * 
	 * }
	 */

}
