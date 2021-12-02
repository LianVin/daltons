package com.daltons.backend;

import com.daltons.backend.controller.*;
import com.daltons.backend.model.Comment;
import com.daltons.backend.model.Picture;
import com.daltons.backend.model.Post;
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
public class PostTest {
	@Autowired
	private PostController postController;
	@Autowired
	private CommentController commentController;
	@Autowired
	private PictureController pictureController;

	@Test
	public void createPost() {
		// PREP
		Post basePost = new Post();
		basePost.setTitle("Test Post");
		basePost.setText("Some Text");
		basePost.setConcert(true);

		// TEST Start
		Post newPost = postController.createPost(basePost).getBody();
		assertEquals(basePost, newPost);

		// DELETE
		postController.deletePost(newPost.getPostId());
	}

	@Test
	public void readPost(){
		// TEST Start
		Post respond = postController.getPostById(1).getBody();
		assertNotNull(respond);
	}

	@Test
	public void updatePost(){
		// PREP
		Post basePost = new Post();
		basePost.setTitle("Test Post");
		basePost.setText("Some Text");
		basePost.setConcert(true);
		Post newPost = postController.createPost(basePost).getBody();

		// TEST Start
		Post updatedPost = postController.getPostById(basePost.getPostId()).getBody();
		assertNotNull(updatedPost);
		updatedPost.setTitle("NEWTITLE");
		Post respond = postController.updatePost(updatedPost, updatedPost.getPostId()).getBody();
		assertEquals(updatedPost.getTitle(), respond.getTitle());

		// DELETE
		postController.deletePost(newPost.getPostId());
	}

	@Test
	public void deletePost() {
		// PREP
		Post basePost = new Post();
		basePost.setTitle("Test Post");
		basePost.setText("Some Text");
		basePost.setConcert(true);
		Post newPost = postController.createPost(basePost).getBody();

		// TEST Start
		assertNotNull(postController.getPostById(newPost.getPostId()));
		postController.deletePost(newPost.getPostId());
		assertNull(postController.getPostById(newPost.getPostId()).getBody());
	}

	@Test
	public void deletePostAndChilds() {
		// PREP
		Post basePost = new Post();
		basePost.setTitle("Test Post");
		basePost.setText("Some Text");
		basePost.setConcert(true);
		Post newPost = postController.createPost(basePost).getBody();

		Comment comment = new Comment();
		comment.setText("Test Comment");
		comment.setPostId(newPost);
		commentController.createComment(comment);

		Picture picture = new Picture();
		picture.setUrl("Test URL");
		picture.setDescription("Test Description");
		picture.setPostId(newPost);
		pictureController.createPicture(picture);

		// TEST Start
		postController.deletePost(newPost.getPostId());
		assertNull(postController.getPostById(newPost.getPostId()).getBody());

	}

}
