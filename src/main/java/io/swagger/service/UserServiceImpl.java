package io.swagger.service;

import io.swagger.model.DTO.UserDTO;
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

    public User editUser(int id, UserDTO user)
    {
        User userToEdit = userRepository.findUserByUserID(id)
                .dailyLimit(user.getDailyLimit())
                .username(user.getUsername())
                .dateOfBirth(user.getDateOfBirth())
                .emailAddress(user.getEmailAddress())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .mobileNumber(user.getMobileNumber())
//                .primaryAddress(user.getPrimaryAddress())
                .transactionLimit(user.getTransactionLimit());
        userRepository.save(userToEdit);
        return userToEdit;


    }

    public User createUser(UserDTO userDTO)
    {
        User user = new User()
                .dailyLimit(userDTO.getDailyLimit())
                .username(userDTO.getUsername())
                .dateOfBirth(userDTO.getDateOfBirth())
                .emailAddress(userDTO.getEmailAddress())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .mobileNumber(userDTO.getMobileNumber())
//                .primaryAddress(userDTO.getPrimaryAddress())
                .transactionLimit(userDTO.getTransactionLimit())
                .userRole(userDTO.getUserRole());
        userRepository.save(user);
        return user;
    }


}
