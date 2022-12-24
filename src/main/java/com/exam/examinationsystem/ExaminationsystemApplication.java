package com.exam.examinationsystem;

import com.exam.examinationsystem.models.Role;
import com.exam.examinationsystem.models.User;
import com.exam.examinationsystem.models.UserRole;
import com.exam.examinationsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExaminationsystemApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ExaminationsystemApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting Code");

//		User user = new User();
//
//		user.setFirstName("David");
//		user.setLastName("Warner");
//		user.setUsername("david123");
//		user.setPassword(this.bCryptPasswordEncoder.encode("123456"));
//		user.setEmail("david@gmail.com");
//		user.setProfile("default.png");
//
//		Role role = new Role();
//		role.setRoleId(1L);
//		role.setRoleName("ADMIN");
//
//		Set<UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role);
//		userRole.setUser(user);
//
//		userRoleSet.add(userRole);
//
//		User user1 = this.userService.createUser(user, userRoleSet);
//		System.out.println(user1.getUsername());
	}
}
