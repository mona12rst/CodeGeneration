/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.25).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Transaction;
import io.swagger.model.DTO.TransactionDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-17T13:48:13.918Z[GMT]")
@Validated
public interface TransactionsApi {

    @Operation(summary = "Returns all transactions", description = "returns a list of transactions for the specified iban", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Transaction" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Found", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Transaction.class)))),
        
        @ApiResponse(responseCode = "201", description = "Created"),
        
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        
        @ApiResponse(responseCode = "403", description = "Forbidden, you do not have access rights"),
        
        @ApiResponse(responseCode = "404", description = "Not found"),
        
        @ApiResponse(responseCode = "409", description = "Conflict"),
        
        @ApiResponse(responseCode = "500", description = "Oops, something went wrong on the server.") })
    @RequestMapping(value = "/transactions/{iban}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Transaction>> getTransactionByIban(@Parameter(in = ParameterIn.PATH, description = "Returns all from/to transaction for this iban", required=true, schema=@Schema()) @PathVariable("iban") String iban);


    @Operation(summary = "Returns the specified transaction by transactionID", description = "Returns the specified transaction", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Transaction" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Transaction found", content = @Content(schema = @Schema(implementation = Transaction.class))),
        
        @ApiResponse(responseCode = "201", description = "Created"),
        
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        
        @ApiResponse(responseCode = "403", description = "Forbidden, you do not have access rights"),
        
        @ApiResponse(responseCode = "404", description = "Not found"),
        
        @ApiResponse(responseCode = "409", description = "Conflict"),
        
        @ApiResponse(responseCode = "500", description = "Oops, something went wrong on the server.") })
    @RequestMapping(value = "/transactions/{userId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Transaction> getTransactionByUserId(@Parameter(in = ParameterIn.PATH, description = "Transaction id", required=true, schema=@Schema()) @PathVariable("userId") Integer userId);


    @Operation(summary = "gets all of the transactions", description = "get transactions", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Transaction" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Transaction created", content = @Content(schema = @Schema(implementation = Transaction.class))),
        
        @ApiResponse(responseCode = "201", description = "Created"),
        
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        
        @ApiResponse(responseCode = "403", description = "Forbidden, you do not have access rights"),
        
        @ApiResponse(responseCode = "404", description = "Not found"),
        
        @ApiResponse(responseCode = "409", description = "Conflict"),
        
        @ApiResponse(responseCode = "500", description = "Oops, something went wrong on the server.") })
    @RequestMapping(value = "/transactions",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Transaction> getTransactions(@NotNull @Min(5L) @Max(50L) @Parameter(in = ParameterIn.QUERY, description = "the limit to get number of transactions" ,required=true,schema=@Schema(allowableValues={  }, minimum="5", maximum="50"
)) @Valid @RequestParam(value = "limit", required = true) Long limit, @Min(5L) @Max(50L) @Parameter(in = ParameterIn.QUERY, description = "gets a specific transaction by id" ,schema=@Schema(allowableValues={  }, minimum="5", maximum="50"
)) @Valid @RequestParam(value = "transactionID", required = false) Long transactionID, @Min(0L)@Parameter(in = ParameterIn.QUERY, description = "the offset to start getting users" ,schema=@Schema(allowableValues={  }
)) @Valid @RequestParam(value = "offset", required = false) Long offset, @Parameter(in = ParameterIn.QUERY, description = "get transactions for the specific day" ,schema=@Schema()) @Valid @RequestParam(value = "day", required = false) String day, @Parameter(in = ParameterIn.QUERY, description = "get transactions between two dates" ,schema=@Schema()) @Valid @RequestParam(value = "betweenDates", required = false) String betweenDates, @Parameter(in = ParameterIn.QUERY, description = "the from iban to get the transactions for" ,schema=@Schema()) @Valid @RequestParam(value = "fromIban", required = false) String fromIban, @Parameter(in = ParameterIn.QUERY, description = "the to iban to get the transactions for" ,schema=@Schema()) @Valid @RequestParam(value = "toIban", required = false) String toIban);


    @Operation(summary = "transfer money to another account", description = "Initiate a payment process.", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Transaction" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Transaction created", content = @Content(schema = @Schema(implementation = Transaction.class))),
        
        @ApiResponse(responseCode = "201", description = "Created"),
        
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        
        @ApiResponse(responseCode = "403", description = "Forbidden, you do not have access rights"),
        
        @ApiResponse(responseCode = "404", description = "Not found"),
        
        @ApiResponse(responseCode = "409", description = "Conflict"),
        
        @ApiResponse(responseCode = "500", description = "Oops, something went wrong on the server.") })
    @RequestMapping(value = "/transactions",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Transaction> transferMoney(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody TransactionDTO body);

}

