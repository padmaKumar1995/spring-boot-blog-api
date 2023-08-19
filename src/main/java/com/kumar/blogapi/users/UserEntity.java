package com.kumar.blogapi.users;

import com.kumar.blogapi.articles.ArticleEntity;
import com.kumar.blogapi.commons.BaseEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "users")
public class UserEntity extends BaseEntity {
    @Column(nullable = false, unique = true, length = 50)
    String userName;
    String password; //TODO Has this
    String bio;
    String image;
    @ManyToMany(mappedBy = "likedBy")
    List<ArticleEntity> likedArticled;
    @ManyToMany(mappedBy = "following")
    List<UserEntity> followers;
    @ManyToMany
    @JoinTable(
            name = "user_follows",
            joinColumns = @JoinColumn(name = "follower_id"),
            inverseJoinColumns = @JoinColumn(name = "following_id")
    )
    List<UserEntity> following;
}
