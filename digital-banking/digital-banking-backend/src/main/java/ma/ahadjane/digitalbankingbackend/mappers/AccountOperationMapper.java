package ma.ahadjane.digitalbankingbackend.mappers;

import ma.ahadjane.digitalbankingbackend.dtos.AccountOperationDTO;
import ma.ahadjane.digitalbankingbackend.entities.AccountOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AccountOperationMapper {

    public AccountOperationDTO fromAccountOperation (AccountOperation accountOperation){
        AccountOperationDTO accountOperationDTO = new AccountOperationDTO();
        BeanUtils.copyProperties( accountOperation, accountOperationDTO);
        return  accountOperationDTO;
    }


}
