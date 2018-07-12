package com.ibexsys.websvc.rest.toolkit.repository;

import com.ibexsys.websvc.rest.toolkit.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{


//    // @TODO Some customs..... eval later
//    List<User> findByName(String name);
//
//    List<User> findByNameAndId(String name, Long id);
//
//    List<User> findByNameOrderById(String name);
//
//    List<User> deleteByNameAndId(String name, Long id);

}