package io.swagger.service.interfaces;

import io.swagger.model.Account;
import io.swagger.model.DTO.AccountDTO;
import io.swagger.model.IBAN;

import java.util.List;

public interface AccountService
{
    List<Account> getAllAccounts();
//    Account getAccountByAccountID(long accountId);
//    Account getAccountByIban(IBAN iban);
//    Account deleteAccountByAccountId(long accountId);
//    Account editAccountByAccountId(long accountId, AccountDTO accountDTO);


}
