package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.DTO.UserDTO;
import io.swagger.model.User;
import io.swagger.service.interfaces.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-17T13:48:13.918Z[GMT]")
@RestController
@RequestMapping(value = "users")
public class UsersApiController implements UsersApi
{
    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    @Autowired
    private UserService userService;

    @Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request)
    {
        this.objectMapper = objectMapper;
        this.request = request;
    }


    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody UserDTO userToEdit) throws Exception
    {

        return ResponseEntity.status(201)
                .body(userService.createUser(userToEdit));

    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@Parameter(in = ParameterIn.PATH, description = "Enter userId to fetch the user detail", required = true, schema = @Schema()) @PathVariable("userId") long userId)
    {
        // TODO: 6/17/2021 do some fucking error handling
        // TODO: 6/17/2021 dont use fucking profanity 
        userService.deleteUser(userId);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> editUser(@Parameter(in = ParameterIn.PATH, description = "Enter userId to fetch the user detail", required = true, schema = @Schema()) @PathVariable("userId") Integer userId, @Parameter(in = ParameterIn.DEFAULT, description = "the user to be edited", required = true, schema = @Schema()) @Valid @RequestBody UserDTO userToEdit) throws Exception
    {

        return ResponseEntity.status(201)
                .body(userService.editUser(userId, userToEdit));


    }

//    public ResponseEntity<List<Account>> getUserAccounts(@Parameter(in = ParameterIn.PATH, description = "Enter userId to fetch the user detail", required = true, schema = @Schema()) @PathVariable("userId") Integer userId)
//    {
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("application/json"))
//        {
//            try
//            {
//                return new ResponseEntity<List<Account>>(objectMapper.readValue("[ {\n  \"accountStatus\" : \"active\",\n  \"IBAN\" : \"NL02ABNA0123456789\",\n  \"absoluteLimit\" : 10.5,\n  \"balance\" : {\n    \"amount\" : 10.5\n  },\n  \"dailyLimit\" : 10.5,\n  \"accountType\" : \"savings\",\n  \"user\" : {\n    \"firstName\" : \"john\",\n    \"lastName\" : \"doe\",\n    \"emailAddress\" : \"john@example.com\",\n    \"Username\" : \"john\",\n    \"UserID\" : 1,\n    \"mobileNumber\" : \"0753846288\",\n    \"sex\" : \"male\",\n    \"dailyLimit\" : 10.5,\n    \"dateOfBirth\" : \"15-01-1996\",\n    \"transactionLimit\" : 10.5,\n    \"primaryAddress\" : {\n      \"country\" : \"country\",\n      \"city\" : \"city\",\n      \"street\" : \"street\",\n      \"houseNumber\" : 0,\n      \"postCode\" : \"postCode\"\n    },\n    \"userRole\" : \"customer\"\n  },\n  \"dateOfOpening\" : \"05-05-2020\"\n}, {\n  \"accountStatus\" : \"active\",\n  \"IBAN\" : \"NL02ABNA0123456789\",\n  \"absoluteLimit\" : 10.5,\n  \"balance\" : {\n    \"amount\" : 10.5\n  },\n  \"dailyLimit\" : 10.5,\n  \"accountType\" : \"savings\",\n  \"user\" : {\n    \"firstName\" : \"john\",\n    \"lastName\" : \"doe\",\n    \"emailAddress\" : \"john@example.com\",\n    \"Username\" : \"john\",\n    \"UserID\" : 1,\n    \"mobileNumber\" : \"0753846288\",\n    \"sex\" : \"male\",\n    \"dailyLimit\" : 10.5,\n    \"dateOfBirth\" : \"15-01-1996\",\n    \"transactionLimit\" : 10.5,\n    \"primaryAddress\" : {\n      \"country\" : \"country\",\n      \"city\" : \"city\",\n      \"street\" : \"street\",\n      \"houseNumber\" : 0,\n      \"postCode\" : \"postCode\"\n    },\n    \"userRole\" : \"customer\"\n  },\n  \"dateOfOpening\" : \"05-05-2020\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e)
//            {
//                log.error("Couldn't serialize response for content type application/json", e);
//                return new ResponseEntity<List<Account>>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }
//
//        return new ResponseEntity<List<Account>>(HttpStatus.NOT_IMPLEMENTED);
//    }


    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUsers()
    {
//        String accept = request.getHeader("Accept");
        return ResponseEntity.status(200)
                .body(userService.getAllUsers());
    }

}
