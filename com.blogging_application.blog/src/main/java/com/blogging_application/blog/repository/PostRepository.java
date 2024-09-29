package com.blogging_application.blog.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.blogging_application.blog.entity.CategoryEntity;
import com.blogging_application.blog.entity.PostEntity;
import com.blogging_application.blog.entity.UserEntity;

@Repository
public interface PostRepository  extends JpaRepository<PostEntity,Integer>{
	
List<PostEntity> findByUserEntity(UserEntity userEntity);
//List<PostEntity> findByUserEntity(Integer userId);

List<PostEntity>findByCategoryEntity(CategoryEntity categoryEntity);
//List<CategoryEntity>findByCategoryEntity(Integer categoryId);

//void deletePostByCategoryIdAndUserId(Integer categoryId, Integer userId);

void deletePostByCategoryEntityAndUserEntity(CategoryEntity categoryEntity, UserEntity userEntity);



//Method1 --->Using the derived Query of the Jpa
//List<PostEntity>findBypostTitleContaining(String title);

//Method 2 --->Using the @Query and @Param annotation for the above task
@Query("Select postEntity from PostEntity postEntity where postEntity.postTitle like :keyword")
List<PostEntity>findBypostTitleContaining(@Param("keyword") String title);






}
