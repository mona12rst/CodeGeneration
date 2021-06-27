package io.swagger.repository;

import io.swagger.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Integer>
{
    User findUserByUserID(long id);
    void deleteUserByUserID(long id);
    User findUserByUsername(String username);
}
