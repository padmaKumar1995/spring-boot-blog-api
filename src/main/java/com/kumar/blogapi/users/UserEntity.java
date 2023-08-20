package com.kumar.blogapi.users;

import com.kumar.blogapi.articles.ArticleEntity;
import com.kumar.blogapi.commons.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "users")
@Getter
@Setter
public class UserEntity extends BaseEntity {
    @Column(nullable = false, unique = true, length = 50)
    String userName;
    String email;
    String password;
    String bio;
    String image;
    @ManyToMany(mappedBy = "likedBy")
    List<ArticleEntity> likedArticles;
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
