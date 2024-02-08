package com.Tech.quiz.UserManagement.config;

import com.Tech.quiz.UserManagement.entity.Role;
import com.Tech.quiz.UserManagement.entity.Roles;
import com.Tech.quiz.UserManagement.entity.User;
import com.Tech.quiz.UserManagement.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@AllArgsConstructor
public class RolesConfig {
    @Bean
    CommandLineRunner comandLinerRunnerRoles(RoleRepository roleRepository) {
        long numberRoles= roleRepository.count();
        List<Roles> roles=new ArrayList<Roles>();

        if(numberRoles<=0)
            return args ->{
                Roles adminRole =new Roles();
                adminRole.setName(Role.ADMIN.name());
                roles.add(adminRole);

                Roles userRole =new Roles();
                userRole.setName(Role.USER.name());
                roles.add(userRole);

                roleRepository.saveAll(roles);

                Roles role=new Roles();
                User user= new User();
                role=roleRepository.findByName("ADMIN").get();

                user.setEmail("Example@email.com");
                user.setFirstName("Admin");
                user.setSecondName("Admin");
                user.setRoles(Collections.singletonList(role));
                user.setPassword( new BCryptPasswordEncoder().encode("Admin"));
            };
        return null;

    }
}
