package ma.enset.ebankingbackend.repositories;

import ma.enset.ebankingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustmerRepository extends JpaRepository<Customer, Long> {
}
