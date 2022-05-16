package ma.enset.patientsmvc.security.repositories;

import ma.enset.patientsmvc.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUserRepository, String> {
    AppUser findByUsername(String username);
    AppUser save(AppUser appUser);
}
