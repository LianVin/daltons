package com.daltons.backend.service.post;

import com.daltons.backend.model.Post;
import com.daltons.backend.model.Role;
import com.daltons.backend.service.CrudService;

import java.util.List;

public interface PostService extends CrudService<Post, Integer> {
    Post save(Post object);
    List<Post> findAll();
    void deleteById(Integer id);
    Post findById(Integer id);
    void delete(Post object);
}
