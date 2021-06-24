package io.swagger.service.interfaces;

import io.swagger.model.DTO.UserDTO;
import io.swagger.model.User;

import java.util.List;

public interface UserService
{
    public List<User> getAllUsers();
    public void deleteUser(int id);
    public User editUser(int id, UserDTO user);
    public User createUser(UserDTO userDTO);



}
