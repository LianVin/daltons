package com.daltons.backend.repository;

import com.daltons.backend.model.Post;
import com.daltons.backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
