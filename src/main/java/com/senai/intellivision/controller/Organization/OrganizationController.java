package com.senai.intellivision.controller.Organization;

import com.senai.intellivision.domain.macAddress.InputMacAddressToOrgDTO;
import com.senai.intellivision.domain.organization.Organization;
import com.senai.intellivision.domain.organization.OrganizationFactory;
import com.senai.intellivision.domain.organization.OrganizationInputDTO;
import com.senai.intellivision.infra.exception.ObjectMappingException;
import com.senai.intellivision.infra.security.SecurityUtils;
import com.senai.intellivision.service.organization.OrganizationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/organization")
@CrossOrigin(origins = "*")
@Log4j2
public class OrganizationController {
    final OrganizationService organizationService;
    final SecurityUtils securityUtils;

    public OrganizationController(OrganizationService organizationService, SecurityUtils securityUtils) {
        this.organizationService = organizationService;
        this.securityUtils = securityUtils;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody OrganizationInputDTO organizationDTO){
        try {

            organizationService.save(organizationDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", "Organization created successfully"));
        }
        catch (ObjectMappingException e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Organization>> getAll(){
        try {
            return ResponseEntity.ok(organizationService.getAll());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/add-mac-address")
    public ResponseEntity<?> addMacAddress(@RequestBody InputMacAddressToOrgDTO inputMacAddressToOrgDTO){
        try {
            organizationService.addMacAddress(inputMacAddressToOrgDTO);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
