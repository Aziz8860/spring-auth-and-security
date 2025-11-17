package com.belajar.project_jwt.service;

import com.belajar.project_jwt.domain.Role;
import com.belajar.project_jwt.domain.User;
import com.belajar.project_jwt.repository.RoleRepository;
import com.belajar.project_jwt.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    // tanpa @RequiredArgsConstructor:
    //    public UserServiceImpl(UserRepository userRepo, RoleRepository roleRepo) {
    //        this.userRepo = userRepo;
    //        this.roleRepo = roleRepo;
    //    }
    // atau pake @Autowired di tiap private final di atas

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the database", user.getName());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database",  role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
        // userRepository.save(user);  // Needed if not in @Transactional
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}
