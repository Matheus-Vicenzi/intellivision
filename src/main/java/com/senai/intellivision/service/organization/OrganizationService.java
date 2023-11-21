package com.senai.intellivision.service.organization;

import com.senai.intellivision.domain.macAddress.InputMacAddressToOrgDTO;
import com.senai.intellivision.domain.organization.Organization;
import com.senai.intellivision.domain.organization.OrganizationFactory;
import com.senai.intellivision.domain.organization.OrganizationInputDTO;
import com.senai.intellivision.infra.exception.InvalidMacAddressException;
import com.senai.intellivision.infra.exception.InvalidTokenException;
import com.senai.intellivision.infra.repositories.organization.OrganizationRepository;
import com.senai.intellivision.service.validation.ValidateMacAndTokenService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class OrganizationService {
    final OrganizationRepository organizationRepository;
    final ValidateMacAndTokenService validateMacAndTokenService;

    public OrganizationService(OrganizationRepository organizationRepository, ValidateMacAndTokenService validateMacAndTokenService) {
        this.organizationRepository = organizationRepository;
        this.validateMacAndTokenService = validateMacAndTokenService;
    }

    public Organization save(OrganizationInputDTO organizationInputDTO) {
        Organization organization = OrganizationFactory.dtoToEntity(organizationInputDTO);
        return organizationRepository.save(organization);
    }

    public List<Organization> getAll() {
        return organizationRepository.findAll();
    }

    public void addMacAddress(InputMacAddressToOrgDTO inputMacAddressToOrgDTO) {

        var organization = organizationRepository.findByOrgToken(inputMacAddressToOrgDTO.token());

        if (organization.isEmpty()) {
            log.error("Invalid token");
            throw new InvalidTokenException();
        }

        if (organization.get().getMacAddressList().contains(inputMacAddressToOrgDTO.macAddress())) {
            log.info("The mac address informed is already registered in the organization");
            return;
        }

        organization.get().addMacAddress(inputMacAddressToOrgDTO.macAddress());

        organizationRepository.save(organization.get());

    }
}
