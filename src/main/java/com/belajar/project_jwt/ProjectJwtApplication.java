package com.belajar.project_jwt;

import com.belajar.project_jwt.domain.Role;
import com.belajar.project_jwt.domain.User;
import com.belajar.project_jwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class ProjectJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectJwtApplication.class, args);
    }

    @Bean
    PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Atlanta", "atlanta", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Berlin", "berlin", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Centauri", "centauri", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Derby", "derby", "1234", new ArrayList<>()));

            userService.addRoleToUser("atlanta", "ROLE_USER");
            userService.addRoleToUser("atlanta", "ROLE_MANAGER");
            userService.addRoleToUser("berlin", "ROLE_MANAGER");
            userService.addRoleToUser("centauri", "ROLE_ADMIN");
            userService.addRoleToUser("derby", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("derby", "ROLE_ADMIN");
            userService.addRoleToUser("derby", "ROLE_USER");
        };
    }
}
