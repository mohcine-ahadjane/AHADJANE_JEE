package ma.ahadjane.digitalbankingbackend.repositories;

import ma.ahadjane.digitalbankingbackend.entities.CurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, String> {
}
