package io.swagger.service.interfaces;

import io.swagger.model.DTO.TransactionDTO;
import io.swagger.model.Transaction;

import java.util.List;

public interface TransactionService
{
    Transaction createTransaction(TransactionDTO transactionDTO);
    List<Transaction> getAllTransactions();
}
