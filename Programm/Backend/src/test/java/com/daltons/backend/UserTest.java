package com.daltons.backend;

import com.daltons.backend.controller.RoleController;
import com.daltons.backend.controller.UserController;

import static org.junit.Assert.*;

import com.daltons.backend.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendApplication.class)
@ActiveProfiles("test")
public class UserTest {
	@Autowired
	private RoleController roleController;
	@Autowired
	private UserController userController;

	@Test
	public void createUser() {
		// PREP
		User baseUser = new User();
		baseUser.setUsername("Lesmo");
		baseUser.setFirstName("Lian");
		baseUser.setLastName("Vin");
		baseUser.setEmail("lian@vin.ch");
		baseUser.setPassword("abcd123");
		baseUser.setRoleId(roleController.getRoleById(1).getBody());

		// TEST Start
		User newUser = userController.createUser(baseUser).getBody();
		assertEquals(baseUser, newUser);

		// DELETE
		userController.deleteUser(newUser.getUserId());
	}

	@Test
	public void readUser(){
		// PREP
		User baseUser = new User();
		baseUser.setUsername("Lesmo");
		baseUser.setFirstName("Lian");
		baseUser.setLastName("Vin");
		baseUser.setEmail("lian@vin.ch");
		baseUser.setPassword("abcd123");
		baseUser.setRoleId(roleController.getRoleById(1).getBody());
		User newUser = userController.createUser(baseUser).getBody();

		// TEST Start
		User respond = userController.getUserById(newUser.getUserId()).getBody();
		assertNotNull(respond);
		assertEquals(baseUser.getUsername() ,respond.getUsername());

		// DELETE
		userController.deleteUser(newUser.getUserId());
	}

	@Test
	public void updateUser(){
		// PREP
		User baseUser = new User();
		baseUser.setUsername("Lesmo");
		baseUser.setFirstName("Lian");
		baseUser.setLastName("Vin");
		baseUser.setEmail("lian@vin.ch");
		baseUser.setPassword("abcd123");
		baseUser.setRoleId(roleController.getRoleById(1).getBody());
		User newUser = userController.createUser(baseUser).getBody();

		// TEST Start
		User updatedUser = userController.getUserById(newUser.getUserId()).getBody();
		assertNotNull(updatedUser);
		updatedUser.setUsername("NEWUSERNAME");
		User respond = userController.updateUser(updatedUser, updatedUser.getUserId()).getBody();
		assertEquals(updatedUser.getUsername(), respond.getUsername());

		// DELETE
		userController.deleteUser(newUser.getUserId());
	}

	@Test
	public void deleteUser() {
		// PREP
		User baseUser = new User();
		baseUser.setUsername("Lesmo");
		baseUser.setFirstName("Lian");
		baseUser.setLastName("Vin");
		baseUser.setEmail("lian@vin.ch");
		baseUser.setPassword("abcd123");
		baseUser.setRoleId(roleController.getRoleById(1).getBody());
		User newUser = userController.createUser(baseUser).getBody();

		// TEST Start
		assertNotNull(userController.getUserById(newUser.getUserId()));
		userController.deleteUser(newUser.getUserId());
		assertNull(userController.getUserById(newUser.getUserId()).getBody());
	}
}
