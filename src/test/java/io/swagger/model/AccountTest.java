package io.swagger.model;


import io.swagger.exception.InvalidAccountException;
import io.swagger.model.enums.AccountTypeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.threeten.bp.LocalDateTime;
import io.swagger.model.enums.AccountTypeEnum;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest
{
    private Account account;

    @BeforeEach
    public void init()
    {
        account = new Account();
    }

    @Test
    public void creatingAnAccountCantBeNull()
    {

        Assertions.assertNotNull(account);

    }

    @Test
    public void accountNumberCantBeEmpty()
    {
        Exception exception = Assertions.assertThrows(Exception.class, () -> account.setIBAN(""));
    }

    @Test
    public void accountNumberCantBeIllegal()
    {
        Exception exception = Assertions.assertThrows(Exception.class, () -> account.setIBAN("2545414fjlajl;a"));

    }

    @Test
    public void accountOpeningDateCantBeInThePast()
    {
        Exception exception = Assertions.assertThrows(Exception.class, () -> account.setDateOfOpening((LocalDateTime.of(2021, 05, 05, 12, 20, 30)).toString()));
    }

    @Test
    public void absoluteLimitCantBeLessThanZero()
    {
        // both of them pass...
        Exception exception = Assertions.assertThrows(Exception.class, () -> account.absoluteLimit(-1));

        //Exception exception = Assertions.assertThrows(Exception.class, ()-> account.setAbsoluteLimit(-1));
    }

    @Test
    public void balanceCantBeLessThanAbsoluteLimit() throws InvalidAccountException
    {
        account.setAbsoluteLimit(200);
        Exception exception = Assertions.assertThrows(Exception.class, ()-> account.balance(new Balance().amount(10)));
    }

    @Test
    public void accountStatusCantBeNull()
    {
        Exception exception = Assertions.assertThrows(Exception.class, ()-> account.accountStatus(null));

    }

    @Test
    public void accountUserCantBeNull()
    {
        Exception exception = Assertions.assertThrows(Exception.class, ()-> account.user(null));

    }



}