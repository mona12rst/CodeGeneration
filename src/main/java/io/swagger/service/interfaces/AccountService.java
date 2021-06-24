
package io.swagger.service.interfaces;

import io.swagger.model.Account;
import io.swagger.model.Balance;
import io.swagger.model.DTO.AccountDTO;
import io.swagger.model.IBAN;

import java.util.List;

public interface AccountService
{
    List<Account> getAllAccounts();

    Account getAccountByIban(String iban);

    int deleteAccountByIban(String iban);

    Account editAccountByAccountByIban(String iban, AccountDTO accountDTO);

    Account createAccount(AccountDTO accountDTO);

    Balance getAccountBalanceByIban(String iban);


}

