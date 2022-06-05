package ma.enset.ahadjanemohcine.mohcineahadjaneexam.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.ahadjanemohcine.mohcineahadjaneexam.entities.Inscription;
import ma.enset.ahadjanemohcine.mohcineahadjaneexam.entities.Participant;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;


@Data
public class InviteDTO extends Participant {
    private String affiliation;


}
