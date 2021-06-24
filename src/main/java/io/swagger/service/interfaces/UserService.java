package io.swagger.service.interfaces;

import io.swagger.model.DTO.UserDTO;
import io.swagger.model.User;

import java.util.List;

public interface UserService
{
    List<User> getAllUsers();
    void deleteUser(int id);
    User editUser(int id, UserDTO user);
    User createUser(UserDTO userDTO);
    User getUserById(long id);



}
