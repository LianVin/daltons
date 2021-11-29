package com.daltons.backend;

import com.daltons.backend.configuration.AppUser;
import com.daltons.backend.configuration.LoggedInUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@GetMapping("/secured")
	public Object secured(@LoggedInUser AppUser appUser) {
		return appUser;
	}

	@GetMapping("/secured-admin")
	public String securedAdmin() {
		return "Only admin can see this";
	}

	@GetMapping("/public")
	public String pub() {
		return "This is public";
	}
}
