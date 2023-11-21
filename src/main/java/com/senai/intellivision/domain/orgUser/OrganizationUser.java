package com.senai.intellivision.domain.orgUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@AllArgsConstructor
public class OrganizationUser {
    @Indexed(unique = true)
    private String username;
    private String password;
    private String token;
}
