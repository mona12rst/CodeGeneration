
package io.swagger.service;

import io.swagger.exception.IncorrectIBANException;
import io.swagger.exception.InvalidAccountException;
import io.swagger.model.*;
import io.swagger.model.DTO.AccountDTO;
import io.swagger.repository.AccountRepository;
import io.swagger.repository.BalanceRepository;
import io.swagger.repository.IBANRepository;
import io.swagger.service.interfaces.AccountService;
import io.swagger.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService
{
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    IBANRepository ibanRepository;

    @Autowired
    UserService userService;

    @Autowired
    BalanceRepository balanceRepository;


    public List<Account> getAllAccounts()
    {
        return (List<Account>) accountRepository.findAll();
    }


    public Account createAccount(AccountDTO accountDTO) throws Exception
    {
        IBAN iban = new IBAN();
        iban.setCountryCode("NL");
        iban.setCheckNumber(47);
        iban.setBankIdentifier("INGB");
        iban.setAccountNumber(123456089);

        IBANHelper.validate(iban.toString());

        ibanRepository.save(iban);
        System.out.println(iban);
        User user = userService.createUser(accountDTO.getUser());

        Balance balance = balanceRepository.save(accountDTO.getBalance());


        Account account = new Account().dateOfOpening(accountDTO.getDateOfOpening())
                .accountType(accountDTO.getAccountType())
                .accountStatus(accountDTO.getAccountStatus())
//                .dailyLimit(accountDTO.getDailyLimit())
                .absoluteLimit(accountDTO.getAbsoluteLimit())
                .balance(balance)
                .IBAN(iban.toString())
                .user(user);

        accountRepository.save(account);
        return account;


    }

    public Account getAccountByIban(String iban)
    {

        return accountRepository.findAccountByIBAN(iban);
    }



    public int deleteAccountByIban(String iban)
    {
        return accountRepository.deleteAccountByIBAN(iban);
    }

    // this method will not change the user of the account
    public Account editAccountByAccountByIban(String iban, AccountDTO accountDTO) throws Exception
    {
        // changing the balance object
        Balance balance = balanceRepository.getBalanceByBalanceId(accountDTO.getBalance().getBalanceId());
        balance.setAmount(accountDTO.getBalance().getAmount());
        balanceRepository.save(balance);

        Account account = accountRepository.findAccountByIBAN(iban);
        account.setAccountStatus(accountDTO.getAccountStatus());
        account.setAccountType(accountDTO.getAccountType());
        account.setBalance(balance);
//        account.setDailyLimit(accountDTO.getDailyLimit());
        account.setAbsoluteLimit(accountDTO.getAbsoluteLimit());
        // this should not really be an option
//        account.setDateOfOpening(accountDTO.getDateOfOpening());
        accountRepository.save(account);
        return account;



    }
    public Balance getAccountBalanceByIban(String iban)
    {
        Account account = accountRepository.findAccountByIBAN(iban);
        return account.getBalance();
    }

}

