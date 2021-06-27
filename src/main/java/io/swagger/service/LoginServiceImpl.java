package io.swagger.service;


import io.swagger.model.User;
import io.swagger.model.enums.UserRoleEnum;
import io.swagger.repository.UserRepository;
import io.swagger.security.JwtTokenProvider;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Log
public class LoginServiceImpl
{
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtTokenProvider jwtTokenProvider;


    public String add(String username, String password, List<UserRoleEnum> roles) throws Exception
    {
        if(userRepository.findUserByUsername(username) == null)
        {
            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder().encode(password));

            if(roles.size() == 0)
            {
                user.setUserRoles(List.of(UserRoleEnum.ROLE_CUSTOMER));
            }
            else
            {
                user.setUserRoles(roles);

            }
            log.info(user.toString());
            userRepository.save(user);
            return jwtTokenProvider.createToken(user.getUsername(), user.getUserRoles());
        }

        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "username already in use");
    }


    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder(12);
    }
}
