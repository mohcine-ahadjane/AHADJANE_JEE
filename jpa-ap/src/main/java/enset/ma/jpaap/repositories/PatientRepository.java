package enset.ma.jpaap.repositories;
import enset.ma.jpaap.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
