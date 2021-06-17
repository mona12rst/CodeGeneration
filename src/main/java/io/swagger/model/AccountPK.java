package io.swagger.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountPK implements Serializable
{
    private IBAN IBAN;
    private long accountId;

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        AccountPK pk = (AccountPK) o;
        return Objects.equals( IBAN, pk.IBAN ) &&
                Objects.equals( accountId, pk.accountId );
    }

    @Override
    public int hashCode() {
        return Objects.hash( IBAN, accountId );
    }

}
