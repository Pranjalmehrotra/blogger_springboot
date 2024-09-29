package com.blogging_application.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogging_application.blog.entity.CommentEntity;

@Repository
public interface CommentRespository extends JpaRepository<CommentEntity,Integer>{

}
