package com.daltons.backend.controller;

import com.daltons.backend.model.Comment;
import com.daltons.backend.model.Picture;
import com.daltons.backend.model.Post;
import com.daltons.backend.service.comment.CommentService;
import com.daltons.backend.service.picture.PictureService;
import com.daltons.backend.service.post.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping(value = "/post")
public class PostController {
    private final PostService postService;
    private final CommentService commentService;
    private final PictureService pictureService;
    private final CommentController commentController;
    private final PictureController pictureController;

    public PostController(
            PostService postService,
            CommentService commentService,
            PictureService pictureService,
            CommentController commentController,
            PictureController pictureController
            ) {
        this.postService = postService;
        this.commentService = commentService;
        this.pictureService = pictureService;
        this.commentController = commentController;
        this.pictureController = pictureController;
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@Validated @RequestBody Post post) {
        System.out.println(post.getIsConcert());
        if(postService.findById(post.getPostId()) != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else {
            Post newPost = postService.save(post);
            if (newPost == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(newPost, HttpStatus.CREATED);
        }
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPost() {
        List<Post> postList = postService.findAll();
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer id) {
        Post post = postService.findById(id);
        if (post == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Integer id) {
        Post post = postService.findById(id);

        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Comment> comments = commentService.findAll();
        for (Comment comment : comments) {
            if (comment.getPostId() != null && post.getPostId() == comment.getPostId().getPostId()) {
                commentService.deleteById(comment.getCommentId());
            }
        }

        List<Picture> pictures = pictureService.findAll();
        for (Picture picture : pictures) {
            if (picture.getPostId() != null && post.getPostId() == picture.getPostId().getPostId()) {
                pictureService.deleteById(picture.getPictureId());
            }
        }

        postService.delete(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@RequestBody Post post, @PathVariable Integer id) {
        Post updatedPost = postService.findById(id);
            if (post.getText() != null) {
                updatedPost.setText(post.getText());
            }
            if (post.getTitle() != null) {
                updatedPost.setTitle(post.getTitle());
            }
            if (post.getIsConcert() != null) {
                updatedPost.setIsConcert(post.getIsConcert());
            }
            return new ResponseEntity<>(postService.save(updatedPost), HttpStatus.OK);
    }
}
