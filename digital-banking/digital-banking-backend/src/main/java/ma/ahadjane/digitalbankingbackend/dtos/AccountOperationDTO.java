package ma.ahadjane.digitalbankingbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ahadjane.digitalbankingbackend.enums.OperationType;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountOperationDTO {
    private long id;
    private Date operationDate;
    private double amount;
    private OperationType type;
    private String description;
}
