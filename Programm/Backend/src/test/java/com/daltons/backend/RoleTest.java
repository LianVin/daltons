package com.daltons.backend;

import com.daltons.backend.controller.RoleController;
import com.daltons.backend.controller.UserController;
import com.daltons.backend.model.Role;
import com.daltons.backend.model.User;
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
public class RoleTest {
	@Autowired
	private RoleController roleController;
	@Autowired
	private UserController userController;

	@Test
	public void createRole() {
		// PREP
		Role baseRole = new Role();
		baseRole.setRole("testRole");

		// TEST Start
		Role newRole = roleController.createRole(baseRole).getBody();
		assertEquals(baseRole, newRole);

		// DELETE
		roleController.deleteRole(newRole.getRoleId());
	}

	@Test
	public void readRole(){
		// PREP
		Role baseRole = new Role();
		baseRole.setRole("testRole");
		Role newRole = roleController.createRole(baseRole).getBody();

		// TEST Start
		Role respond = roleController.getRoleById(newRole.getRoleId()).getBody();
		assertNotNull(respond);
		assertEquals(baseRole.getRole() ,respond.getRole());

		// DELETE
		roleController.deleteRole(newRole.getRoleId());
	}

	@Test
	public void updateRole(){
		// PREP
		Role baseRole = new Role();
		baseRole.setRole("testRole");
		Role newRole = roleController.createRole(baseRole).getBody();

		// TEST Start
		Role updatedRole = roleController.getRoleById(newRole.getRoleId()).getBody();
		assertNotNull(updatedRole);
		updatedRole.setRole("NEWADMIN");
		Role respond = roleController.updateRole(updatedRole, updatedRole.getRoleId()).getBody();
		assertEquals(updatedRole.getRole(), respond.getRole());

		// DELETE
		roleController.deleteRole(newRole.getRoleId());
	}

	@Test
	public void deleteRole() {
		// PREP
		Role baseRole = new Role();
		baseRole.setRole("testRole");
		Role newRole = roleController.createRole(baseRole).getBody();

		// TEST Start
		assertNotNull(roleController.getRoleById(newRole.getRoleId()));
		roleController.deleteRole(newRole.getRoleId());
		assertNull(roleController.getRoleById(newRole.getRoleId()).getBody());
	}

	@Test
	public void deleteRoleAndChilds() {
		// PREP
		Role baseRole = new Role();
		baseRole.setRole("testRole");
		Role newRole = roleController.createRole(baseRole).getBody();

		User baseUser = new User();
		baseUser.setUsername("Lesmo");
		baseUser.setFirstName("Lian");
		baseUser.setLastName("Vin");
		baseUser.setEmail("lian@vin.ch");
		baseUser.setPassword("abcd123");
		baseUser.setRoleId(newRole);
		User newUser = userController.createUser(baseUser).getBody();

		// TEST Start
		roleController.deleteRole(newRole.getRoleId());
		userController.deleteUser(newUser.getUserId());
		assertNull(roleController.getRoleById(newRole.getRoleId()).getBody());

	}
}
