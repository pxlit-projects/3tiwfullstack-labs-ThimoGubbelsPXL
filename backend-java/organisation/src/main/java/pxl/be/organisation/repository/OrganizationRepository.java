package pxl.be.organisation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pxl.be.organisation.domain.Organization;


@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Long> {
}
