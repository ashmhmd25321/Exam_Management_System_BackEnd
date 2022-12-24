package com.exam.examinationsystem.service;

import com.exam.examinationsystem.models.User;
import com.exam.examinationsystem.models.UserRole;

import java.util.Set;

public interface UserService {

    //creating user
    User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by username
    User getUser(String username);

    //delete user by id
    void deleteUser(Long userId);

    User getUserById(Long userId);
}
