package com.senai.intellivision.controller.Organization;

import com.senai.intellivision.domain.organization.Organization;
import com.senai.intellivision.domain.organization.OrganizationDTO;
import com.senai.intellivision.service.organization.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/organization")
public class OrganizationController {
    final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping
    public ResponseEntity<OrganizationDTO> save(@RequestBody Organization organization){
        try {
            return new ResponseEntity<>(organizationService.save(organization), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
