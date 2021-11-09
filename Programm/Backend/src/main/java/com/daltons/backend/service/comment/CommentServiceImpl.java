/*
 * Copyright (C) Schweizerische Bundesbahn SBB, 2020
 * Header: ProjektServiceImpl ist zuständig um Daten dem Repository weiterzuleiten.
 * Bis jetzt haben wir die Standart Methoden im Service so wie Save, findall, deleteById, findById, und delete.
 * @Author E517589 Lian Josko Vinkovic & E517403 Livio Alexander Liechti
 */
package com.daltons.backend.service.comment;

import com.daltons.backend.model.Comment;
import com.daltons.backend.model.Post;
import com.daltons.backend.repository.CommentRepository;
import com.daltons.backend.repository.PostRepository;
import com.daltons.backend.service.post.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment save(Comment object) {
        return commentRepository.save(object);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Comment findById(Integer id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Comment object) {
        commentRepository.delete(object);
    }
}
