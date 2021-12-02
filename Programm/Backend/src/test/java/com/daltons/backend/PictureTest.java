package com.daltons.backend;

import com.daltons.backend.controller.PictureController;
import com.daltons.backend.controller.PostController;
import com.daltons.backend.model.Picture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendApplication.class)
@ActiveProfiles("test")
public class PictureTest {
	@Autowired
	private PostController postController;
	@Autowired
	private PictureController pictureController;

	@Test
	public void createPicture() {
		// PREP
		Picture basePicture = new Picture();
		basePicture.setDescription("Test Description");
		basePicture.setUrl("testFolder/testURL");
		basePicture.setPostId(postController.getPostById(1).getBody());

		// TEST Start
		Picture newPicture = pictureController.createPicture(basePicture).getBody();
		assertEquals(basePicture, newPicture);

		// DELETE
		pictureController.deletePicture(newPicture.getPictureId());
	}

	@Test
	public void readPicture(){
		// TEST Start
		Picture respond = pictureController.getPictureById(1).getBody();
		assertNotNull(respond);
	}

	@Test
	public void updatePicture(){
		// PREP
		Picture basePicture = new Picture();
		basePicture.setDescription("Test Description");
		basePicture.setUrl("testFolder/testURL");
		basePicture.setPostId(postController.getPostById(1).getBody());
		Picture newPicture = pictureController.createPicture(basePicture).getBody();

		// TEST Start
		Picture updatedPicture = pictureController.getPictureById(1).getBody();
		assertNotNull(updatedPicture);
		updatedPicture.setUrl("newTestFolder/newTestURL");
		Picture respond = pictureController.updatePicture(updatedPicture, updatedPicture.getPictureId()).getBody();
		assertEquals(updatedPicture.getUrl(), respond.getUrl());

		// DELETE
		pictureController.deletePicture(newPicture.getPictureId());
	}

	@Test
	public void deletePicture() {
		// PREP
		Picture basePicture = new Picture();
		basePicture.setDescription("Test Description");
		basePicture.setUrl("testFolder/testURL");
		basePicture.setPostId(postController.getPostById(1).getBody());
		Picture newPicture = pictureController.createPicture(basePicture).getBody();

		// TEST Start
		assertNotNull(pictureController.getPictureById(newPicture.getPictureId()));
		pictureController.deletePicture(newPicture.getPictureId());
		assertNull(pictureController.getPictureById(newPicture.getPictureId()).getBody());
	}

}
