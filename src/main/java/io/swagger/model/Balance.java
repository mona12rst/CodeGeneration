package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.exception.InvalidAccountException;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

import lombok.Builder;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Balance
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-17T13:48:13.918Z[GMT]")


@Entity


public class Balance
{
    @Id
    @GeneratedValue
    private long balanceId;

    public long getBalanceId()
    {
        return balanceId;
    }

    @JsonProperty("amount")
    private double amount;

    public Balance amount(double amount) throws Exception
    {
        if(amount < 0)
        {
            throw new InvalidAccountException("amount cant be less than zero");
        }
        this.amount = amount;
        return this;
    }


    @Schema(example = "10.5", required = true, description = "")

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount) throws Exception
    {
        if(amount < 0)
        {
            throw new InvalidAccountException("amount cant be less than zero");
        }
        this.amount = amount;
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
        Balance balance = (Balance) o;
        return Objects.equals(this.amount, balance.amount);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(amount);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class Balance {\n");

        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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
