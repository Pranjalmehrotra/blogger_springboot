/*
 * package com.blogging_application.blog;
 * 
 * import java.util.List; import org.junit.jupiter.api.Test; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
 * import
 * org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.
 * Replace; import
 * org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest; import
 * org.springframework.test.annotation.Rollback;
 * 
 * import com.blogging_application.blog.entity.UserRoleEntity; import
 * com.blogging_application.blog.repository.UserRoleRepository;
 * 
 * JpaTest
 * 
 * @AutoConfigureTestDatabase(replace = Replace.NONE) //@Rollback(false) public
 * class UserRoleRespositoryTest {
 * 
 * @Autowired UserRoleRepository userRoleRepository;
 * 
 * @Test public void testCreateFirstRole() {
 * 
 * 
 * UserRoleEntity userRoleAdminEntity = new
 * UserRoleEntity("Admin","It will Manage Everything"); UserRoleEntity
 * adminRoleSaved = userRoleDao.save(userRoleAdminEntity);
 * assertThat(adminRoleSaved.getUserid()).isGreaterThan(0);
 * 
 * 
 * // Method 1 ::Creating the roles by writing each roles separately
 * 
 * UserRoleEntity userRoleSalesEntity = new
 * UserRoleEntity("SalesPerson","It will Manage Everything"); UserRoleEntity
 * saleRoleSaved = userRoleDao.save(userRoleSalesEntity);
 * assertThat(saleRoleSaved.getUserid()).isGreaterThan(0);
 * 
 * 
 * 
 * UserRoleEntity userEditorEntity = new UserRoleEntity(
 * "Editor","It will Manage categories,brands,products,articles and menus");
 * UserRoleEntity editorRoleSaved = userRoleDao.save(userEditorEntity);
 * assertThat(editorRoleSaved.getUserid()).isGreaterThan(0);
 * 
 * 
 * 
 * UserRoleEntity userShipperEntity = new UserRoleEntity(
 * "Shipper","It will view products,view orders and update order status");
 * UserRoleEntity shipperRoleSaved = userRoleDao.save(userShipperEntity);
 * assertThat(shipperRoleSaved.getUserid()).isGreaterThan(0);
 * 
 * 
 * 
 * UserRoleEntity userAsitantEntity = new
 * UserRoleEntity("Assitant","It will manage questions and reviews");
 * UserRoleEntity assitantRoleSaved = userRoleDao.save(userAsitantEntity);
 * assertThat(assitantRoleSaved.getUserid()).isGreaterThan(0);
 * 
 * 
 * }
 * 
 * // Another way of doing inserting the roles is ::
 * 
 * // Method 2-->By Using the concept of List
 * 
 * @Test public void testCreateRestRoles() {
 * 
 * UserRoleEntity userRoleSalesEntity = new UserRoleEntity("Software developer",
 * "It will Manage development related work");
 * 
 * UserRoleEntity userEditorEntity = new UserRoleEntity("Software Tester",
 * "It will Manage testing related work");
 * 
 * UserRoleEntity userShipperEntity = new UserRoleEntity("Shipper",
 * "It will view products,view orders and update order status");
 * 
 * UserRoleEntity userAsitantEntity = new UserRoleEntity("Assitant",
 * "It will manage questions and reviews");
 * 
 * userRoleRepository .saveAll(List.of(userEditorEntity, userRoleSalesEntity,
 * userShipperEntity, userAsitantEntity));
 * 
 * }
 * 
 * }
 */