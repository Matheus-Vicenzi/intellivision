package com.senai.intellivision.service.organization;

import com.senai.intellivision.infra.db.organization.OrganizationRepository;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService{
    final OrganizationRepository organizationRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }
}
