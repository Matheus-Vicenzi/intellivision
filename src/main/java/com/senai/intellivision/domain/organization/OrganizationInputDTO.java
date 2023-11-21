package com.senai.intellivision.domain.organization;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record OrganizationInputDTO(@NotBlank String orgName,
                              String orgDescription,
                              String orgAddress,
                              String orgPhone,
                              @Email String orgEmail,
                              String orgCnpj,
                              @NotBlank String username,
                              @NotBlank String password) {
}
