package com.senai.intellivision.domain.client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Client {
    private String macAddress;
    private String clientUsername;
    private String orgToken;
    private String clientDescription;
}
