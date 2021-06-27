package io.swagger.service.interfaces;

import io.swagger.model.DTO.UserDTO;
import io.swagger.model.User;

import java.util.List;

public interface UserService
{
    List<User> getAllUsers();
    void deleteUser(long id);
    User editUser(int id, UserDTO user) throws Exception;
    User createUser(UserDTO userDTO) throws Exception;
    User getUserById(long id);



}
