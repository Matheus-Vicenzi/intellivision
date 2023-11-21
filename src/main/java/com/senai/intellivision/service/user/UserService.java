package com.senai.intellivision.service.user;

import com.senai.intellivision.domain.orgUser.InputLoginDTO;
import com.senai.intellivision.infra.repositories.organization.OrganizationRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    OrganizationRepository organizationRepository;

    UserService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public void validateLogin(InputLoginDTO inputLoginDTO) {
        //implementar
    }
}
