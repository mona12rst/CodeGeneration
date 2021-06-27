
package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.exception.IncorrectIBANException;
import io.swagger.exception.InvalidAccountException;
import io.swagger.model.enums.AccountStatusEnum;
import io.swagger.model.enums.AccountTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;


import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Account
 */
@Validated
@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-17T13:48:13.918Z[GMT]")


@Entity
@IdClass(AccountPK.class)

public class Account implements Serializable
{

//    @Id
//    @JsonProperty("IBAN")
    @NotNull
    @Column(unique = true)
    private String IBAN;

    @Id
    @NotNull
    @GeneratedValue
    private long accountId;
    @JsonProperty("absoluteLimit")
    private double absoluteLimit;

    @OneToOne
    @JsonProperty("balance")
    private Balance balance = null;
    @JsonProperty("dateOfOpening")
    private String dateOfOpening = null;
    @JsonProperty("accountType")
    private AccountTypeEnum accountType = null;
    @JsonProperty("accountStatus")
    private AccountStatusEnum accountStatus = null;
    @JsonProperty("user")
    @OneToOne
    private User user = null;

    public long getAccountId()
    {
        return accountId;
    }

    public Account IBAN(String IBAN) throws IncorrectIBANException
    {
        IBANHelper.validate(IBAN);
        this.IBAN = IBAN;
        return this;
    }

    public String getIBAN()
    {
        return IBAN;
    }

    public void setIBAN(String IBAN) throws IncorrectIBANException
    {
        IBANHelper.validate(IBAN);

        this.IBAN = IBAN;
    }

    public Account absoluteLimit(double absoluteLimit) throws Exception
    {
        if(absoluteLimit < 0)
        {
            throw new InvalidAccountException("absolute limit cant be less than zero!");
        }
        this.absoluteLimit = absoluteLimit;
        return this;
    }


    @Schema(example = "10.5", required = true, description = "")

    public double getAbsoluteLimit()
    {
        return absoluteLimit;
    }

    public void setAbsoluteLimit(double absoluteLimit) throws InvalidAccountException
    {
        if(absoluteLimit < 0)
        {
            throw new InvalidAccountException("absolute limit cant be less than zero!");
        }
        this.absoluteLimit = absoluteLimit;
    }


    public Account balance(Balance balance) throws Exception
    {
        if(balance.getAmount() < this.absoluteLimit)
        {
            throw new InvalidAccountException("balance cant be less than absolute limit");
        }
        this.balance = balance;
        return this;
    }


    @Schema(required = true, description = "")
    @NotNull
    @Valid
    public Balance getBalance()
    {
        return balance;
    }

    public void setBalance(Balance balance) throws Exception
    {
        if(balance.getAmount() < this.absoluteLimit)
        {
            throw new InvalidAccountException("balance cant be less than absolute limit");
        }
        this.balance = balance;
    }

    public Account dateOfOpening(String dateOfOpening) throws InvalidAccountException
    {
//        if(LocalDateTime.parse(dateOfOpening).compareTo(LocalDateTime.now()) != 0)
//        {
//            throw new InvalidAccountException("the date of opening for the account must be present(now).");
//        }
//        this.dateOfOpening = dateOfOpening;
        this.dateOfOpening = LocalDateTime.now().toString();
        return this;
    }


    @Schema(example = "05-05-2020", required = true, description = "")
    @NotNull

    public String getDateOfOpening()
    {
        return dateOfOpening;
    }

    public void setDateOfOpening(String dateOfOpening) throws InvalidAccountException
    {
//        if(LocalDateTime.parse(dateOfOpening).compareTo(LocalDateTime.now()) != 0)
//        {
//            throw new InvalidAccountException("the date of opening for the account must be present(now).");
//        }
        this.dateOfOpening = LocalDateTime.now().toString();


    }

    public Account accountType(AccountTypeEnum accountType)
    {
        if(accountType == null)
        {
            this.accountType = AccountTypeEnum.CURRENT;
        }
        this.accountType = accountType;
        return this;
    }
//
//    @Schema(required = true, description = "")
//    @NotNull

    public AccountTypeEnum getAccountType()
    {

        return accountType;
    }

    public void setAccountType(AccountTypeEnum accountType)
    {
        if(accountType == null) // if they dont provide anything by default it should be current
        {
            this.accountType = AccountTypeEnum.CURRENT;
        }
        this.accountType = accountType;
    }

    public Account accountStatus(AccountStatusEnum accountStatus) throws Exception
    {
        if(accountStatus == null)
        {
            throw new InvalidAccountException("account status cant be null");
        }
        this.accountStatus = accountStatus;
        return this;
    }


    @Schema(description = "")

    public AccountStatusEnum getAccountStatus()
    {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatusEnum accountStatus)
    {
        this.accountStatus = accountStatus;
    }

    public Account user(User user) throws Exception
    {
        if(user == null)
        {
            throw new InvalidAccountException("user of the account cant be null");
        }
        this.user = user;
        return this;
    }


    @Schema(required = true, description = "")
    @NotNull

    @Valid
    public User getUser()
    {
        return user;
    }

    public void setUser(User user) throws Exception
    {
        if(user == null)
        {
            throw new InvalidAccountException("user of the account cant be null");
        }
        this.user = user;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(this.IBAN, account.IBAN) &&
                Objects.equals(this.absoluteLimit, account.absoluteLimit) &&
//                Objects.equals(this.dailyLimit, account.dailyLimit) &&
                Objects.equals(this.balance, account.balance) &&
                Objects.equals(this.dateOfOpening, account.dateOfOpening) &&
                Objects.equals(this.accountType, account.accountType) &&
                Objects.equals(this.accountStatus, account.accountStatus) &&
                Objects.equals(this.user, account.user);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(IBAN, absoluteLimit, /*dailyLimit,*/ balance, dateOfOpening, accountType, accountStatus, user);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class Account {\n");

        sb.append("    IBAN: ").append(toIndentedString(IBAN)).append("\n");
        sb.append("    absoluteLimit: ").append(toIndentedString(absoluteLimit)).append("\n");
//        sb.append("    dailyLimit: ").append(toIndentedString(dailyLimit)).append("\n");
        sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
        sb.append("    dateOfOpening: ").append(toIndentedString(dateOfOpening)).append("\n");
        sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
        sb.append("    accountStatus: ").append(toIndentedString(accountStatus)).append("\n");
        sb.append("    user: ").append(toIndentedString(user)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o)
    {
        if (o == null)
        {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }





}

