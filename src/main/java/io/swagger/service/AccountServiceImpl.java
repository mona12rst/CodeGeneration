package io.swagger.service;

import io.swagger.model.Account;
import io.swagger.model.DTO.AccountDTO;
import io.swagger.model.DTO.TransactionDTO;
import io.swagger.model.IBAN;
import io.swagger.repository.AccountRepository;
import io.swagger.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService
{
    @Autowired
    AccountRepository accountRepository;


    public List<Account> getAllAccounts()
    {
        return (List<Account>) accountRepository.findAll();
    }
    public Account withdrawMoney(String iban, TransactionDTO transactionDTO)
    {
        return null;




    }

    public Account getAccountByAccountID(long accountId)
    {
        return null;
    }

    public Account getAccountByIban(IBAN iban)
    {
        return null;
    }

    public Account deleteAccountByAccountId(long accountId)
    {
        return null;
    }

    public Account editAccountByAccountId(long accountId, AccountDTO accountDTO)
    {
        return null;
    }
}
