package io.swagger.service.interfaces;

import io.swagger.model.DTO.UserToCreate;
import io.swagger.model.User;

import java.util.List;

public interface UserService
{
    public List<User> getAllUsers();
    public void deleteUser(int id);
    public User editUser(int id, UserToCreate user);
    public User createUser(UserToCreate userToCreate);



}
