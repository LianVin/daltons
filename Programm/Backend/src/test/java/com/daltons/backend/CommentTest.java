package com.daltons.backend;

import com.daltons.backend.controller.CommentController;
import com.daltons.backend.controller.PostController;
import com.daltons.backend.controller.UserController;
import com.daltons.backend.model.Comment;
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
public class CommentTest {
	@Autowired
	private PostController postController;
	@Autowired
	private CommentController commentController;
	@Autowired
	private UserController userController;

	@Test
	public void createComment() {
		// PREP
		Comment baseComment = new Comment();
		baseComment.setText("Test Post");
		baseComment.setPostId(postController.getPostById(1).getBody());
		baseComment.setUserId(userController.getUserById(1).getBody());

		// TEST Start
		Comment newComment = commentController.createComment(baseComment).getBody();
		assertEquals(baseComment, newComment);

		// DELETE
		postController.deletePost(newComment.getCommentId());
	}

	@Test
	public void readComment(){
		// TEST Start
		Comment respond = commentController.getCommentById(1).getBody();
		assertNotNull(respond);
	}

	@Test
	public void updateComment(){
		// PREP
		Comment baseComment = new Comment();
		baseComment.setText("Test Post");
		baseComment.setPostId(postController.getPostById(1).getBody());
		baseComment.setUserId(userController.getUserById(1).getBody());
		Comment newComment = commentController.createComment(baseComment).getBody();

		// TEST Start
		Comment updatedComment = commentController.getCommentById(1).getBody();
		assertNotNull(updatedComment);
		updatedComment.setText("NEWTEXT");
		Comment respond = commentController.updateComment(updatedComment, updatedComment.getCommentId()).getBody();
		assertEquals(updatedComment.getText(), respond.getText());

		// DELETE
		postController.deletePost(newComment.getCommentId());
	}

	@Test
	public void deleteComment() {
		// PREP
		Comment baseComment = new Comment();
		baseComment.setText("Test Post");
		baseComment.setPostId(postController.getPostById(1).getBody());
		baseComment.setUserId(userController.getUserById(1).getBody());
		Comment newComment = commentController.createComment(baseComment).getBody();

		// TEST Start
		assertNotNull(commentController.getCommentById(newComment.getCommentId()));
		commentController.deleteComment(newComment.getCommentId());
		assertNull(commentController.getCommentById(newComment.getCommentId()).getBody());
	}

}
