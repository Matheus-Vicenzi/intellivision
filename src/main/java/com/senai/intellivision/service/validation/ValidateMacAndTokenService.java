package com.senai.intellivision.service.validation;

import com.senai.intellivision.infra.exception.InvalidMacAddressException;
import com.senai.intellivision.infra.exception.InvalidTokenException;
import com.senai.intellivision.infra.repositories.organization.OrganizationRepository;
import org.springframework.stereotype.Service;

@Service
public class ValidateMacAndTokenService {
    final OrganizationRepository organizationRepository;

    public ValidateMacAndTokenService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public void validateMacAndToken(String mac, String token) {
        var org = organizationRepository.findByOrgToken(token);
        if (org.isEmpty()) {
            throw new InvalidTokenException();
        }
        if (!org.get().getMacAddressList().contains(mac)) {
            throw new InvalidMacAddressException("The mac address informed is not registered in the organization");
        }
    }
}
