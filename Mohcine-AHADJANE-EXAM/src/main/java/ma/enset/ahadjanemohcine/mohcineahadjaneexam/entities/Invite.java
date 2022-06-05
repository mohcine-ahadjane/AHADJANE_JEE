package ma.enset.ahadjanemohcine.mohcineahadjaneexam.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@DiscriminatorValue("INVITE")
@Data @NoArgsConstructor @AllArgsConstructor
public class Invite extends Participant {
    private String affiliation;

    @OneToMany(mappedBy = "invite")
    private List<Inscription> inscriptions;
}
