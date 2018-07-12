package com.ibexsys.websvc.rest.toolkit.entity.post;

import com.ibexsys.websvc.rest.toolkit.entity.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.FetchType;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;



    @ManyToOne(fetch=FetchType.LAZY)
    private User user;

    private String message;

    protected Post(){}

    public Post(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public User getUser() {
//        return user;
//    }
//
    public void setUser(User user) {
        this.user = user;
    }

}
