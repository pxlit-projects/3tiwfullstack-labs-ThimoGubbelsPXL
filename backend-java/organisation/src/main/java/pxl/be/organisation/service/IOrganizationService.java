package pxl.be.organisation.service;

import pxl.be.organisation.domain.Organization;

public interface IOrganizationService {
    Organization getOrganizationById(Long organizationId);

    Long addOrganization(Organization organization);

    void deleteOrganization(Long organizationId);

    void updateOrganizationAddress(Long organizationId, String newAddress);
}
