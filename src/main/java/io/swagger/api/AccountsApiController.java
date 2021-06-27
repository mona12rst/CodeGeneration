package io.swagger.api;

import io.swagger.exception.IncorrectIBANException;
import io.swagger.exception.InvalidAccountException;
import io.swagger.model.Account;
import io.swagger.model.Balance;
import io.swagger.model.DTO.AccountDTO;
import io.swagger.model.errorDTO.ErroredTransaction;
import io.swagger.model.DTO.TransactionDTO;
import io.swagger.model.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.service.interfaces.AccountService;
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
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private TransactionService transactionService;

    @Autowired
    public AccountsApiController(ObjectMapper objectMapper, HttpServletRequest request)
    {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    // should be done by accounts
    // TODO: 6/24/2021 security and error handling

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> createAccount(@Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody AccountDTO accountDTO) throws Exception
    {
        return ResponseEntity.status(201)
                .body(accountService.createAccount(accountDTO));
    }

    @RequestMapping(value = "/{iban}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> deleteAccount(@Parameter(in = ParameterIn.PATH, description = "iban", required = true, schema = @Schema()) @PathVariable("iban") String iban)
    {

        return new ResponseEntity<Account>(HttpStatus.NO_CONTENT);

//        int rows = accountService.deleteAccountByIban(iban);
//        if (rows == 1)
//        {
//        return new ResponseEntity<Account>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<Account>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // should be done by transactions
    @RequestMapping(value = "/{iban}/deposit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transaction> depositMoney(@Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("iban") String iban, @Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody TransactionDTO transactionDTO) throws Exception
    {
        return ResponseEntity.status(201)
                .body(transactionService.depositMoney(iban, transactionDTO));
    }

    // should be done by accounts
    @RequestMapping(value = "/{iban}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> editAccountByIban(@Parameter(in = ParameterIn.PATH, description = "Transaction id", required = true, schema = @Schema()) @PathVariable("iban") String iban, @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody AccountDTO accountDTO) throws Exception
    {

        return ResponseEntity.status(201)
                .body(accountService.editAccountByAccountByIban(iban, accountDTO));

    }

    // should be done by accounts
    @RequestMapping(value = "/{iban}/balance", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    // gets the balance for account by its iban
    public ResponseEntity<Balance> getAccountBalance(@Parameter(in = ParameterIn.PATH, description = "iban", required = true, schema = @Schema()) @PathVariable("iban") String iban)
    {
        return ResponseEntity.status(200)
                .body(accountService.getAccountBalanceByIban(iban));


    }

    // should be done by accounts
    @RequestMapping(value = "/{iban}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> getAccountByIban(@Parameter(in = ParameterIn.PATH, description = "iban of the selected account", required = true, schema = @Schema()) @PathVariable("iban") String iban)
    {

        return ResponseEntity.status(200)
                .body(accountService.getAccountByIban(iban));

    }

    // should be done by accounts or transactions! doesnt really matter!
    @RequestMapping(value = "/{iban}/transactions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Transaction>> getAccountTransactions(@Parameter(in = ParameterIn.PATH, description = "iban", required = true, schema = @Schema()) @PathVariable("iban") String iban, @Parameter(in = ParameterIn.QUERY, description = "get transactions between two dates", schema = @Schema()) @Valid @RequestParam(value = "betweenDates", required = false) String betweenDates)
    {

        return ResponseEntity.status(200)
                .body(transactionService.getAllTransactionsForIban(iban));
//        return null;

    }
    // should be done by accounts

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Account>> getAllAccounts()
    {

        return new ResponseEntity<List<Account>>(accountService.getAllAccounts(), HttpStatus.OK);
    }
    // should be done by transactions

    // done by Fabio and Mona
    @RequestMapping(value = "/{iban}/withdraw", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transaction> withdrawMoney(@Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("iban") String iban, @Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody TransactionDTO transactionDTO) throws Exception
    {
        Transaction performedTransaction = transactionService.withdrawMoney(iban, transactionDTO);
        return ResponseEntity.status(201)
                .body(transactionService.withdrawMoney(iban, transactionDTO));
//        if (performedTransaction.getClass() != ErroredTransaction.class)
//        {
//            return ResponseEntity.status(201)
//                    .body(transactionService.withdrawMoney(iban, transactionDTO));
//
//        } else return new ResponseEntity<Transaction>(performedTransaction, HttpStatus.BAD_REQUEST);

    }

}
