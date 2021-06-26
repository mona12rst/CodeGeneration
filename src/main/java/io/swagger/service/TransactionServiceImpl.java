package io.swagger.service;

import io.swagger.exception.IllegalTransactionException;
import io.swagger.model.*;
import io.swagger.model.DTO.TransactionDTO;
import io.swagger.model.enums.AccountStatusEnum;
import io.swagger.model.enums.TransactionTypeEnum;
import io.swagger.repository.AccountRepository;
import io.swagger.repository.BalanceRepository;
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
    private UserService userService;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private BalanceRepository balanceRepository;


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
        transactionRepository.findAllByFromIBAN(iban)
                .forEach(System.out::println);
        return transactionRepository.findAllByFromIBAN(iban);

    }


    public List<Transaction> getTransactionsForUser(long userId)
    {
        User userToFind = userService.getUserById(userId);

//        List<Transaction> transactions = transactionRepository.findAll();
        return transactionRepository.findAllByUserPerforming(userToFind);


    }

    public Transaction transferMoney(TransactionDTO transactionDTO)
    {
        Account accountFrom = accountRepository.findAccountByIBAN(transactionDTO.getFromIBAN());
        Account accountTo = accountRepository.findAccountByIBAN(transactionDTO.getToIBAN());
        try
        {
            if(transactionDTO.getUserPerforming().getUserID() != accountFrom.getUser().getUserID() || transactionDTO.getUserPerforming().getUserRole() != UserRoleEnum.USER)
            {
                throw new IllegalTransactionException("You are not authorized to do this transaction");
            }

            // check if both accounts are of type current
            if (!isCurrentAccount(accountFrom) || !isCurrentAccount(accountTo))
            {
                if (!isFromSameCustomer(accountFrom, accountTo))
                {
                    String msg = "";
                    if (!isCurrentAccount(accountFrom)) // check which account is exactly the wrong type
                    {
                        msg = "The account you are trying to move money from must be of type Current or both accounts must belong to the same customer!";
                    } else
                    {
                        msg = "The account you are trying to move money to must be of type Current or both accounts must belong to the same customer!";
                    }
                    throw new IllegalTransactionException(msg);

                }
            }
            if (!isActiveAccount(accountFrom))
            {
                throw new IllegalTransactionException("The account you are trying to move money from must be active!");
            }
            if (!isActiveAccount(accountTo))
            {
                throw new IllegalTransactionException("The account you are trying to move money to must be active!");
            }


            moveMoney(accountFrom, transactionDTO.getAmount(), TransactionTypeEnum.TRANSFER);
            moveMoney(accountTo, transactionDTO.getAmount(), TransactionTypeEnum.DEPOSIT);



        } catch (IllegalTransactionException ite)
        {
            System.out.println(ite.getMessage());
        }
        finally
        {
            Transaction transaction = convertTransactionDTO(transactionDTO);
            transactionRepository.save(transaction);
            return transaction;
        }


    }

    private boolean isActiveAccount(Account account)
    {
        return account.getAccountStatus() == AccountStatusEnum.ACTIVE;
    }

    private boolean hasBalance(Account account, double amount)
    {
        // the absoloute limit must be deducted from the real value since it cant be spent
        return (account.getBalance()
                .getAmount() - account.getAbsoluteLimit()) >= amount;

    }

    private boolean isCurrentAccount(Account account)
    {
        return account.getAccountType() == Account.AccountTypeEnum.CURRENT;
    }

    private void moveMoney(Account account, double amount, TransactionTypeEnum transactionType)
    {
        Balance balance = account.getBalance();
        // if the transaction is a transfer, in this context, if its the from account, transferring money
        if (transactionType == TransactionTypeEnum.TRANSFER)
        {
            balance.setAmount(balance.getAmount() - amount);

        } else if (transactionType == TransactionTypeEnum.DEPOSIT) // if the account is receiving money it will be deposit
        {
            balance.setAmount(balance.getAmount() + amount);

        }
        balanceRepository.save(balance);
        account.setBalance(balance);
        accountRepository.save(account);


    }

    private boolean isFromSameCustomer(Account accountFrom, Account accountTo)
    {
        return accountFrom.getUser()
                .getUserID() == accountTo.getUser()
                .getUserID();
    }

    private Transaction convertTransactionDTO(TransactionDTO transactionDTO)
    {
        Transaction transaction = new Transaction().transactionType(transactionDTO.getTransactionType())
                .userPerforming(transactionDTO.getUserPerforming())
                .toIBAN(transactionDTO.getToIBAN())
                .fromIBAN(transactionDTO.getFromIBAN())
                .amount(transactionDTO.getAmount())
                .date(LocalDateTime.now());
        return transaction;
    }


}
