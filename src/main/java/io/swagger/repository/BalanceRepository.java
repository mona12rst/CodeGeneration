package io.swagger.repository;

import io.swagger.model.Balance;
import org.springframework.data.repository.CrudRepository;

public interface BalanceRepository extends CrudRepository<Balance, Long>
{
}
