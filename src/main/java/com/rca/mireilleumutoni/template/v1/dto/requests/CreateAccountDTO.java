package com.rca.mireilleumutoni.template.v1.dto.requests;

import com.rca.mireilleumutoni.template.v1.enums.AccountType;
import com.rca.mireilleumutoni.template.v1.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Component

public class CreateAccountDTO {
    private String accountNumber;
    private AccountType accountType ;
    private UUID customerId;
    private float balance;
    private float amount ;
}
