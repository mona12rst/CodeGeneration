package io.swagger.api;

import io.swagger.model.Account;
import io.swagger.model.Balance;
import io.swagger.model.DTO.TransactionDTO;
import io.swagger.model.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.service.interfaces.AccountService;
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
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-17T13:48:13.918Z[GMT]")
@RestController
@RequestMapping(value = "accounts")

public class AccountsApiController implements AccountsApi
{

    private static final Logger log = LoggerFactory.getLogger(AccountsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private AccountService accountService;

    @org.springframework.beans.factory.annotation.Autowired
    public AccountsApiController(ObjectMapper objectMapper, HttpServletRequest request)
    {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    // should be done by accounts

    public ResponseEntity<Account> deleteAccount(@Parameter(in = ParameterIn.PATH, description = "Transaction id", required = true, schema = @Schema()) @PathVariable("iban") String iban)
    {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json"))
        {
            try
            {
                return new ResponseEntity<Account>(objectMapper.readValue("{\n  \"accountStatus\" : \"active\",\n  \"IBAN\" : \"NL02ABNA0123456789\",\n  \"absoluteLimit\" : 10.5,\n  \"balance\" : {\n    \"amount\" : 10.5\n  },\n  \"dailyLimit\" : 10.5,\n  \"accountType\" : \"savings\",\n  \"user\" : {\n    \"firstName\" : \"john\",\n    \"lastName\" : \"doe\",\n    \"emailAddress\" : \"john@example.com\",\n    \"Username\" : \"john\",\n    \"UserID\" : 1,\n    \"mobileNumber\" : \"0753846288\",\n    \"sex\" : \"male\",\n    \"dailyLimit\" : 10.5,\n    \"dateOfBirth\" : \"15-01-1996\",\n    \"transactionLimit\" : 10.5,\n    \"primaryAddress\" : {\n      \"country\" : \"country\",\n      \"city\" : \"city\",\n      \"street\" : \"street\",\n      \"houseNumber\" : 0,\n      \"postCode\" : \"postCode\"\n    },\n    \"userRole\" : \"customer\"\n  },\n  \"dateOfOpening\" : \"05-05-2020\"\n}", Account.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e)
            {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Account>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Account>(HttpStatus.NOT_IMPLEMENTED);
    }

    // should be done by transactions

    public ResponseEntity<Transaction> depositMoney(@Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("iban") String iban, @Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody Transaction body)
    {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json"))
        {
            try
            {
                return new ResponseEntity<Transaction>(objectMapper.readValue("{\n  \"TransactionType\" : \"transfer\",\n  \"userPerforming\" : {\n    \"firstName\" : \"john\",\n    \"lastName\" : \"doe\",\n    \"emailAddress\" : \"john@example.com\",\n    \"Username\" : \"john\",\n    \"UserID\" : 1,\n    \"mobileNumber\" : \"0753846288\",\n    \"sex\" : \"male\",\n    \"dailyLimit\" : 10.5,\n    \"dateOfBirth\" : \"15-01-1996\",\n    \"transactionLimit\" : 10.5,\n    \"primaryAddress\" : {\n      \"country\" : \"country\",\n      \"city\" : \"city\",\n      \"street\" : \"street\",\n      \"houseNumber\" : 0,\n      \"postCode\" : \"postCode\"\n    },\n    \"userRole\" : \"customer\"\n  },\n  \"FromIBAN\" : \"NL01ING09874374839\",\n  \"ToIBAN\" : \"NL01ING09874374839\",\n  \"Amount\" : 801.7481,\n  \"Date\" : \"2000-01-23\",\n  \"TransactionID\" : \"TransactionID\"\n}", Transaction.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e)
            {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Transaction>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Transaction>(HttpStatus.NOT_IMPLEMENTED);
    }
    // should be done by accounts

    public ResponseEntity<Account> editAccountByIban(@Parameter(in = ParameterIn.PATH, description = "Transaction id", required = true, schema = @Schema()) @PathVariable("iban") String iban, @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody Account body)
    {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json"))
        {
            try
            {
                return new ResponseEntity<Account>(objectMapper.readValue("{\n  \"accountStatus\" : \"active\",\n  \"IBAN\" : \"NL02ABNA0123456789\",\n  \"absoluteLimit\" : 10.5,\n  \"balance\" : {\n    \"amount\" : 10.5\n  },\n  \"dailyLimit\" : 10.5,\n  \"accountType\" : \"savings\",\n  \"user\" : {\n    \"firstName\" : \"john\",\n    \"lastName\" : \"doe\",\n    \"emailAddress\" : \"john@example.com\",\n    \"Username\" : \"john\",\n    \"UserID\" : 1,\n    \"mobileNumber\" : \"0753846288\",\n    \"sex\" : \"male\",\n    \"dailyLimit\" : 10.5,\n    \"dateOfBirth\" : \"15-01-1996\",\n    \"transactionLimit\" : 10.5,\n    \"primaryAddress\" : {\n      \"country\" : \"country\",\n      \"city\" : \"city\",\n      \"street\" : \"street\",\n      \"houseNumber\" : 0,\n      \"postCode\" : \"postCode\"\n    },\n    \"userRole\" : \"customer\"\n  },\n  \"dateOfOpening\" : \"05-05-2020\"\n}", Account.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e)
            {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Account>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Account>(HttpStatus.NOT_IMPLEMENTED);
    }
    // should be done by accounts

    public ResponseEntity<Balance> getAccountBalance(@Parameter(in = ParameterIn.PATH, description = "iban", required = true, schema = @Schema()) @PathVariable("iban") String iban)
    {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json"))
        {
            try
            {
                return new ResponseEntity<Balance>(objectMapper.readValue("{\n  \"amount\" : 10.5\n}", Balance.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e)
            {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Balance>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Balance>(HttpStatus.NOT_IMPLEMENTED);
    }
    // should be done by accounts

    public ResponseEntity<Account> getAccountByIban(@Parameter(in = ParameterIn.PATH, description = "iban of the selected account", required = true, schema = @Schema()) @PathVariable("iban") Integer iban)
    {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json"))
        {
            try
            {
                return new ResponseEntity<Account>(objectMapper.readValue("{\n  \"accountStatus\" : \"active\",\n  \"IBAN\" : \"NL02ABNA0123456789\",\n  \"absoluteLimit\" : 10.5,\n  \"balance\" : {\n    \"amount\" : 10.5\n  },\n  \"dailyLimit\" : 10.5,\n  \"accountType\" : \"savings\",\n  \"user\" : {\n    \"firstName\" : \"john\",\n    \"lastName\" : \"doe\",\n    \"emailAddress\" : \"john@example.com\",\n    \"Username\" : \"john\",\n    \"UserID\" : 1,\n    \"mobileNumber\" : \"0753846288\",\n    \"sex\" : \"male\",\n    \"dailyLimit\" : 10.5,\n    \"dateOfBirth\" : \"15-01-1996\",\n    \"transactionLimit\" : 10.5,\n    \"primaryAddress\" : {\n      \"country\" : \"country\",\n      \"city\" : \"city\",\n      \"street\" : \"street\",\n      \"houseNumber\" : 0,\n      \"postCode\" : \"postCode\"\n    },\n    \"userRole\" : \"customer\"\n  },\n  \"dateOfOpening\" : \"05-05-2020\"\n}", Account.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e)
            {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Account>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Account>(HttpStatus.NOT_IMPLEMENTED);
    }
    // should be done by accounts or transactions! doesnt really matter!

    public ResponseEntity<Account> getAccountTransactions(@Parameter(in = ParameterIn.PATH, description = "iban", required = true, schema = @Schema()) @PathVariable("iban") String iban, @NotNull @Min(5L) @Max(50L) @Parameter(in = ParameterIn.QUERY, description = "the limit to get number of accounts", required = true, schema = @Schema(allowableValues = {}, minimum = "5", maximum = "50"
    )) @Valid @RequestParam(value = "limit", required = true) Long limit, @Min(0L) @Parameter(in = ParameterIn.QUERY, description = "the offset to start getting accounts", schema = @Schema(allowableValues = {}
    )) @Valid @RequestParam(value = "offset", required = false) Long offset, @Parameter(in = ParameterIn.QUERY, description = "get transactions between two dates", schema = @Schema()) @Valid @RequestParam(value = "betweenDates", required = false) String betweenDates)
    {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json"))
        {
            try
            {
                return new ResponseEntity<Account>(objectMapper.readValue("{\n  \"accountStatus\" : \"active\",\n  \"IBAN\" : \"NL02ABNA0123456789\",\n  \"absoluteLimit\" : 10.5,\n  \"balance\" : {\n    \"amount\" : 10.5\n  },\n  \"dailyLimit\" : 10.5,\n  \"accountType\" : \"savings\",\n  \"user\" : {\n    \"firstName\" : \"john\",\n    \"lastName\" : \"doe\",\n    \"emailAddress\" : \"john@example.com\",\n    \"Username\" : \"john\",\n    \"UserID\" : 1,\n    \"mobileNumber\" : \"0753846288\",\n    \"sex\" : \"male\",\n    \"dailyLimit\" : 10.5,\n    \"dateOfBirth\" : \"15-01-1996\",\n    \"transactionLimit\" : 10.5,\n    \"primaryAddress\" : {\n      \"country\" : \"country\",\n      \"city\" : \"city\",\n      \"street\" : \"street\",\n      \"houseNumber\" : 0,\n      \"postCode\" : \"postCode\"\n    },\n    \"userRole\" : \"customer\"\n  },\n  \"dateOfOpening\" : \"05-05-2020\"\n}", Account.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e)
            {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Account>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Account>(HttpStatus.NOT_IMPLEMENTED);
    }
    // should be done by accounts

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Account>> getAllAccounts(@NotNull @Min(5L) @Max(50L) @Parameter(in = ParameterIn.QUERY, description = "the limit to get number of accounts", required = true, schema = @Schema(allowableValues = {}, minimum = "5", maximum = "50"
    )) @Valid @RequestParam(value = "limit", required = true) Long limit, @Min(0L) @Parameter(in = ParameterIn.QUERY, description = "the offset to start getting accounts", schema = @Schema(allowableValues = {}
    )) @Valid @RequestParam(value = "offset", required = false) Long offset)
    {
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("application/json"))
//        {
//            try
//            {
//                return new ResponseEntity<List<Account>>(objectMapper.readValue("{\n  \"accountStatus\" : \"active\",\n  \"IBAN\" : \"NL02ABNA0123456789\",\n  \"absoluteLimit\" : 10.5,\n  \"balance\" : {\n    \"amount\" : 10.5\n  },\n  \"dailyLimit\" : 10.5,\n  \"accountType\" : \"savings\",\n  \"user\" : {\n    \"firstName\" : \"john\",\n    \"lastName\" : \"doe\",\n    \"emailAddress\" : \"john@example.com\",\n    \"Username\" : \"john\",\n    \"UserID\" : 1,\n    \"mobileNumber\" : \"0753846288\",\n    \"sex\" : \"male\",\n    \"dailyLimit\" : 10.5,\n    \"dateOfBirth\" : \"15-01-1996\",\n    \"transactionLimit\" : 10.5,\n    \"primaryAddress\" : {\n      \"country\" : \"country\",\n      \"city\" : \"city\",\n      \"street\" : \"street\",\n      \"houseNumber\" : 0,\n      \"postCode\" : \"postCode\"\n    },\n    \"userRole\" : \"customer\"\n  },\n  \"dateOfOpening\" : \"05-05-2020\"\n}", Account.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e)
//            {
//                log.error("Couldn't serialize response for content type application/json", e);
//                return new ResponseEntity<Account>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }

        return new ResponseEntity<List<Account>>(accountService.getAllAccounts(),HttpStatus.OK);
    }
    // should be done by transactions

    // TODO: 6/19/2021
    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transaction> withdrawMoney(@Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("iban") String iban, @Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody TransactionDTO body)
    {
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("application/json"))
//        {
//            try
//            {
//                return new ResponseEntity<Transaction>(objectMapper.readValue("{\n  \"TransactionType\" : \"transfer\",\n  \"userPerforming\" : {\n    \"firstName\" : \"john\",\n    \"lastName\" : \"doe\",\n    \"emailAddress\" : \"john@example.com\",\n    \"Username\" : \"john\",\n    \"UserID\" : 1,\n    \"mobileNumber\" : \"0753846288\",\n    \"sex\" : \"male\",\n    \"dailyLimit\" : 10.5,\n    \"dateOfBirth\" : \"15-01-1996\",\n    \"transactionLimit\" : 10.5,\n    \"primaryAddress\" : {\n      \"country\" : \"country\",\n      \"city\" : \"city\",\n      \"street\" : \"street\",\n      \"houseNumber\" : 0,\n      \"postCode\" : \"postCode\"\n    },\n    \"userRole\" : \"customer\"\n  },\n  \"FromIBAN\" : \"NL01ING09874374839\",\n  \"ToIBAN\" : \"NL01ING09874374839\",\n  \"Amount\" : 801.7481,\n  \"Date\" : \"2000-01-23\",\n  \"TransactionID\" : \"TransactionID\"\n}", Transaction.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e)
//            {
//                log.error("Couldn't serialize response for content type application/json", e);
//                return new ResponseEntity<Transaction>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }

        return new ResponseEntity<Transaction>(HttpStatus.NOT_IMPLEMENTED);
    }

}
