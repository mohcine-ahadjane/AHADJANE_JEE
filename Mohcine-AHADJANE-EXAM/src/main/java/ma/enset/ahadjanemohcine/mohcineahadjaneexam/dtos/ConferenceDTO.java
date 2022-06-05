package ma.enset.ahadjanemohcine.mohcineahadjaneexam.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.ahadjanemohcine.mohcineahadjaneexam.entities.Sale;
import ma.enset.ahadjanemohcine.mohcineahadjaneexam.entities.Session;
import ma.enset.ahadjanemohcine.mohcineahadjaneexam.entities.Speaker;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data

public class ConferenceDTO {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    @Temporal( TemporalType.DATE )
    @DateTimeFormat( pattern = "yyyy-mm-dd" )
    private Date date;
    private String heureDebut;
    private String heureFin;
    private String description;

}