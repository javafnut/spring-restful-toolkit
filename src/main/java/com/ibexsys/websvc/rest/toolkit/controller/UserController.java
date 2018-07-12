package com.ibexsys.websvc.rest.toolkit.controller;

import java.net.URI;
import java.util.List;
import com.ibexsys.websvc.rest.toolkit.entity.user.User;
import com.ibexsys.websvc.rest.toolkit.entity.user.UserDaoService;


import com.ibexsys.websvc.rest.toolkit.entity.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

    @Autowired
    UserDaoService service;

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
         return service.findAll();

    }

     @GetMapping("/users/{id}")
     public User getUserById(@PathVariable Long id){

        User user = service.findById(id);

         if (user == null) {

            throw new UserNotFoundException("User Not Found id:" + id);
         }

        return user;
     }

     @DeleteMapping("/users/{id}")
     public void deleteUserById(@PathVariable Long id){

        if (service.findById(id) != null){
            service.deleteById(id);
        }
     }


     @PostMapping("/users")
     public ResponseEntity<Object> createUser(@RequestBody User user){
        User savedUser = service.save(user);

        // Create URI of created user
         URI location = ServletUriComponentsBuilder
                 .fromCurrentRequest()
                 .path("/{id}")
                 .buildAndExpand(savedUser.getId()).toUri();

         return ResponseEntity.created(location).build();
     }



}
