package com.rca.mireilleumutoni.template.v1.dto.requests;

import com.rca.mireilleumutoni.template.v1.enums.AccountType;
import com.rca.mireilleumutoni.template.v1.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Component

public class CreateAccountDTO {
    @NotNull
    @NotBlank
    private String accountNumber;
    @NotNull
    @NotBlank
    private String accountType ;
    @NotNull
    @NotBlank
    private UUID customerId;
    @NotNull
    @NotBlank
    private float balance;
    @NotNull
    @NotBlank
    private float amount ;
}
