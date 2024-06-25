package com.rca.mireilleumutoni.template.v1.dto.requests;

import com.rca.mireilleumutoni.template.v1.models.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Component
public class CreateCustomerDTO {
    @NotNull
    @Min(2)

    private  String firstName;
    @NotNull
    @Min(2)
    private  String lastName;
    @NotNull
    @Email
    private  String email;
    @NotNull
    @Min(2)
    private  String mobile;
    @NotNull
    @Min(2)

    private Date dob;
    @NotNull
    @Min(2)
    private float balance;
    @NotNull
    @Min(2)
    private Date  lastUpdateDateTime;

}
