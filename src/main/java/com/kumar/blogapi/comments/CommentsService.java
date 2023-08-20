package com.kumar.blogapi.comments;

import com.kumar.blogapi.comments.dto.CommentResponseDto;
import com.kumar.blogapi.comments.dto.CreateCommentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {
    private final CommentsRepository commentsRepository;
    private final ModelMapper modelMapper;

    public CommentsService(CommentsRepository commentsRepository, ModelMapper modelMapper) {
        this.commentsRepository = commentsRepository;
        this.modelMapper = modelMapper;
    }

    public CommentResponseDto createComment(CreateCommentDTO commentDTO, Integer articleId, Integer userId) {
        //TODO: Check it user exist
        //TODO: Check if article exist
        var commentEntityToSave = modelMapper.map(commentDTO, CommentEntity.class);
        //TODO: Set Article and User for commentEntityToSave
        var savedCommentEntity = commentsRepository.save(commentEntityToSave);
        return modelMapper.map(savedCommentEntity, CommentResponseDto.class);
    }
}
