package com.ibexsys.websvc.rest.toolkit.entity.user;

import com.ibexsys.websvc.rest.toolkit.entity.post.Post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.GeneratedValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import javax.validation.constraints.Past;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


// NOTE: Swagger annotations of @ApiModel and @ApiModelProperty

@Entity
@ApiModel(description = "Sample User Model")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;


    @Size(min=2,max=32, message="size at least 2 characters")
    @ApiModelProperty(notes="size at least 2 characters")
    private String name;

    @Past(message="Birth Date must be in the past!")
    @ApiModelProperty(notes="Birth Date must be in the past!")
    private Date birthDate;

    @OneToMany(mappedBy="user")
    private final List<Post> posts = new ArrayList<>();

    protected User(){}

    public User(Long id, String name, Date birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public List<Post> getPosts(){
        return this.posts;
    }

    public void addPost(Post post){
        if (post != null) {
            posts.add(post);
        }
    }

    public Post getPost(Long id){

        //@TODO Use a lamdba heere

        for (Post post : posts){
            if (post.getId().equals(id)){
                return post;
            }
        }

          return null;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
