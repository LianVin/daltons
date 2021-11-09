package com.daltons.backend.repository;

import com.daltons.backend.model.Comment;
import com.daltons.backend.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
