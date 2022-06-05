package ma.enset.ahadjanemohcine.mohcineahadjaneexam.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.ahadjanemohcine.mohcineahadjaneexam.entities.Commentaire;
import ma.enset.ahadjanemohcine.mohcineahadjaneexam.entities.Genre;

import javax.persistence.*;
import java.util.List;


@Data
abstract public class ParticipantDTO {
    private String id;
    private String nom;
    private String email;
    private String photoPath;
    private Genre genre;

}
