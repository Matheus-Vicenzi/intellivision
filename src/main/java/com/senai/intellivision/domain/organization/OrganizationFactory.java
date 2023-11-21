package com.senai.intellivision.domain.organization;

import com.senai.intellivision.domain.orgUser.OrganizationUser;
import com.senai.intellivision.infra.exception.ObjectMappingException;
import com.senai.intellivision.infra.security.SecurityUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class OrganizationFactory {

    public static Organization dtoToEntity(OrganizationInputDTO organizationDTO) {

        StringBuilder invalidFields = new StringBuilder();
        Organization organization = new Organization();

        if (organizationDTO.orgName() == null || organizationDTO.orgName().isBlank()) {
            invalidFields.append("orgName \n");
        }

        if (organizationDTO.username() == null || organizationDTO.username().isBlank()) {
            invalidFields.append("username \n");
        }

        if (organizationDTO.password() == null || organizationDTO.password().isBlank()) {
            invalidFields.append("password \n");
        }

        organization.setOrgName(organizationDTO.orgName() == null ? "" : organizationDTO.orgName());
        organization.setOrgDescription(organizationDTO.orgDescription() == null ? "" : organizationDTO.orgDescription());
        organization.setOrgAddress(organizationDTO.orgAddress() == null ? "" : organizationDTO.orgAddress());
        organization.setOrgPhone(organizationDTO.orgPhone() == null ? "" : organizationDTO.orgPhone());
        organization.setOrgEmail(organizationDTO.orgEmail() == null ? "" : organizationDTO.orgEmail());
        organization.setOrgCnpj(organizationDTO.orgCnpj() == null ? "" : organizationDTO.orgCnpj());
        organization.setOrgToken(SecurityUtils.generateUniqueToken());
        organization.setCreatedAt(LocalDateTime.now());
        organization.setIsActive(true);
        organization.setLogin(organizationDTO.username());
        organization.setPassword(SecurityUtils.encrypt(organizationDTO.password()));

        organization.setMacAddressList(new ArrayList<>());

        if (!invalidFields.toString().isBlank()){
            throw new ObjectMappingException("Invalid fields - the following fields cannot be null or blank \n" + invalidFields);
        }
        return organization;
    }
}
