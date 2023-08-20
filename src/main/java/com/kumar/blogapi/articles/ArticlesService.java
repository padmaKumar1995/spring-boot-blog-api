package com.kumar.blogapi.articles;

import com.kumar.blogapi.articles.dto.ArticleResponseDTO;
import com.kumar.blogapi.articles.dto.CreateArticleDTO;
import com.kumar.blogapi.users.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticlesService {
    private final ArticlesRepository articlesRepository;
    private final ModelMapper modelMapper;
    @Autowired
    private UsersService usersService;

    public ArticlesService(ArticlesRepository articlesRepository, ModelMapper modelMapper) {
        this.articlesRepository = articlesRepository;
        this.modelMapper = modelMapper;
    }

    public ArticleResponseDTO createArticle(CreateArticleDTO articleDto, Integer userId) {
        if(articleDto.getTitle() == null || articleDto.getBody() == null) {
            throw new ArticleDataMissing();
        }

        var articleEntityToCreate = modelMapper.map(articleDto, ArticleEntity.class);
        articleEntityToCreate.author = usersService.getUserById(userId);

        var savedArticle = articlesRepository.save(articleEntityToCreate);

        var articleResponseDto = modelMapper.map(savedArticle, ArticleResponseDTO.class);
        articleResponseDto.setAuthorId(userId);
        return articleResponseDto;
    }

    public static class ArticleDataMissing extends IllegalArgumentException {
        public ArticleDataMissing() {
            super("Unable to create article, data missing in the supplied request");
        }
    }
}
