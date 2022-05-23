package ma.enset.ebankingbackend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.ebankingbackend.entities.BankAccount;

import javax.persistence.*;
import java.util.List;


@Data
public class CustomerDTO extends BankAccountDTO{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}
