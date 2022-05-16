package ma.enset.patientsmvc.security.repositories;

import ma.enset.patientsmvc.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRoleRepository, Long> {
    AppRole findByRoleName(String username);
    AppRole save(AppRole appRole);
}
