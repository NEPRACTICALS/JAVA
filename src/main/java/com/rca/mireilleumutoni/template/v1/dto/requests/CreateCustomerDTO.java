package com.rca.mireilleumutoni.template.v1.dto.requests;

import com.rca.mireilleumutoni.template.v1.models.Account;
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
public class CreateCustomerDTO {
    private  String firstName;
    private  String lastName;
    private  String email;
    private  String mobile;
    private Date dob;
    private float balance;
    private Date  lastUpdateDateTime;

}
