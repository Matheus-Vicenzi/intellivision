package com.senai.intellivision.controller.validateMacAndToken;

import com.senai.intellivision.infra.exception.InvalidMacAddressException;
import com.senai.intellivision.infra.exception.InvalidTokenException;
import com.senai.intellivision.service.validation.ValidateMacAndTokenService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validate")
@Log4j2
public class ValidateMacAndTokenController {

    final ValidateMacAndTokenService validateMacAndTokenService;
    public ValidateMacAndTokenController(ValidateMacAndTokenService validateMacAndTokenService) {
        this.validateMacAndTokenService = validateMacAndTokenService;
    }

    @PostMapping("/mac-and-token")
    public ResponseEntity<?> validateMacAndToken(@RequestParam String mac, @RequestParam String token) {
        try {
            validateMacAndTokenService.validateMacAndToken(mac, token);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (InvalidTokenException | InvalidMacAddressException e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().build();
        }
    }
}
