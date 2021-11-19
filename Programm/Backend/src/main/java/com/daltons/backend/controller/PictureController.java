package com.daltons.backend.controller;

import com.daltons.backend.model.Picture;
import com.daltons.backend.service.picture.PictureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping(value = "/picture")
public class PictureController {
    private final PictureService pictureService;

    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @PostMapping
    public ResponseEntity<Picture> createPicture(@Validated @RequestBody Picture picture) {
        if(pictureService.findById(picture.getPictureId()) != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else {
            Picture newPicture = pictureService.save(picture);
            if (newPicture == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(newPicture, HttpStatus.CREATED);
        }
    }

    @GetMapping
    public ResponseEntity<List<Picture>> getAllPicture() {
        List<Picture> pictureList = pictureService.findAll();
        return new ResponseEntity<>(pictureList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Picture> getPictureById(@PathVariable Integer id) {
        Picture picture = pictureService.findById(id);
        if (picture == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(picture, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePicture(@PathVariable Integer id) {
        Picture picture = pictureService.findById(id);

        if (picture == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        pictureService.delete(picture);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Picture> updateUser(@RequestBody Picture picture, @PathVariable Integer id) {
        Picture updatedPicture = pictureService.findById(id);
            if (picture.getDescription() != null) {
                updatedPicture.setDescription(picture.getDescription());
            }
            if (picture.getUrl() != null) {
                updatedPicture.setUrl(picture.getUrl());
            }
            return new ResponseEntity<>(pictureService.save(updatedPicture), HttpStatus.OK);
    }
}
