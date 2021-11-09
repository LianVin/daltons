package com.daltons.backend.service.comment;

import com.daltons.backend.model.Comment;
import com.daltons.backend.model.Post;
import com.daltons.backend.service.CrudService;

import java.util.List;

public interface CommentService extends CrudService<Comment, Integer> {
    Comment save(Comment object);
    List<Comment> findAll();
    void deleteById(Integer id);
    Comment findById(Integer id);
    void delete(Comment object);
}
