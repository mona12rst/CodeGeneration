package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.security.core.GrantedAuthority;

/**
 * Gets or Sets userRole
 */
// the implements comes from Wims code
public enum UserRoleEnum implements GrantedAuthority
{
    CUSTOMER("customer"),

    USER("user");

    private String value;

    UserRoleEnum(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static UserRoleEnum fromValue(String text) {
        for (UserRoleEnum b : UserRoleEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
    // the override for the granted authority
    @Override
    public String getAuthority() {
        return null;
    }
}