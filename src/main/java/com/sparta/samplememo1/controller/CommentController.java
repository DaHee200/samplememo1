package com.sparta.samplememo1.controller;

import com.sparta.samplememo1.CommentService;
import com.sparta.samplememo1.Timestamped;
import com.sparta.samplememo1.dto.CommentRequestDto;
import com.sparta.samplememo1.model.Comment;
import com.sparta.samplememo1.repository.CommentRepository;
import com.sparta.samplememo1.service.Const;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = Const.ClientServerHost)
@RequiredArgsConstructor
public class CommentController extends Timestamped {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @GetMapping(value = "/api/comment", produces = "application/json")
    public List<Comment> getComment(){
        return commentRepository.findAllByOrderByModifiedAt();
//findAllByMemoId()
    }

    @PostMapping(value = "/api/comment", produces = "application/json")
    public Comment creatComment(@RequestBody CommentRequestDto commentDto) {
        Comment comment = new Comment(commentDto);
        return commentRepository.save(comment);
    }

    @PutMapping(value = "/api/comment/{id}", produces = "application/json")
    public Long updateComment(@PathVariable Long id, @RequestBody CommentRequestDto commentDto){
        return commentService.updateComment(id, commentDto);
    }

    @DeleteMapping(value = "/api/comment/{id}", produces = "application/json")
    public Long deleteComment(@PathVariable Long id){
        commentRepository.deleteById(id);
        return id;
    }

}
