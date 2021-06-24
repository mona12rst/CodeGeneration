package io.swagger.service;

import io.swagger.model.DTO.TransactionDTO;
import io.swagger.model.Transaction;
import io.swagger.model.User;
import io.swagger.repository.TransactionRepository;
import io.swagger.service.interfaces.TransactionService;
import io.swagger.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.threeten.bp.LocalDateTime;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService
{
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    UserService userService;


    public Transaction createTransaction(TransactionDTO transactionDTO)
    {
        Transaction transaction = new Transaction().transactionType(transactionDTO.getTransactionType())
                .amount(transactionDTO.getAmount())
                .date(LocalDateTime.now())
                .fromIBAN(transactionDTO.getFromIBAN())
                .toIBAN(transactionDTO.getToIBAN())
                .userPerforming(transactionDTO.getUserPerforming());


        transactionRepository.save(transaction);
        return transaction;
//        return null;
    }


    public List<Transaction> getAllTransactionsForIban(String iban)
    {
        System.out.println("hi");
        transactionRepository.findAllByFromIBAN(iban).forEach(System.out::println);
        return transactionRepository.findAllByFromIBAN(iban);

    }
<<<<<<< Updated upstream

    
=======
    public List<Transaction> getTransactionsForUser(User user)
    {
        User userToFind = userService.getUserById(user.getUserID());
        return transactionRepository.findAllByUserPerforming(userToFind);

    }
>>>>>>> Stashed changes
}
