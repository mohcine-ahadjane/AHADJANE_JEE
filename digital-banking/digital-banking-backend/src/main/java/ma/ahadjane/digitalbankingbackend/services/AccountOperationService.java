package ma.ahadjane.digitalbankingbackend.services;


import ma.ahadjane.digitalbankingbackend.dtos.AccountHistoryDTO;
import ma.ahadjane.digitalbankingbackend.dtos.AccountOperationDTO;
import ma.ahadjane.digitalbankingbackend.exceptions.BankAccountNotFoundExcetion;
import ma.ahadjane.digitalbankingbackend.exceptions.OperationNotFoundException;

import java.util.List;

public interface AccountOperationService {

    public List<AccountOperationDTO> getAccountOperationsHistory(String accountId);

    public AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundExcetion;


    AccountOperationDTO getOperation(long operationId) throws OperationNotFoundException;
}
