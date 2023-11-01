package com.senai.intellivision.service.organization;

import com.senai.intellivision.domain.organization.Organization;
import com.senai.intellivision.infra.exception.InvalidMacAddressException;
import com.senai.intellivision.infra.exception.InvalidTokenException;
import com.senai.intellivision.infra.repositories.organization.OrganizationRepository;
import com.senai.intellivision.service.validation.ValidateMacAndTokenService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {
    final OrganizationRepository organizationRepository;
    final ValidateMacAndTokenService validateMacAndTokenService;

    public OrganizationService(OrganizationRepository organizationRepository, ValidateMacAndTokenService validateMacAndTokenService) {
        this.organizationRepository = organizationRepository;
        this.validateMacAndTokenService = validateMacAndTokenService;
    }

    public Organization save(Organization organizationInputDTO) {
        return organizationRepository.save(organizationInputDTO);
    }

    public List<Organization> getAll() {
        return organizationRepository.findAll();
    }

    public void addMacAddress(String macAddress, String token) {
        validateMacAndTokenService.validateMacAndToken(macAddress, token);

        var organization = organizationRepository.findByOrgToken(token);

        if (organization.isEmpty()) {
            throw new InvalidTokenException();
        }

        if (organization.get().getMacAddressList().contains(macAddress)) {
            throw new InvalidMacAddressException("The mac address informed is already registered in the organization");
        }

    }
}
