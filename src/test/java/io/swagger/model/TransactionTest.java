package io.swagger.model;

import io.swagger.model.enums.TransactionTypeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest
{
    private Transaction transaction;

    @BeforeEach
    void init()
    {
        transaction = new Transaction();
    }

    @Test
    void fromIbanCantBeNullOrInvalidUnlessItsADeposit()
    {

        Exception exception = Assertions.assertThrows(Exception.class, () -> transaction.setFromIBAN("jjj"));
    }

    @Test
    void toIbanCantBeNullIfItsATransfer() throws Exception
    {
        transaction.setTransactionType(TransactionTypeEnum.TRANSFER);
        Exception exception = Assertions.assertThrows(Exception.class, () -> transaction.setToIBAN("jjj"));

    }

    @Test
    void amountCantBeLessThanOrEqualToZero()
    {
        Exception exception = Assertions.assertThrows(Exception.class, () -> transaction.setAmount(-1));

    }

    @Test
    void transactionTypeCantBeNull()
    {
        Exception exception = Assertions.assertThrows(Exception.class, () -> transaction.setTransactionType(null));

    }

    @Test
    void userPerformingCantBeNull()
    {
        Exception exception = Assertions.assertThrows(Exception.class, () -> transaction.setUserPerforming(null));

    }


}