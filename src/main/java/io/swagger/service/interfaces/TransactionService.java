package io.swagger.service.interfaces;

import io.swagger.model.DTO.TransactionDTO;
import io.swagger.model.Transaction;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TransactionService
{
//    Transaction createTransaction(TransactionDTO transactionDTO);
    List<Transaction> getAllTransactionsForIban(String iban);
    List<Transaction> getTransactionsForUser(long userId);
    public Transaction transferMoney(TransactionDTO transactionDTO) throws Exception;
    public Transaction withdrawMoney(String iban, TransactionDTO transactionDTO) throws Exception;
    public Transaction depositMoney(String iban, TransactionDTO transactionDTO) throws Exception;


}

