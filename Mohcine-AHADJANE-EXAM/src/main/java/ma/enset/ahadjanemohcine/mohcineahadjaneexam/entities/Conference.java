package ma.enset.ahadjanemohcine.mohcineahadjaneexam.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conference {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    @Temporal( TemporalType.DATE )
    @DateTimeFormat( pattern = "yyyy-mm-dd" )
    private Date date;
    private String heureDebut;
    private String heureFin;
    private String description;

    @ManyToOne
    private Session session;
    @ManyToOne
    private Sale salle;
    @ManyToOne
    private Speaker speaker;
}