package com.kumar.blogapi.articles.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleResponseDto {
    Integer id;
    String slug;
    String title;
    Integer authorId;
}
