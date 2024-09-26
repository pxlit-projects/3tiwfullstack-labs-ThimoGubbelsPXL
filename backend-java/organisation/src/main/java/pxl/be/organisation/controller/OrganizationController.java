package pxl.be.organisation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pxl.be.department.domain.Department;
import pxl.be.department.service.DepartmentService;
import pxl.be.organisation.domain.Organization;
import pxl.be.organisation.service.OrganizationService;


@RestController
@RequestMapping("/employees")
public class OrganizationController {
    private final OrganizationService organizationService;


    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/{organizationId}")
    public Organization getOrganiztion(@PathVariable Long organizationId){
        return organizationService.getOrganizationById(organizationId);
    }
    @PostMapping
    public ResponseEntity<Long> addOrganization(@RequestBody @Validated Organization organization){
        Long id = organizationService.addOrganization(organization);
        return new ResponseEntity<Long>(id, HttpStatus.CREATED);
    }

    @DeleteMapping("/{organizationId}")
    public ResponseEntity<String> deleteOrganiztion(@PathVariable Long organizationId){
        organizationService.deleteOrganization(organizationId);
        return ResponseEntity.ok("Organization with id: " + organizationId + " deleted");
    }

    @PutMapping("/{organizationId}/address")
    public ResponseEntity<String> updateOrganizationAddress(@PathVariable Long organizationId, @RequestBody String newAddress){
        organizationService.updateOrganizationAddress(organizationId,newAddress);
        return ResponseEntity.ok("Organization with id: " + organizationId + " address updated to: "+ newAddress);
    }
}
