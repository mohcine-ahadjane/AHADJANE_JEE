package ma.ahadjane.digitalbankingbackend.repositories;


import ma.ahadjane.digitalbankingbackend.entities.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingAccountRepository extends JpaRepository<SavingAccount, String> {

}
