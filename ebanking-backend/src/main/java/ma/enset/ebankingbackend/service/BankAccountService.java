package ma.enset.ebankingbackend.service;

import ma.enset.ebankingbackend.dtos.BankAccountDTO;
import ma.enset.ebankingbackend.dtos.CurrentAccountDTO;
import ma.enset.ebankingbackend.dtos.CustomerDTO;
import ma.enset.ebankingbackend.dtos.SavingAccountDTO;
import ma.enset.ebankingbackend.entities.BankAccount;
import ma.enset.ebankingbackend.entities.CurrentAccount;
import ma.enset.ebankingbackend.entities.Customer;
import ma.enset.ebankingbackend.entities.SavingAccount;
import ma.enset.ebankingbackend.exceptions.BalanceNotSufficientException;
import ma.enset.ebankingbackend.exceptions.BankAccountNotFoundException;
import ma.enset.ebankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    CustomerDTO saveCustumer(CustomerDTO customerDTO);
    CurrentAccountDTO saveCurrentBankAccount(double intialBalance, double overDraft, Long CustomerId) throws CustomerNotFoundException;
    SavingAccountDTO saveSavingBankAccount(double intialBalance, double interestRate, Long CustomerId) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomers();
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    void  debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;

    List<BankAccountDTO> bankAccountList();

    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    CustomerDTO updateCustumer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);
}
