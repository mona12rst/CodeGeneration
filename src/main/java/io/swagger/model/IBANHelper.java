package io.swagger.model;


import io.swagger.exception.IncorrectIBANException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class IBANHelper
{
    private IBANHelper()
    {
    }

    public static void validate(String accountNumber) throws IncorrectIBANException
    {
        if (accountNumber == null) throw new IncorrectIBANException("account number cant be empty!");
        Pattern pattern = Pattern.compile("NL[0-9]{2}[A-Z]{4}[0-9]{9}");
        Matcher matcher = pattern.matcher(accountNumber);
        if (!matcher.matches())
        {
            throw new IncorrectIBANException("incorrect iban pattern!!!!");
        }
//        } else
//        {
//            throw new IncorrectIBANException("incorrect iban pattern!");
//        }
    }
}
