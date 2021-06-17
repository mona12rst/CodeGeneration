package io.swagger.api;

import io.swagger.model.Account;
import io.swagger.model.User;
import io.swagger.model.DTO.UserToCreate;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-17T13:48:13.918Z[GMT]")
@RestController
public class UsersApiController implements UsersApi {

    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<User> createUser(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody UserToCreate body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<User>(objectMapper.readValue("{\n  \"firstName\" : \"john\",\n  \"lastName\" : \"doe\",\n  \"emailAddress\" : \"john@example.com\",\n  \"Username\" : \"john\",\n  \"UserID\" : 1,\n  \"mobileNumber\" : \"0753846288\",\n  \"sex\" : \"male\",\n  \"dailyLimit\" : 10.5,\n  \"dateOfBirth\" : \"15-01-1996\",\n  \"transactionLimit\" : 10.5,\n  \"primaryAddress\" : {\n    \"country\" : \"country\",\n    \"city\" : \"city\",\n    \"street\" : \"street\",\n    \"houseNumber\" : 0,\n    \"postCode\" : \"postCode\"\n  },\n  \"userRole\" : \"customer\"\n}", User.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteUser(@Parameter(in = ParameterIn.PATH, description = "Enter userId to fetch the user detail", required=true, schema=@Schema()) @PathVariable("userId") Integer userId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> editUser(@Parameter(in = ParameterIn.PATH, description = "Enter userId to fetch the user detail", required=true, schema=@Schema()) @PathVariable("userId") Integer userId,@Parameter(in = ParameterIn.DEFAULT, description = "the user to be edited", required=true, schema=@Schema()) @Valid @RequestBody UserToCreate body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Account>> getUserAccounts(@Parameter(in = ParameterIn.PATH, description = "Enter userId to fetch the user detail", required=true, schema=@Schema()) @PathVariable("userId") Integer userId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Account>>(objectMapper.readValue("[ {\n  \"accountStatus\" : \"active\",\n  \"IBAN\" : \"NL02ABNA0123456789\",\n  \"absoluteLimit\" : 10.5,\n  \"balance\" : {\n    \"amount\" : 10.5\n  },\n  \"dailyLimit\" : 10.5,\n  \"accountType\" : \"savings\",\n  \"user\" : {\n    \"firstName\" : \"john\",\n    \"lastName\" : \"doe\",\n    \"emailAddress\" : \"john@example.com\",\n    \"Username\" : \"john\",\n    \"UserID\" : 1,\n    \"mobileNumber\" : \"0753846288\",\n    \"sex\" : \"male\",\n    \"dailyLimit\" : 10.5,\n    \"dateOfBirth\" : \"15-01-1996\",\n    \"transactionLimit\" : 10.5,\n    \"primaryAddress\" : {\n      \"country\" : \"country\",\n      \"city\" : \"city\",\n      \"street\" : \"street\",\n      \"houseNumber\" : 0,\n      \"postCode\" : \"postCode\"\n    },\n    \"userRole\" : \"customer\"\n  },\n  \"dateOfOpening\" : \"05-05-2020\"\n}, {\n  \"accountStatus\" : \"active\",\n  \"IBAN\" : \"NL02ABNA0123456789\",\n  \"absoluteLimit\" : 10.5,\n  \"balance\" : {\n    \"amount\" : 10.5\n  },\n  \"dailyLimit\" : 10.5,\n  \"accountType\" : \"savings\",\n  \"user\" : {\n    \"firstName\" : \"john\",\n    \"lastName\" : \"doe\",\n    \"emailAddress\" : \"john@example.com\",\n    \"Username\" : \"john\",\n    \"UserID\" : 1,\n    \"mobileNumber\" : \"0753846288\",\n    \"sex\" : \"male\",\n    \"dailyLimit\" : 10.5,\n    \"dateOfBirth\" : \"15-01-1996\",\n    \"transactionLimit\" : 10.5,\n    \"primaryAddress\" : {\n      \"country\" : \"country\",\n      \"city\" : \"city\",\n      \"street\" : \"street\",\n      \"houseNumber\" : 0,\n      \"postCode\" : \"postCode\"\n    },\n    \"userRole\" : \"customer\"\n  },\n  \"dateOfOpening\" : \"05-05-2020\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Account>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Account>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<User>> getUsers(@NotNull @Min(20L) @Max(50L) @Parameter(in = ParameterIn.QUERY, description = "the limit to get number of users" ,required=true,schema=@Schema(allowableValues={  }, minimum="20", maximum="50"
)) @Valid @RequestParam(value = "limit", required = true) Long limit,@Parameter(in = ParameterIn.QUERY, description = "the user name to be searched" ,schema=@Schema()) @Valid @RequestParam(value = "lastName", required = false) String lastName,@Min(1L)@Parameter(in = ParameterIn.QUERY, description = "the userId to be fetched" ,schema=@Schema(allowableValues={  }, minimum="1"
)) @Valid @RequestParam(value = "userId", required = false) Long userId,@Min(0L)@Parameter(in = ParameterIn.QUERY, description = "the offset to start getting users" ,schema=@Schema(allowableValues={  }
)) @Valid @RequestParam(value = "offset", required = false) Long offset) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<User>>(objectMapper.readValue("[ {\n  \"firstName\" : \"john\",\n  \"lastName\" : \"doe\",\n  \"emailAddress\" : \"john@example.com\",\n  \"Username\" : \"john\",\n  \"UserID\" : 1,\n  \"mobileNumber\" : \"0753846288\",\n  \"sex\" : \"male\",\n  \"dailyLimit\" : 10.5,\n  \"dateOfBirth\" : \"15-01-1996\",\n  \"transactionLimit\" : 10.5,\n  \"primaryAddress\" : {\n    \"country\" : \"country\",\n    \"city\" : \"city\",\n    \"street\" : \"street\",\n    \"houseNumber\" : 0,\n    \"postCode\" : \"postCode\"\n  },\n  \"userRole\" : \"customer\"\n}, {\n  \"firstName\" : \"john\",\n  \"lastName\" : \"doe\",\n  \"emailAddress\" : \"john@example.com\",\n  \"Username\" : \"john\",\n  \"UserID\" : 1,\n  \"mobileNumber\" : \"0753846288\",\n  \"sex\" : \"male\",\n  \"dailyLimit\" : 10.5,\n  \"dateOfBirth\" : \"15-01-1996\",\n  \"transactionLimit\" : 10.5,\n  \"primaryAddress\" : {\n    \"country\" : \"country\",\n    \"city\" : \"city\",\n    \"street\" : \"street\",\n    \"houseNumber\" : 0,\n    \"postCode\" : \"postCode\"\n  },\n  \"userRole\" : \"customer\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<User>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
