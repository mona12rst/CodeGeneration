package io.swagger.model;


import io.swagger.exception.IncorrectIBANException;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class IBAN
{
    private String countryCode;
    private int CheckNumber;
    private String bankIdentifier;
    // must contain at leas one or more zeros
    private long accountNumber;

    public void setAccountNumber(long accountNumber)
    {
        try
        {
            if(accountNumber == 0) // account number shouldnt be all zeros
            {
                throw new IncorrectIBANException("Account number cant be zero.");
            }
            // I assume it must be exactly 9 numbers
            if(String.valueOf(accountNumber).length() > 9 || String.valueOf(accountNumber).length() < 9)
            {
                throw new IncorrectIBANException("The number portion of account number needs to be 9 digits");
            }
            // it needs to contain at least one zero
            if(!String.valueOf(accountNumber).contains("0"))
            {
                throw new IncorrectIBANException("The number portion of account number must contain at least one 0");
            }
            this.accountNumber = accountNumber;

        }
        catch (IncorrectIBANException ii)
        {
            System.out.println(ii.getMessage());

        }



    }

    public String toString()
    {
        return String.format(getCountryCode()+getCheckNumber()+getBankIdentifier()+getAccountNumber());
    }

}
