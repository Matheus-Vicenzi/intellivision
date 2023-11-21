package com.senai.intellivision.domain.organization;

import com.senai.intellivision.domain.orgUser.OrganizationUser;
import com.senai.intellivision.infra.exception.InvalidMacAddressException;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "organization")
@EqualsAndHashCode(of = "orgId")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Organization {
    @Id
    private String orgId;
    private String orgToken;
    private String orgName;
    private String orgDescription;
    private String orgAddress;
    private String orgPhone;
    private String orgEmail;
    private String orgCnpj;
    private LocalDateTime createdAt;
    private Boolean isActive;
    //private OrganizationUser organizationUser;
    @Indexed(unique = true)
    private String login;
    private String password;
    private List<String> macAddressList = new ArrayList<>();

    public void addMacAddress(String macAddress) {
        if (macAddress == null || macAddress.trim().isBlank()){
            throw new InvalidMacAddressException();
        }
        this.macAddressList.add(macAddress.trim());
    }
}
