package ma.enset.ahadjanemohcine.mohcineahadjaneexam.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.ahadjanemohcine.mohcineahadjaneexam.entities.Conference;
import ma.enset.ahadjanemohcine.mohcineahadjaneexam.entities.Participant;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Data
public class CommentaireDTO {
    private Long id;
    private Date date;
    private String contenu;
    private int nbrlikes;

}
