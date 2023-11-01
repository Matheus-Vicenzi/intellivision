package com.senai.intellivision.domain.organization;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record OrganizationInputDTO(String orgName,
                              String orgDescription,
                              String orgAddress,
                              String orgPhone,
                              @Email String orgEmail,
                              String orgCnpj,
                              String orgToken,
                              List<String> macAddressList) {
}
