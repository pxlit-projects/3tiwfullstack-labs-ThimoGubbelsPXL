package pxl.be.organisation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pxl.be.organisation.domain.Department;
import pxl.be.organisation.domain.Employee;
import pxl.be.organisation.domain.Organization;

import java.util.List;
import java.util.Optional;


@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Long> {
//    Optional<Organization> findOrganizationByIdAndDepartments(Long id, List<Department> departments);
//    Optional<Organization> findOrganizationByIdAndDepartmentsAndEmployees(Long id, List<Department> departments, List<Employee> employees);
//    Optional<Organization> findOrganizationByIdAndEmployees(Long id, List<Employee> employees);
}
