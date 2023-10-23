package com.senai.intellivision.domain.organization;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "organization")
@Data
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
    private List<String> macAddressList;
}
