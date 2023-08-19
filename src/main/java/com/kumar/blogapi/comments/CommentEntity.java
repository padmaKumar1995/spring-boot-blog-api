package com.kumar.blogapi.comments;

import com.kumar.blogapi.articles.ArticleEntity;
import com.kumar.blogapi.commons.BaseEntity;
import com.kumar.blogapi.users.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity(name = "comments")
public class CommentEntity extends BaseEntity {
    @Column(nullable = false, length = 100)
    String title;
    @Column(length = 1000)
    String body;
    @ManyToOne
    ArticleEntity article;
    @ManyToOne
    UserEntity author;
}
