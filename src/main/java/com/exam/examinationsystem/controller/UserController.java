package com.exam.examinationsystem.controller;

import com.exam.examinationsystem.models.Role;
import com.exam.examinationsystem.models.User;
import com.exam.examinationsystem.models.UserRole;
import com.exam.examinationsystem.service.UserService;
import com.exam.examinationsystem.service.implementations.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    //creating user
    @PostMapping("/add")
    public User createUser(@RequestBody User user) throws Exception {

        user.setProfile("default.png");
        Set<UserRole> roles = new HashSet<>();
        Role role = new Role();
        role.setRoleId(2L);
        role.setRoleName("USER");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);

        return this.userService.createUser(user, roles);
    }

    //view User
    @GetMapping("/view/{username}")
    public User getUser(@PathVariable("username") String username) {
        return this.userService.getUser(username);
    }

    //delete user
    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        this.userService.deleteUser(userId);
    }

    //update user
    @PutMapping("/update")
    public User updateUser(@RequestBody User user) throws Exception {
        return this.userServiceImpl.updateUser(user);
    }
}
