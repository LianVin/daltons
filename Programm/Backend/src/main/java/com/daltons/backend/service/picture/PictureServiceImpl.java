/*
 * Copyright (C) Schweizerische Bundesbahn SBB, 2020
 * Header: ProjektServiceImpl ist zuständig um Daten dem Repository weiterzuleiten.
 * Bis jetzt haben wir die Standart Methoden im Service so wie Save, findall, deleteById, findById, und delete.
 * @Author E517589 Lian Josko Vinkovic & E517403 Livio Alexander Liechti
 */
package com.daltons.backend.service.picture;

import com.daltons.backend.model.Picture;
import com.daltons.backend.model.Post;
import com.daltons.backend.repository.PictureRepository;
import com.daltons.backend.repository.PostRepository;
import com.daltons.backend.service.post.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public Picture save(Picture object) {
        return pictureRepository.save(object);
    }

    @Override
    public List<Picture> findAll() {
        return pictureRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        pictureRepository.deleteById(id);
    }

    @Override
    public Picture findById(Integer id) {
        return pictureRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Picture object) {
        pictureRepository.delete(object);
    }
}
