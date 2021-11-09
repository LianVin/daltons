package com.daltons.backend.repository;

import com.daltons.backend.model.Picture;
import com.daltons.backend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {
}
