package com.belajar.project_jwt.service;

import com.belajar.project_jwt.domain.Role;
import com.belajar.project_jwt.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
