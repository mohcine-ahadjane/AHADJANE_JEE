package ma.enset.ahadjanemohcine.mohcineahadjaneexam.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Inscription {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal( TemporalType.DATE )
    @DateTimeFormat( pattern = "yyyy-mm-dd" )
    private Date date;
    @Enumerated(EnumType.STRING)
    private Statut statut;
    private double prix;

    @ManyToOne
    private Session session;
    @ManyToOne
    private Invite invite;
}
