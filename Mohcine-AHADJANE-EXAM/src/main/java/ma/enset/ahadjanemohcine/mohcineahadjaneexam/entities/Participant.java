package ma.enset.ahadjanemohcine.mohcineahadjaneexam.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 10)
@Data @AllArgsConstructor @NoArgsConstructor
abstract public class Participant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nom;
    private String email;
    private String photoPath;
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @OneToMany(mappedBy = "participant")
    private List<Commentaire> commentaires;
}
