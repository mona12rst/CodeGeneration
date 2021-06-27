package io.swagger.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.exception.IllegalTransactionException;
import io.swagger.exception.IncorrectIBANException;
import io.swagger.model.enums.TransactionTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;


import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Transaction
 */
@Validated
@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-17T13:48:13.918Z[GMT]")

@Entity
public class Transaction
{
    @Id
    @GeneratedValue
    @JsonProperty("TransactionID")
    private UUID transactionID = null;

    @JsonProperty("FromIBAN")
    private String fromIBAN = null;

    @JsonProperty("ToIBAN")
    private String toIBAN = null;

    @JsonProperty("Amount")
    private double amount;


    @JsonProperty("TransactionType")
    private TransactionTypeEnum transactionType;

    @JsonProperty("Date")
    private String date;

    @OneToOne
    @JsonProperty("userPerforming")
    private User userPerforming;

    public Transaction transactionID(UUID transactionID)
    {
        this.transactionID = transactionID;
        return this;
    }


    @Schema(required = true, description = "")

    public UUID getTransactionID()
    {
        return transactionID;
    }

    public void setTransactionID(UUID transactionID)
    {
        this.transactionID = transactionID;
    }

    public Transaction fromIBAN(String fromIBAN) throws Exception
    {
        if(transactionType != TransactionTypeEnum.DEPOSIT)
        {
            IBANHelper.validate(fromIBAN);
        }
        this.fromIBAN = fromIBAN;
        return this;
    }

    /**
     * Get fromIBAN
     *
     * @return fromIBAN
     **/
    @Schema(example = "NL01ING09874374839", required = true, description = "")
    @NotNull

    public String getFromIBAN()
    {
        return fromIBAN;
    }

    public void setFromIBAN(String fromIBAN) throws Exception
    {
        if(transactionType != TransactionTypeEnum.DEPOSIT)
        {
            IBANHelper.validate(fromIBAN);
        }

        this.fromIBAN = fromIBAN;
    }

    public Transaction toIBAN(String toIBAN) throws IncorrectIBANException
    {
        if(transactionType == TransactionTypeEnum.TRANSFER)
        {
            IBANHelper.validate(toIBAN);

        }
        this.toIBAN = toIBAN;
        return this;
    }


    @Schema(example = "NL01ING09874374839", required = true, description = "")
    @NotNull

    public String getToIBAN()
    {
        return toIBAN;
    }

    public void setToIBAN(String toIBAN) throws Exception
    {
        if(transactionType == TransactionTypeEnum.TRANSFER)
        {
            IBANHelper.validate(toIBAN);

        }
        this.toIBAN = toIBAN;
    }

    public Transaction amount(double amount) throws Exception
    {
        if(amount <= 0)
        {
            throw new IllegalTransactionException("amount cant be zero or less");
        }
        this.amount = amount;
        return this;
    }


    @Schema(required = true, description = "")

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount) throws Exception
    {
        if(amount <= 0)
        {
            throw new IllegalTransactionException("amount cant be zero or less");
        }
        this.amount = amount;
    }

    public Transaction transactionType(TransactionTypeEnum transactionType) throws Exception
    {
        if(transactionType == null)
        {
            throw new IllegalTransactionException("transaction type cant be null");
        }
        this.transactionType = transactionType;
        return this;
    }


    @Schema(required = true, description = "Type of transaction")
    @NotNull

    public TransactionTypeEnum getTransactionType()
    {
        return transactionType;
    }

    public void setTransactionType(TransactionTypeEnum transactionType) throws Exception
    {
        if(transactionType == null)
        {
            throw new IllegalTransactionException("transaction type cant be null");
        }
        this.transactionType = transactionType;
    }

    public Transaction date(String date)
    {
        this.date = LocalDateTime.now().toString();
        return this;
    }

    /**
     * Get date
     *
     * @return date
     **/
    @Schema(required = true, description = "")

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = LocalDateTime.now().toString();

    }

    public Transaction userPerforming(User userPerforming) throws Exception
    {
        if(userPerforming == null)
        {
            throw new IllegalTransactionException("user performing cannot be null");
        }
        this.userPerforming = userPerforming;
        return this;
    }


    @Schema(required = true, description = "")
    @NotNull

    @Valid
    public User getUserPerforming()
    {
        return userPerforming;
    }

    public void setUserPerforming(User userPerforming) throws Exception
    {
        if(userPerforming == null)
        {
            throw new IllegalTransactionException("user performing cannot be null");
        }
        this.userPerforming = userPerforming;
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
        Transaction transaction = (Transaction) o;
        return Objects.equals(this.transactionID, transaction.transactionID) && Objects.equals(this.fromIBAN, transaction.fromIBAN) && Objects.equals(this.toIBAN, transaction.toIBAN) && Objects.equals(this.amount, transaction.amount) && Objects.equals(this.transactionType, transaction.transactionType) && Objects.equals(this.date, transaction.date) && Objects.equals(this.userPerforming, transaction.userPerforming);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(transactionID, fromIBAN, toIBAN, amount, transactionType, date, userPerforming);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class Transaction {\n");

        sb.append("    transactionID: ")
                .append(toIndentedString(transactionID))
                .append("\n");
        sb.append("    fromIBAN: ")
                .append(toIndentedString(fromIBAN))
                .append("\n");
        sb.append("    toIBAN: ")
                .append(toIndentedString(toIBAN))
                .append("\n");
        sb.append("    amount: ")
                .append(toIndentedString(amount))
                .append("\n");
        sb.append("    transactionType: ")
                .append(toIndentedString(transactionType))
                .append("\n");
        sb.append("    date: ")
                .append(toIndentedString(date))
                .append("\n");
        sb.append("    userPerforming: ")
                .append(toIndentedString(userPerforming))
                .append("\n");
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
        return o.toString()
                .replace("\n", "\n    ");
    }
}
