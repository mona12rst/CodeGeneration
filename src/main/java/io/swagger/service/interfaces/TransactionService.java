package io.swagger.service.interfaces;

import io.swagger.model.DTO.TransactionDTO;
import io.swagger.model.Transaction;
import io.swagger.model.User;

import java.util.List;

public interface TransactionService
{
    Transaction createTransaction(TransactionDTO transactionDTO);
    List<Transaction> getAllTransactionsForIban(String iban);
    List<Transaction> getTransactionsForUser(User user);
<<<<<<< Updated upstream
}
=======
}
>>>>>>> Stashed changes
