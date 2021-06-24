<<<<<<< Updated upstream
package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AccountStatusEnum
{
    ACTIVE("active"),

    CLOSED("closed"),

    INACTIVE("inactive"),

    BLOCKED("blocked");

    private String value;

    AccountStatusEnum(String value)
    {
        this.value = value;
    }

    @JsonCreator
    public static AccountStatusEnum fromValue(String text)
    {
        for (AccountStatusEnum b : AccountStatusEnum.values())
        {
            if (String.valueOf(b.value).equals(text))
            {
                return b;
            }
        }
        return null;
    }

    @Override
    @JsonValue
    public String toString()
    {
        return String.valueOf(value);
    }
}
=======
package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AccountStatusEnum
{
    ACTIVE("active"),

    CLOSED("closed"),

    INACTIVE("inactive"),

    BLOCKED("blocked");

    private String value;

    AccountStatusEnum(String value)
    {
        this.value = value;
    }

    @JsonCreator
    public static AccountStatusEnum fromValue(String text)
    {
        for (AccountStatusEnum b : AccountStatusEnum.values())
        {
            if (String.valueOf(b.value).equals(text))
            {
                return b;
            }
        }
        return null;
    }

    @Override
    @JsonValue
    public String toString()
    {
        return String.valueOf(value);
    }
}
>>>>>>> Stashed changes
