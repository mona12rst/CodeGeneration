package io.swagger.api;

import io.swagger.model.Transaction;
import io.swagger.model.DTO.TransactionDTO;
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
public class TransactionsApiController implements TransactionsApi {

    private static final Logger log = LoggerFactory.getLogger(TransactionsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TransactionsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Transaction>> getTransactionByIban(@Parameter(in = ParameterIn.PATH, description = "Returns all from/to transaction for this iban", required=true, schema=@Schema()) @PathVariable("iban") Integer iban) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Transaction>>(objectMapper.readValue("[ {\n  \"TransactionType\" : \"transfer\",\n  \"userPerforming\" : {\n    \"firstName\" : \"john\",\n    \"lastName\" : \"doe\",\n    \"emailAddress\" : \"john@example.com\",\n    \"Username\" : \"john\",\n    \"UserID\" : 1,\n    \"mobileNumber\" : \"0753846288\",\n    \"sex\" : \"male\",\n    \"dailyLimit\" : 10.5,\n    \"dateOfBirth\" : \"15-01-1996\",\n    \"transactionLimit\" : 10.5,\n    \"primaryAddress\" : {\n      \"country\" : \"country\",\n      \"city\" : \"city\",\n      \"street\" : \"street\",\n      \"houseNumber\" : 0,\n      \"postCode\" : \"postCode\"\n    },\n    \"userRole\" : \"customer\"\n  },\n  \"FromIBAN\" : \"NL01ING09874374839\",\n  \"ToIBAN\" : \"NL01ING09874374839\",\n  \"Amount\" : 801.7481,\n  \"Date\" : \"2000-01-23\",\n  \"TransactionID\" : \"TransactionID\"\n}, {\n  \"TransactionType\" : \"transfer\",\n  \"userPerforming\" : {\n    \"firstName\" : \"john\",\n    \"lastName\" : \"doe\",\n    \"emailAddress\" : \"john@example.com\",\n    \"Username\" : \"john\",\n    \"UserID\" : 1,\n    \"mobileNumber\" : \"0753846288\",\n    \"sex\" : \"male\",\n    \"dailyLimit\" : 10.5,\n    \"dateOfBirth\" : \"15-01-1996\",\n    \"transactionLimit\" : 10.5,\n    \"primaryAddress\" : {\n      \"country\" : \"country\",\n      \"city\" : \"city\",\n      \"street\" : \"street\",\n      \"houseNumber\" : 0,\n      \"postCode\" : \"postCode\"\n    },\n    \"userRole\" : \"customer\"\n  },\n  \"FromIBAN\" : \"NL01ING09874374839\",\n  \"ToIBAN\" : \"NL01ING09874374839\",\n  \"Amount\" : 801.7481,\n  \"Date\" : \"2000-01-23\",\n  \"TransactionID\" : \"TransactionID\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Transaction>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Transaction>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Transaction> getTransactionByUserId(@Parameter(in = ParameterIn.PATH, description = "Transaction id", required=true, schema=@Schema()) @PathVariable("userId") Integer userId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Transaction>(objectMapper.readValue("{\n  \"TransactionType\" : \"transfer\",\n  \"userPerforming\" : {\n    \"firstName\" : \"john\",\n    \"lastName\" : \"doe\",\n    \"emailAddress\" : \"john@example.com\",\n    \"Username\" : \"john\",\n    \"UserID\" : 1,\n    \"mobileNumber\" : \"0753846288\",\n    \"sex\" : \"male\",\n    \"dailyLimit\" : 10.5,\n    \"dateOfBirth\" : \"15-01-1996\",\n    \"transactionLimit\" : 10.5,\n    \"primaryAddress\" : {\n      \"country\" : \"country\",\n      \"city\" : \"city\",\n      \"street\" : \"street\",\n      \"houseNumber\" : 0,\n      \"postCode\" : \"postCode\"\n    },\n    \"userRole\" : \"customer\"\n  },\n  \"FromIBAN\" : \"NL01ING09874374839\",\n  \"ToIBAN\" : \"NL01ING09874374839\",\n  \"Amount\" : 801.7481,\n  \"Date\" : \"2000-01-23\",\n  \"TransactionID\" : \"TransactionID\"\n}", Transaction.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Transaction>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Transaction>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Transaction> getTransactions(@NotNull @Min(5L) @Max(50L) @Parameter(in = ParameterIn.QUERY, description = "the limit to get number of transactions" ,required=true,schema=@Schema(allowableValues={  }, minimum="5", maximum="50"
)) @Valid @RequestParam(value = "limit", required = true) Long limit,@Min(5L) @Max(50L) @Parameter(in = ParameterIn.QUERY, description = "gets a specific transaction by id" ,schema=@Schema(allowableValues={  }, minimum="5", maximum="50"
)) @Valid @RequestParam(value = "transactionID", required = false) Long transactionID,@Min(0L)@Parameter(in = ParameterIn.QUERY, description = "the offset to start getting users" ,schema=@Schema(allowableValues={  }
)) @Valid @RequestParam(value = "offset", required = false) Long offset,@Parameter(in = ParameterIn.QUERY, description = "get transactions for the specific day" ,schema=@Schema()) @Valid @RequestParam(value = "day", required = false) String day,@Parameter(in = ParameterIn.QUERY, description = "get transactions between two dates" ,schema=@Schema()) @Valid @RequestParam(value = "betweenDates", required = false) String betweenDates,@Parameter(in = ParameterIn.QUERY, description = "the from iban to get the transactions for" ,schema=@Schema()) @Valid @RequestParam(value = "fromIban", required = false) String fromIban,@Parameter(in = ParameterIn.QUERY, description = "the to iban to get the transactions for" ,schema=@Schema()) @Valid @RequestParam(value = "toIban", required = false) String toIban) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Transaction>(objectMapper.readValue("{\n  \"TransactionType\" : \"transfer\",\n  \"userPerforming\" : {\n    \"firstName\" : \"john\",\n    \"lastName\" : \"doe\",\n    \"emailAddress\" : \"john@example.com\",\n    \"Username\" : \"john\",\n    \"UserID\" : 1,\n    \"mobileNumber\" : \"0753846288\",\n    \"sex\" : \"male\",\n    \"dailyLimit\" : 10.5,\n    \"dateOfBirth\" : \"15-01-1996\",\n    \"transactionLimit\" : 10.5,\n    \"primaryAddress\" : {\n      \"country\" : \"country\",\n      \"city\" : \"city\",\n      \"street\" : \"street\",\n      \"houseNumber\" : 0,\n      \"postCode\" : \"postCode\"\n    },\n    \"userRole\" : \"customer\"\n  },\n  \"FromIBAN\" : \"NL01ING09874374839\",\n  \"ToIBAN\" : \"NL01ING09874374839\",\n  \"Amount\" : 801.7481,\n  \"Date\" : \"2000-01-23\",\n  \"TransactionID\" : \"TransactionID\"\n}", Transaction.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Transaction>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Transaction>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Transaction> transferMoney(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody TransactionDTO body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Transaction>(objectMapper.readValue("{\n  \"TransactionType\" : \"transfer\",\n  \"userPerforming\" : {\n    \"firstName\" : \"john\",\n    \"lastName\" : \"doe\",\n    \"emailAddress\" : \"john@example.com\",\n    \"Username\" : \"john\",\n    \"UserID\" : 1,\n    \"mobileNumber\" : \"0753846288\",\n    \"sex\" : \"male\",\n    \"dailyLimit\" : 10.5,\n    \"dateOfBirth\" : \"15-01-1996\",\n    \"transactionLimit\" : 10.5,\n    \"primaryAddress\" : {\n      \"country\" : \"country\",\n      \"city\" : \"city\",\n      \"street\" : \"street\",\n      \"houseNumber\" : 0,\n      \"postCode\" : \"postCode\"\n    },\n    \"userRole\" : \"customer\"\n  },\n  \"FromIBAN\" : \"NL01ING09874374839\",\n  \"ToIBAN\" : \"NL01ING09874374839\",\n  \"Amount\" : 801.7481,\n  \"Date\" : \"2000-01-23\",\n  \"TransactionID\" : \"TransactionID\"\n}", Transaction.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Transaction>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Transaction>(HttpStatus.NOT_IMPLEMENTED);
    }

}
