package io.swagger.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


class UserTest
{
    private User user;

    @BeforeEach
    void init()
    {
        user = new User();
    }

    @Test
    void userIdCantBeLessThanOrEqualToZero()
    {
        Exception exception = Assertions.assertThrows(Exception.class, () -> user.setUserID(0));
    }

    @Test
    void usernameCantBeNullOrLessThan5Letters()
    {
        Exception exception = Assertions.assertThrows(Exception.class, () -> user.setUsername("ljl"));

    }

    @Test
    void firstNameCantBeNullOrHaveLengthLessThan3()
    {
        Exception exception = Assertions.assertThrows(Exception.class, () -> user.setFirstName("aa"));

    }

    @Test
    void lastNameCantBeNullOrHaveLengthLessThan3()
    {
        Exception exception = Assertions.assertThrows(Exception.class, () -> user.setLastName(""));

    }

    @Test
    void emailAddress()
    {
        Exception exception = Assertions.assertThrows(Exception.class, () -> user.setEmailAddress("j"));

    }

    @Test
    void dateOfBirth()
    {
        Exception exception = Assertions.assertThrows(Exception.class, () -> user.setDateOfBirth(LocalDate.now().toString()));

    }

    @Test
    void dailyLimit()
    {
        Exception exception = Assertions.assertThrows(Exception.class, () -> user.setDailyLimit(0));

    }

    @Test
    void transactionLimit()
    {
        Exception exception = Assertions.assertThrows(Exception.class, () -> user.setTransactionLimit(0));

    }

    @Test
    void userRole()
    {
        Exception exception = Assertions.assertThrows(Exception.class, () -> user.setUserRoles(null));

    }
}