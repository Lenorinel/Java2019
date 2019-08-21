package store.Repository;

import store.models.Customer;
import store.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByDateBetween(Date firstDate, Date secondDate);
    List<Transaction> findAllByCustomer(Customer customer);

}
