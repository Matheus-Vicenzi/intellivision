package com.senai.intellivision.domain.client;

import lombok.Data;

@Data
public class Client {
    private String macAddress;
    private String clientUsername;
    private String clientDescription;
    private String organizationName;
}
