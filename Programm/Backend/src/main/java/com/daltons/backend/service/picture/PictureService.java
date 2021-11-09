package com.daltons.backend.service.picture;

import com.daltons.backend.model.Picture;
import com.daltons.backend.model.Post;
import com.daltons.backend.service.CrudService;

import java.util.List;

public interface PictureService extends CrudService<Picture, Integer> {
    Picture save(Picture object);
    List<Picture> findAll();
    void deleteById(Integer id);
    Picture findById(Integer id);
    void delete(Picture object);
}
