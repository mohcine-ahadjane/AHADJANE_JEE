package ma.ahadjane.digitalbankingbackend.services;

import ma.ahadjane.digitalbankingbackend.dtos.BankAccountDTO;
import ma.ahadjane.digitalbankingbackend.dtos.CurrentBankAccountDTO;
import ma.ahadjane.digitalbankingbackend.dtos.SavingBankAccountDTO;
import ma.ahadjane.digitalbankingbackend.entities.CurrentAccount;
import ma.ahadjane.digitalbankingbackend.entities.SavingAccount;
import ma.ahadjane.digitalbankingbackend.exceptions.BalanceNotSufficientException;
import ma.ahadjane.digitalbankingbackend.exceptions.BankAccountNotFoundExcetion;
import ma.ahadjane.digitalbankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {


    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, String customerId) throws CustomerNotFoundException;

    BankAccountDTO updateCurrentBankAccount(CurrentAccount currentAccount) throws BankAccountNotFoundExcetion;

    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, String customerId) throws CustomerNotFoundException;


    BankAccountDTO updateSavingBankAccount(SavingAccount savingAccount) throws BankAccountNotFoundExcetion;

    BankAccountDTO getBankAccount(String bankAccountId) throws BankAccountNotFoundExcetion;

    void debit( String accountId, double amount, String description) throws BankAccountNotFoundExcetion, BalanceNotSufficientException;

    void credit( String accountId, double amount, String description) throws BankAccountNotFoundExcetion;

    void transfer( String accountSourceId, String accountDestinationId, double amount, String description) throws BankAccountNotFoundExcetion, BalanceNotSufficientException;

    List<BankAccountDTO> listBankAccountDTO();

    void deleteAccount(String accountId);
}
