package ma.enset.ebankingbackend.service;

import ma.enset.ebankingbackend.entities.BankAccount;
import ma.enset.ebankingbackend.entities.CurrentAccount;
import ma.enset.ebankingbackend.entities.SavingAccount;
import ma.enset.ebankingbackend.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    public void cosulter(){
            BankAccount bankAccount=
                    bankAccountRepository.findById("1f9806a5-77cd-4c46-98cf-ce1b67eab1ac").orElse(null);
            if (bankAccount!=null) {
                System.out.println("*****************************************");
                System.out.println(bankAccount.getId());
                System.out.println(bankAccount.getBalance());
                System.out.println(bankAccount.getStatus());
                System.out.println(bankAccount.getCreatedAt());
                System.out.println(bankAccount.getCustomer().getName());
                System.out.println(bankAccount.getClass().getSimpleName());
                if (bankAccount instanceof CurrentAccount) {
                    System.out.println("OverDraft =>" + ((CurrentAccount) bankAccount).getOverDraft());
                } else if (bankAccount instanceof SavingAccount) {
                    System.out.println("Rate=>" + ((SavingAccount) bankAccount).getInterestRate());
                }
                bankAccount.getAccountOperations().forEach(op -> {
                    System.out.println(op.getType() + "\t " + op.getOperationDate() + "\t" + op.getAmount());
                });
            }
    }
}

