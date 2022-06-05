package ma.enset.ahadjanemohcine.mohcineahadjaneexam.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Commentaire {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal( TemporalType.DATE )
    @DateTimeFormat( pattern = "yyyy-mm-dd" )
    private Date date;
    private String contenu;
    private int nbrlikes;

    @ManyToOne
    private Participant participant;
    @ManyToOne
    private Conference conference;
}
