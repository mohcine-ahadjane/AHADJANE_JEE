package ma.enset.ahadjanemohcine.mohcineahadjaneexam.repositories;

import ma.enset.ahadjanemohcine.mohcineahadjaneexam.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, String> {
}
