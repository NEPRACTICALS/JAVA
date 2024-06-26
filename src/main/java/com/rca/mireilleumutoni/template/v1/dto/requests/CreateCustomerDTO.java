package com.rca.mireilleumutoni.template.v1.dto.requests;

import com.rca.mireilleumutoni.template.v1.models.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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
    @NotBlank

    private  String firstName;
    @NotNull
    @Min(2)
    @NotBlank
    private  String lastName;
    @NotNull
    @NotBlank
    @Email

    private  String email;
    @NotNull
    @NotBlank
    @Min(2)
    private  String mobile;
    @NotNull
    @NotBlank
    @Min(2)

    private Date dob;
    @NotNull
    @NotBlank
    @Min(2)
    private float balance;
    @NotNull
    @NotBlank
    @Min(2)
    private Date  lastUpdateDateTime;

}
