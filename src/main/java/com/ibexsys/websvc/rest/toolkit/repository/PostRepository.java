package com.ibexsys.websvc.rest.toolkit.repository;


import com.ibexsys.websvc.rest.toolkit.entity.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}