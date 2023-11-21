package com.senai.intellivision.infra.security;

import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.time.LocalDateTime;

@Component
public class SecurityUtils {

    public static String generateUniqueToken() {
        return BCrypt.hashpw(LocalDateTime.now().toString(), BCrypt.gensalt());
    }

    public static String encrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
