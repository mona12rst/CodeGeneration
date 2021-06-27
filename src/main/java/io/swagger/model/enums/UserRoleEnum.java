package io.swagger.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.security.core.GrantedAuthority;

/**
 * Gets or Sets userRole
 */
// the implements comes from Wims code
public enum UserRoleEnum implements GrantedAuthority
{
    //    ROLE_CUSTOMER("customer"),
//
//    ROLE_EMPLOYEE("user");
    ROLE_CUSTOMER,

    ROLE_EMPLOYEE;

//    private String value;

//    UserRoleEnum(String value)
//    {
//        this.value = value;
//    }

//    @JsonCreator
//    public static UserRoleEnum fromValue(String text)
//    {
//        for (UserRoleEnum b : UserRoleEnum.values())
//        {
//            if (String.valueOf(b.value)
//                    .equals(text))
//            {
//                return b;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    @JsonValue
//    public String toString()
//    {
//        return String.valueOf(value);
//    }

    // the override for the granted authority
    @Override
    public String getAuthority()
    {
        return name();
    }
}