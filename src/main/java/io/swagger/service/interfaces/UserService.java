package io.swagger.service.interfaces;

import io.swagger.model.User;

import java.util.List;

public interface UserService
{
    public List<User> getAllUsers();
    public void deleteUser(int id);


}
