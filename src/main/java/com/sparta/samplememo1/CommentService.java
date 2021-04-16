package com.sparta.samplememo1;

import com.sparta.samplememo1.dto.CommentRequestDto;
import com.sparta.samplememo1.model.Comment;
import com.sparta.samplememo1.repository.CommentRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;


    @Transactional
    public Long updateComment(Long id, CommentRequestDto commentDto){
        Comment comment = commentRepository.findById(id).orElseThrow(
                () ->new NullPointerException("해당 댓글이 존재하지 않습니다.")
        );
        comment.updateComment(commentDto);
        return comment.getId();
    }


}
