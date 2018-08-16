package com.target.product.feedback.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.target.product.feedback.entity.Comments;

@Repository
public interface CommentsRepo extends JpaRepository<Comments, Long>{

}
