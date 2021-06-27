package io.swagger.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalanceTest
{
    private Balance balance;
    @BeforeEach
    void init()
    {
        balance = new Balance();
    }

    @Test
    void balanceCantBeNull()
    {
        balance = new Balance();

    }

    @Test
    void amountCantBeLessThanZero()
    {
        Exception exception = Assertions.assertThrows(Exception.class, ()-> balance.setAmount(-1));
    }


}