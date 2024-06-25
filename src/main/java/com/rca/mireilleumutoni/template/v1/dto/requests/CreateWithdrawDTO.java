package com.rca.mireilleumutoni.template.v1.dto.requests;

import com.rca.mireilleumutoni.template.v1.models.Account;
import com.rca.mireilleumutoni.template.v1.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Component

public class CreateWithdrawDTO {
    private UUID customerId;
    private UUID accountId;
    private float amount;
    private Date bankingTime ;

}
