package com.kumar.blogapi.articles;

import org.springframework.stereotype.Controller;

@Controller
public class ArticlesController {
    private final ArticlesService articlesService;

    public ArticlesController(ArticlesService articlesService) {
        this.articlesService = articlesService;
    }
}
