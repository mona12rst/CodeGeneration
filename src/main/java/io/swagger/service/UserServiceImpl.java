package io.swagger.service;

import io.swagger.model.User;
import io.swagger.repository.UserRepository;
import io.swagger.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers()
    {
        return (List<User>) userRepository.findAll();
    }

    public void deleteUser(int id)
    {
        userRepository.deleteById(id);

    }



}
