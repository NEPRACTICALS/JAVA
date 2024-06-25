package com.rca.mireilleumutoni.template.v1.serviceImpls;

import com.rca.mireilleumutoni.template.v1.dto.requests.CreateAccountDTO;
import com.rca.mireilleumutoni.template.v1.models.Account;
import com.rca.mireilleumutoni.template.v1.models.Customer;
import com.rca.mireilleumutoni.template.v1.repositories.AccountRepository;
import com.rca.mireilleumutoni.template.v1.repositories.CustomerRepository;
import com.rca.mireilleumutoni.template.v1.services.AccountService;
import com.rca.mireilleumutoni.template.v1.services.CustomerService;
import com.rca.mireilleumutoni.template.v1.utils.ExceptionUtils;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    @Lazy
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;
    private  final EmailService emailService ;


    @Override
    public Account createAccount(CreateAccountDTO createAccountDTO) {
        try {
            Customer customer = customerRepository.findById(createAccountDTO.getCustomerId()).orElseThrow(() -> new RuntimeException("Customer not found"));
            Account account = new Account();
            account.setAccountNumber(createAccountDTO.getAccountNumber());
            account.setAccountType(createAccountDTO.getAccountType());
            account.setBalance(createAccountDTO.getBalance());
            account.setAmount(createAccountDTO.getAmount());
            account.setCustomer(customerService.getCustomerById(createAccountDTO.getCustomerId()));
            return accountRepository.save(account);
        } catch (Exception e) {
            ExceptionUtils.handleServiceExceptions(e);
        }
        return null;
    }

    @Override
    public Account getAccountById(UUID accountId) {
        try {
            return accountRepository.findById(accountId)
                    .orElseThrow(() -> new RuntimeException("Account not found"));
        } catch (Exception e) {
            ExceptionUtils.handleServiceExceptions(e);
        }
        return null;
    }

    @Override
    public Account getAccountByCustomerId(UUID customerId) {
        try {
            return accountRepository.findAccountsByCustomerId(customerId)
                    .orElseThrow(() -> new RuntimeException("Account not found"));
        } catch (Exception e) {
            ExceptionUtils.handleServiceExceptions(e);
        }
        return null;
    }

    @Override
    public List<Account> getAllAccounts() {
        try {
            return accountRepository.findAll();
        } catch (Exception e) {
            ExceptionUtils.handleServiceExceptions(e);
        }
        return null;
    }

    @Override
    public void withdraw(UUID accountId, float amount) {
        try {
            Account account = accountRepository.findById(accountId)
                    .orElseThrow(() -> new RuntimeException("Account not found"));

            Customer customer = account.getCustomer();

            if (account.getBalance() < amount) {
                throw new RuntimeException("Insufficient balance");
            }

            account.setBalance(account.getBalance() - amount);
            accountRepository.save(account);

            String subject = "Withdrawal Notification";
            String body = String.format("Dear %s, your withdrawal of %.2f from account %s has been completed successfully.",
                    customer.getFirstName(), amount, account.getId());

            emailService.sendEmail(customer.getEmail(), subject, body);

        } catch (Exception e) {
            ExceptionUtils.handleServiceExceptions(e);
        }
    }

    @Override
    public void deposit(UUID accountId, float amount) {
        try {
            Account account = accountRepository.findById(accountId)
                    .orElseThrow(() -> new RuntimeException("Account not found"));

            Customer customer = account.getCustomer();

            account.setBalance(account.getBalance() + amount);
            accountRepository.save(account);

            String subject = "Deposit Notification";
            String body = String.format("Dear %s, your deposit of %.2f to account %s has been completed successfully.",
                    customer.getFirstName(), amount, account.getId());

            emailService.sendEmail(customer.getEmail(), subject, body);

        } catch (Exception e) {
            ExceptionUtils.handleServiceExceptions(e);
        }
    }
}
