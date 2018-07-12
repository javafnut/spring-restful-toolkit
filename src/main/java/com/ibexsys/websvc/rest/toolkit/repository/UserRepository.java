package com.ibexsys.websvc.rest.toolkit.repository;

import com.ibexsys.websvc.rest.toolkit.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}