package com.ibexsys.websvc.rest.toolkit.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.ibexsys.websvc.rest.toolkit.entity.post.Post;
import com.ibexsys.websvc.rest.toolkit.entity.user.User;
import com.ibexsys.websvc.rest.toolkit.entity.user.UserDaoService;


import com.ibexsys.websvc.rest.toolkit.entity.user.UserNotFoundException;
import com.ibexsys.websvc.rest.toolkit.repository.PostRepository;
import com.ibexsys.websvc.rest.toolkit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserDaoService service;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PostRepository postRepo;


    @GetMapping("/users")
    public List<User> retreiveAllUsers(){
       return userRepo.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Long id){

        Optional<User> user = userRepo.findById(id);

         if (!user.isPresent()) {
            throw new UserNotFoundException("User Not Found id:" + id);
         }

        return user;
     }

     @DeleteMapping("/users/{id}")
     public void  deleteUserById(@PathVariable Long id){

         Optional<User> user = userRepo.findById(id);

         if (user.isPresent()) {
             userRepo.deleteById(id);
         } else {
             throw new UserNotFoundException("User Not Found id:" + id);
         }
     }


     @PostMapping("/users")
     public ResponseEntity<Object> createUser(@Valid @RequestBody User user){

         User savedUser = userRepo.save(user);

        // Create URI of created user
         URI location = ServletUriComponentsBuilder
                 .fromCurrentRequest()
                 .path("/{id}")
                 .buildAndExpand(savedUser.getId()).toUri();

         return ResponseEntity.created(location).build();
     }


//     @PostMapping("/users/{id}/posts")
//     public ResponseEntityObject<Object> createPost(@PathVariable Long id, @RequestBody Post post)
//     {
//
//         Optional<User> user = userRepo.findById(id);
//
//         if (user == null) {
//
//             throw new UserNotFoundException("User Not Found id:" + id);
//         }
//
//
//         post.setUser(user.get());
//         Post savedPost = postRepo.save(post);
//
//
//         // Create URI of created user
//         URI location = ServletUriComponentsBuilder
//                 .fromCurrentRequest()
//                 .path("/{id}")
//                 .buildAndExpand(savedPost.getId()).toUri();
//
////         // Create URI of created user
////         URI location = ServletUriComponentsBuilder
////                 .fromCurrentRequest()
////                 .path("/{id}")
////                 .buildAndExpand(savedUser.getId()).toUri();
//
//         return ResponseEntity.created(location).build();


 //    }

}
