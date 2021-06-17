package io.swagger.repository;

import io.swagger.model.IBAN;
import org.springframework.data.repository.CrudRepository;

public interface IBANRepository extends CrudRepository<IBAN, Long>
{
}
