package io.swagger.service;

import io.swagger.exception.IllegalTransactionException;
import io.swagger.model.*;
import io.swagger.model.enums.UserRoleEnum;
import io.swagger.model.errorDTO.ErroredTransaction;
import io.swagger.model.DTO.TransactionDTO;
import io.swagger.model.enums.AccountStatusEnum;
import io.swagger.model.enums.AccountTypeEnum;
import io.swagger.model.enums.TransactionTypeEnum;
import io.swagger.repository.AccountRepository;
import io.swagger.repository.BalanceRepository;
import io.swagger.repository.TransactionRepository;
import io.swagger.service.interfaces.TransactionService;
import io.swagger.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

import java.time.LocalDateTime;
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

    private String errorCause;


    // this is the same as transfer transaction...
//    public Transaction createTransaction(TransactionDTO transactionDTO)
//    {
//        Transaction transaction = convertTransactionDTO(transactionDTO);
//        transactionRepository.save(transaction);
//        return transaction;
//
//    }

    // done by Fabio
    public List<Transaction> getAllTransactionsForIban(String iban)
    {
        return transactionRepository.findAllByFromIBAN(iban);

    }

    // done by Fabio
    public List<Transaction> getTransactionsForUser(long userId)
    {
        User userToFind = userService.getUserById(userId);

        return transactionRepository.findAllByUserPerforming(userToFind);


    }

    // done by Mona
    public Transaction transferMoney(TransactionDTO transactionDTO) throws Exception
    {
        Account accountFrom = accountRepository.findAccountByIBAN(transactionDTO.getFromIBAN());
        Account accountTo = accountRepository.findAccountByIBAN(transactionDTO.getToIBAN());

        // this method will throw exception if any of the checks goes wrong
        if(validTransfer(transactionDTO, accountFrom, accountTo))
        {
            moveMoney(accountFrom, transactionDTO.getAmount(), TransactionTypeEnum.TRANSFER);
            moveMoney(accountTo, transactionDTO.getAmount(), TransactionTypeEnum.DEPOSIT);

            Transaction transaction = convertTransactionDTO(transactionDTO);
            transactionRepository.save(transaction);
            return transaction;
        }
        return errorTransaction(transactionDTO);




    }

    // done by Fabio
    public Transaction withdrawMoney(String iban, TransactionDTO transactionDTO) throws Exception
    {
        Account account = accountRepository.findAccountByIBAN(iban);
//        System.out.println(account.getBalance());
        // throws exceptions in case of problems
        if (validWithdrawal(account, transactionDTO))
        {
            moveMoney(account, transactionDTO.getAmount(), TransactionTypeEnum.WITHDRAW); // account is also updated in this step
            Transaction transaction = convertTransactionDTO(transactionDTO);
            transaction.setTransactionType(TransactionTypeEnum.WITHDRAW); // making sure its correct!
            transactionRepository.save(transaction); // saving the transaction to the db

            return transaction;
        }
        return errorTransaction(transactionDTO);

    }

    //done by Mona
    public Transaction depositMoney(String iban, TransactionDTO transactionDTO) throws Exception
    {
        if(validDeposit(iban, transactionDTO.getAmount()))
        {
            Account account = accountRepository.findAccountByIBAN(iban);
            moveMoney(account, transactionDTO.getAmount(), TransactionTypeEnum.DEPOSIT);
            Transaction transaction = convertTransactionDTO(transactionDTO);
            transactionRepository.save(transaction);
            return transaction;
        }
        return errorTransaction(transactionDTO);
    }
    // Mona
    private boolean validDeposit(String iban, double amount)
    {
        try
        {
            if (amount <= 0)
            {
                errorCause += "the amount cant be zero or smaller!";
                throw new IllegalTransactionException("the amount cant be zero or smaller!");
            }
            if(accountRepository.findAccountByIBAN(iban) == null)
            {
                errorCause += "account with that iban doesnt exist!";
                throw new IllegalTransactionException("account with that iban doesnt exist!");
            }
        } catch (IllegalTransactionException ite)
        {
            System.out.println(errorCause);
            return false;
        }
        return true;
    }


    // done by Fabio
    private boolean validWithdrawal(Account account,TransactionDTO transactionDTO)
    {
        this.errorCause = "";
        try
        {
            if(transactionDTO.getTransactionType() != TransactionTypeEnum.WITHDRAW)
            {
                errorCause += "your transaction type needs to be withdraw";
                throw new IllegalTransactionException("your transaction type needs to be withdraw");
            }
            if (transactionDTO.getAmount() <= 0)
            {
                errorCause += "the amount cant be zero or smaller!";
                throw new IllegalTransactionException("the amount cant be zero or smaller!");
            }
            if (!hasBalance(account, transactionDTO.getAmount()))
            {
                errorCause += "you dont have enough balance!";
                throw new IllegalTransactionException("you dont have enough balance!");
            }
            if (limitExceeded(account, transactionDTO.getAmount()))
            {
                errorCause += "you have exceeded your limit! ";
                throw new IllegalTransactionException("you have exceeded your limit!");

            }
        } catch (IllegalTransactionException ite)
        {
            System.out.println(ite.getMessage());
            return false;
        }
        return true;
    }

    // done by Mona
    private boolean validTransfer(TransactionDTO transactionDTO, Account accountFrom, Account accountTo)
    {
        try
        {
            if (transactionDTO.getUserPerforming()
                    .getUserID() != accountFrom.getUser()
                    .getUserID() || transactionDTO.getUserPerforming()
                    .getUserRoles().contains(UserRoleEnum.ROLE_EMPLOYEE))
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
                        errorCause = "The account you are trying to move money from must be of type Current or both accounts must belong to the same customer!";
                        msg = "The account you are trying to move money from must be of type Current or both accounts must belong to the same customer!";
                    } else
                    {
                        errorCause = "The account you are trying to move money to must be of type Current or both accounts must belong to the same customer!";
                        msg = "The account you are trying to move money to must be of type Current or both accounts must belong to the same customer!";
                    }
                    throw new IllegalTransactionException(msg);
                }
            }
            if(transactionDTO.getTransactionType() != TransactionTypeEnum.TRANSFER)
            {
                errorCause += "your transaction type needs to be transfer";
                throw new IllegalTransactionException("your transaction type needs to be transfer");
            }
            if (!isActiveAccount(accountFrom))
            {
                errorCause += "The account you are trying to move money from must be active!";
                throw new IllegalTransactionException("The account you are trying to move money from must be active!");
            }
            if (!isActiveAccount(accountTo))
            {
                errorCause += "The account you are trying to move money to must be active!";
                throw new IllegalTransactionException("The account you are trying to move money to must be active!");
            }
            if (!hasBalance(accountFrom, transactionDTO.getAmount()))
            {
                errorCause += "The account doesnt have enough balance!";
                throw new IllegalTransactionException("The account doesnt have enough balance!");
            }
            if (limitExceeded(accountFrom, transactionDTO.getAmount()))
            {
                errorCause += "limit exceeded!";
                throw new IllegalTransactionException("limit exceeded!");

            }
            if (transactionDTO.getAmount() <= 0)
            {
                errorCause += "the amount cant be zero or smaller!";
                throw new IllegalTransactionException("the amount cant be zero or smaller!");
            }

        } catch (IllegalTransactionException ite)
        {
            System.out.println(ite.getMessage());
            return false;
        }
        return true;
    }


    private boolean limitExceeded(Account account, double withdrawAmount)
    {
        // getting the transactions for today
        List<Transaction> accountTransactions = transactionRepository.findAllByFromIBANAndDateContaining(account.getIBAN(), String.valueOf(LocalDateTime.now()));
        double amount = 0;
        for (Transaction t : accountTransactions)
        {
            amount += t.getAmount();
        }
        double userDailyLimit = account.getUser()
                .getDailyLimit();
        double transactionLimit = account.getUser()
                .getTransactionLimit();
        return amount >= userDailyLimit || withdrawAmount >= transactionLimit || (userDailyLimit - amount) < withdrawAmount;


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
        return account.getAccountType() == AccountTypeEnum.CURRENT;
    }

    private void moveMoney(Account account, double amount, TransactionTypeEnum transactionType) throws Exception
    {
        Balance balance = account.getBalance();
        // if the transaction is a transfer, in this context, if its the from account, transferring money
        if (transactionType == TransactionTypeEnum.TRANSFER || transactionType == TransactionTypeEnum.WITHDRAW)
        {
            balance.setAmount(balance.getAmount() - amount);

        } else// (transactionType == TransactionTypeEnum.DEPOSIT) // if the account is receiving money it will be deposit
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

    private Transaction convertTransactionDTO(TransactionDTO transactionDTO) throws Exception
    {
        Transaction transaction = new Transaction().transactionType(transactionDTO.getTransactionType())
                .userPerforming(transactionDTO.getUserPerforming())
                .toIBAN(transactionDTO.getToIBAN())
                .fromIBAN(transactionDTO.getFromIBAN())
                .date(LocalDateTime.now().toString())
                .amount(transactionDTO.getAmount());
//                .date(String.valueOf(LocalDateTime.now()));
        return transaction;
    }

    private Transaction errorTransaction(TransactionDTO transactionDTO)
    {
        return ErroredTransaction.builder()
                .cause(errorCause)
                .user(transactionDTO.getUserPerforming())
                .time(LocalDateTime.now())
                .build();

    }


}
