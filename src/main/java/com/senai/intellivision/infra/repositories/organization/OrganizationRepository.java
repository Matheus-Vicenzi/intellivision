package com.senai.intellivision.infra.repositories.organization;

import com.senai.intellivision.domain.organization.Organization;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OrganizationRepository extends MongoRepository<Organization, String> {
    Optional<Organization> findByOrgToken(String token);
}
