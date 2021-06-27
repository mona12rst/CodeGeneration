
package io.swagger.service.interfaces;

import io.swagger.exception.IncorrectIBANException;
import io.swagger.exception.InvalidAccountException;
import io.swagger.model.Account;
import io.swagger.model.Balance;
import io.swagger.model.DTO.AccountDTO;
import io.swagger.model.IBAN;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService
{
    List<Account> getAllAccounts();

    Account getAccountByIban(String iban);

    int deleteAccountByIban(String iban);

    Account editAccountByAccountByIban(String iban, AccountDTO accountDTO) throws Exception;

    Account createAccount(AccountDTO accountDTO) throws Exception;

    Balance getAccountBalanceByIban(String iban);


}

