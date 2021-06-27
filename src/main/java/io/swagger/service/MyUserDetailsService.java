package io.swagger.service;

import io.swagger.model.User;
import io.swagger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService
{

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        final User user = userRepository.findUserByUsername(username);
        if(user == null)
        {
            throw new UsernameNotFoundException(String.format("User: %s not found", username));
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(user.getPassword())
                .authorities(user.getUserRoles())
                .accountExpired(false)
                .credentialsExpired(false)
                .accountLocked(false)
                .disabled(false)
                .build();

    }
}
