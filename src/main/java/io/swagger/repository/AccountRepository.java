package io.swagger.repository;

import io.swagger.model.Account;
import io.swagger.model.IBAN;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, IBAN>
{
}
