package ma.enset.etudiantsmvc.repositeries;

import ma.enset.etudiantsmvc.entities.Etudiant;
import ma.enset.etudiantsmvc.entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepositery extends JpaRepository<Etudiant,Long> {
    Page<Etudiant> findByNomContains(String kw , Pageable pageable);
}
