package ma.enset.ahadjanemohcine.mohcineahadjaneexam.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.ahadjanemohcine.mohcineahadjaneexam.entities.Invite;
import ma.enset.ahadjanemohcine.mohcineahadjaneexam.entities.Session;
import ma.enset.ahadjanemohcine.mohcineahadjaneexam.entities.Statut;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Data
public class InscriptionDTO {
    private Long id;
    private Date date;
    private Statut statut;
    private double prix;

}
