package com.rca.mireilleumutoni.template.v1.dto.requests;

import com.rca.mireilleumutoni.template.v1.models.Account;
import com.rca.mireilleumutoni.template.v1.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Component

public class CreateWithdrawDTO {
    @NotNull
    @NotBlank
    private UUID customerId;
    @NotNull
    @NotBlank
    private UUID accountId;
    @NotNull
    @NotBlank
    private float amount;
    @NotNull
    @NotBlank
    private Date bankingTime ;

}
