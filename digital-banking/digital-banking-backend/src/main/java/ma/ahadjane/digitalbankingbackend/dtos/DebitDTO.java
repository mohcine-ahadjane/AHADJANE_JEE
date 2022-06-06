package ma.ahadjane.digitalbankingbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebitDTO {

    private String accountId;
    private double amount;
    private String description;


}
