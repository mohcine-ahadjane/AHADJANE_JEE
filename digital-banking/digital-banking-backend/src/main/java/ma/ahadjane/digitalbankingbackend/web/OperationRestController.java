package ma.ahadjane.digitalbankingbackend.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.ahadjane.digitalbankingbackend.dtos.AccountOperationDTO;
import ma.ahadjane.digitalbankingbackend.dtos.CreditDTO;
import ma.ahadjane.digitalbankingbackend.dtos.DebitDTO;
import ma.ahadjane.digitalbankingbackend.dtos.TransferRequestDTO;
import ma.ahadjane.digitalbankingbackend.exceptions.BalanceNotSufficientException;
import ma.ahadjane.digitalbankingbackend.exceptions.BankAccountNotFoundExcetion;
import ma.ahadjane.digitalbankingbackend.exceptions.OperationNotFoundException;
import ma.ahadjane.digitalbankingbackend.services.AccountOperationService;
import ma.ahadjane.digitalbankingbackend.services.BankAccountService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api")
@CrossOrigin("*")
public class OperationRestController {


    private AccountOperationService operationService;
    private BankAccountService accountService;

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/operations/{id}")
    public AccountOperationDTO getOperation(@PathVariable("id") long operationId) throws OperationNotFoundException {
        return operationService.getOperation( operationId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/operations/debit")
    public DebitDTO debiter( @RequestBody DebitDTO debitDTO) throws BankAccountNotFoundExcetion, BalanceNotSufficientException {

        accountService.debit( debitDTO.getAccountId(), debitDTO.getAmount(), debitDTO.getDescription() );
        return debitDTO;

    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/operations/credit")
    public CreditDTO credit(@RequestBody CreditDTO creditDTO) throws BankAccountNotFoundExcetion {

        accountService.credit( creditDTO.getAccountId(), creditDTO.getAmount(), creditDTO.getDescription() );
        return creditDTO;

    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/operations/transfer")
    public TransferRequestDTO transferer(@RequestBody TransferRequestDTO transferRequestDTO) throws BankAccountNotFoundExcetion, BalanceNotSufficientException {

        accountService.transfer(
                transferRequestDTO.getAccountSourceId(),
                transferRequestDTO.getAccountDestinationId(),
                transferRequestDTO.getAmount(),
                transferRequestDTO.getDescription()
        );
        return transferRequestDTO;

    }


}
