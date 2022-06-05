package ma.enset.ahadjanemohcine.mohcineahadjaneexam.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@DiscriminatorValue("MODERATEUR")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Moderateur extends Participant {
    private String speciality;

    @OneToMany(mappedBy = "moderateur", fetch = FetchType.LAZY)

    private List<Session> sessions;
}
