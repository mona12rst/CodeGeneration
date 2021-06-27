package io.swagger.api;

import io.swagger.model.Transaction;
import io.swagger.model.DTO.TransactionDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.service.interfaces.TransactionService;
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

import javax.annotation.Generated;
import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-17T13:48:13.918Z[GMT]")
@RestController

@RequestMapping(value = "transactions")
public class TransactionsApiController implements TransactionsApi
{

    private static final Logger log = LoggerFactory.getLogger(TransactionsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private TransactionService transactionService;

    @org.springframework.beans.factory.annotation.Autowired
    public TransactionsApiController(ObjectMapper objectMapper, HttpServletRequest request)
    {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    // fabio
    @RequestMapping(value = "/{iban}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Transaction>> getTransactionByIban(@Parameter(in = ParameterIn.PATH, description = "Returns all from/to transaction for this iban", required = true, schema = @Schema()) @PathVariable("iban") String iban)
    {


        return ResponseEntity.status(200)
                .body(transactionService.getAllTransactionsForIban(iban));
    }

    // fabio
    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Transaction>> getTransactionByUserId(@Parameter(in = ParameterIn.PATH, description = "Transaction id", required = true, schema = @Schema()) @PathVariable("userId") Integer userId)
    {


        return ResponseEntity.status(200)
                .body(transactionService.getTransactionsForUser(userId));
    }



    // mona
    @RequestMapping(value = "",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transaction> transferMoney(@Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody TransactionDTO transactionDTO) throws Exception
    {

        return ResponseEntity.status(201).body(transactionService.transferMoney(transactionDTO));

    }

}
