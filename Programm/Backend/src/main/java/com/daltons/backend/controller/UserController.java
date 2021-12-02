package com.daltons.backend.controller;

import com.daltons.backend.model.Comment;
import com.daltons.backend.service.role.RoleService;
import com.daltons.backend.model.Picture;
import com.daltons.backend.model.Post;
import com.daltons.backend.model.User;
import com.daltons.backend.service.comment.CommentService;
import com.daltons.backend.service.post.PostService;
import com.daltons.backend.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;
    private final CommentService commentService;
    private final RoleService roleService;
    private final CommentController commentController;
    private final PostService postService;
    private final PostController postController;

    public UserController(
            UserService userService,
            CommentService commentService,
            CommentController commentController,
            PostService postService,
            PostController postController
            ) {
        this.userService = userService;
        this.commentService = commentService;
        this.roleService = roleService;
        this.commentController = commentController;
        this.postService = postService;
        this.postController = postController;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Validated @RequestBody User user) {
        if(userService.findById(user.getUserId()) != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else {
            user.setRoleId(roleService.findById(2));
            User newUser = userService.save(user);
            if (newUser == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> userList = userService.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = userService.findById(id);
        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping("/getByUsername/{username}")
    public ResponseEntity<User> getByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        User user = userService.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Comment> comments = commentService.findAll();
        for (Comment comment : comments) {
            if (comment.getUserId() != null && user.getUserId() == comment.getUserId().getUserId()) {
                comment.setUserId(null);
                commentService.save(comment);
            }
        }

        List<Post> posts = postService.findAll();
        for (Post post : posts) {
            if (post.getUserId() != null && user.getUserId() == post.getUserId().getUserId()) {
                post.setUserId(null);
                postService.save(post);
            }
        }

        userService.delete(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Integer id) {
        User updatedUser = userService.findById(id);
            if (user.getUsername() != null) {
                updatedUser.setUsername(user.getUsername());
            }
            if (user.getFirstName() != null) {
                updatedUser.setFirstName(user.getFirstName());
            }
            if (user.getLastName() != null) {
                updatedUser.setLastName(user.getLastName());
            }
            if (user.getEmail() != null) {
                updatedUser.setEmail(user.getEmail());
            }
            if (user.getPassword() != null) {
                updatedUser.setPassword(user.getPassword());
            }
            if (user.getRoleId() != null) {
                updatedUser.setRoleId(user.getRoleId());
            }
            return new ResponseEntity<>(userService.save(updatedUser), HttpStatus.OK);
    }
}
