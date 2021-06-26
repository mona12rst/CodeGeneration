package io.swagger.repository;

import io.swagger.model.Transaction;
import io.swagger.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, String>, PagingAndSortingRepository<Transaction, String>
{
    List<Transaction> findAllByFromIBAN(String iban);
    List<Transaction> findAllByUserPerforming(User user);



}
