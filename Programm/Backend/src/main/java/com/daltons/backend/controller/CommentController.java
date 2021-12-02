package com.daltons.backend.controller;

import com.daltons.backend.model.Comment;
import com.daltons.backend.service.comment.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping(value = "/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(@Validated @RequestBody Comment comment) {
        if(commentService.findById(comment.getCommentId()) != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else {
            Comment newComment = commentService.save(comment);
            if (newComment == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(newComment, HttpStatus.CREATED);
        }
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComment() {
        List<Comment> commentList = commentService.findAll();
        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Integer id) {
        Comment comment = commentService.findById(id);
        if (comment == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Integer id) {
        Comment comment = commentService.findById(id);

        if (comment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        commentService.delete(comment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment, @PathVariable Integer id) {
        Comment updatedComment = commentService.findById(id);
            if (comment.getText() != null) {
                updatedComment.setText(comment.getText());
            }
            return new ResponseEntity<>(commentService.save(updatedComment), HttpStatus.OK);
    }
}
