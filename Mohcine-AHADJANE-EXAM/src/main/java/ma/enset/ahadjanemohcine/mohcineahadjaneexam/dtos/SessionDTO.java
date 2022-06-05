package ma.enset.ahadjanemohcine.mohcineahadjaneexam.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.ahadjanemohcine.mohcineahadjaneexam.entities.Moderateur;

import javax.persistence.*;


@Data
public class SessionDTO {
    private Long id;
    private String nom;

}
