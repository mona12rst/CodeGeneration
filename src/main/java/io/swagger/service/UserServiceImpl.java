package io.swagger.service;

import io.swagger.exception.InvalidUserDetailsException;
import io.swagger.model.DTO.UserDTO;
import io.swagger.model.User;
import io.swagger.model.enums.UserRoleEnum;
import io.swagger.model.errorDTO.ErroredUser;
import io.swagger.repository.UserRepository;
import io.swagger.security.JwtTokenProvider;
import io.swagger.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;
    private String errorCause;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    public List<User> getAllUsers()
    {
        return (List<User>) userRepository.findAll();
    }

    public void deleteUser(long id)
    {
        userRepository.deleteUserByUserID(id);

    }

    public User editUser(int id, UserDTO user) throws Exception
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

    public User createUser(UserDTO userDTO) throws Exception
    {
        if(validFields(userDTO))
        {
            User user = convertUserDto(userDTO);
            userRepository.save(user);
            jwtTokenProvider.createToken(user.getUsername(), user.getUserRoles());
            return user;
        }

        return ErroredUser.builder().cause(errorCause).build();

    }

    public String login(String username, String password)
    {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, userRepository.findUserByUsername(username).getUserRoles());
        }
        catch (AuthenticationException ae)
        {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "invalid credentials");
        }
    }
//    @Bean
//    public PasswordEncoder passwordEncoder()
//    {
//        return new BCryptPasswordEncoder(12);
//    }


    public User getUserById(long id)
    {
        return userRepository.findUserByUserID(id);
    }
    private boolean validFields(UserDTO userDTO)
    {
        try
        {
            if (userDTO.getDailyLimit() <= 0)
            {
                errorCause += "daily limit cant be zero. ";
                throw new InvalidUserDetailsException("daily limit cant be zero.");
            }
            if (userDTO.getUserRoles() == null)
            {
                errorCause += "user role cant be null ";
                throw new InvalidUserDetailsException("user role cant be null");
            }
            if (userDTO.getUsername() == null)
            {
                errorCause += "user role cant be null ";
                throw new InvalidUserDetailsException("user role cant be null");
            }
            if (userDTO.getFirstName() == null)
            {
                errorCause += "first name cant be null";
                throw new InvalidUserDetailsException("first name cant be null");
            }
            if (userDTO.getLastName() == null)
            {
                errorCause += "last name cant be null";
                throw new InvalidUserDetailsException("last name cant be null");
            }
            if (userDTO.getTransactionLimit() <= 0)
            {
                errorCause += "transaction limit cant be zero or minus ";
                throw new InvalidUserDetailsException("transaction limit cant be zero or minus");
            }
        }
        catch (InvalidUserDetailsException iue)
        {
            System.out.println(iue.getMessage());
            return false;
        }
        return true;

    }
    private User convertUserDto(UserDTO userDTO) throws Exception
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
                .userRole(userDTO.getUserRoles());
        return user;
    }



}
