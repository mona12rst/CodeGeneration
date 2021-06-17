package io.swagger.repository;

import io.swagger.model.Account;
import io.swagger.model.IBAN;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, IBAN>
{
}
