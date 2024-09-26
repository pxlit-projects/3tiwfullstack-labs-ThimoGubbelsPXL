package pxl.be.organisation.service;

import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import pxl.be.department.repository.DepartmentRepository;
import pxl.be.employee.exception.ResourceNotFoundException;
import pxl.be.organisation.domain.Organization;
import pxl.be.organisation.repository.OrganizationRepository;


@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;


    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public Long addOrganization(Organization organization){
        organizationRepository.save(organization);
        return organization.getId();
    }
    public Organization getOrganizationById(Long organizationId){
        return organizationRepository.findById(organizationId).orElseThrow(()-> new ResourceNotFoundException("Organization with Id:" + organizationId + "not found"));
    }

    public void deleteOrganization(Long organizationId){
        organizationRepository.deleteById(organizationId);
    }

    public void updateOrganizationAddress(Long id, String newAddress){
        Organization organization = organizationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Organization with Id:" + id + "not found"));
        organization.setAddress(newAddress);
        organizationRepository.save(organization);

    }
}
