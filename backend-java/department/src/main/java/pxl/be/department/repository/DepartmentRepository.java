package pxl.be.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pxl.be.department.domain.Department;
import pxl.be.department.domain.Employee;

import java.util.List;
import java.util.Optional;


@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Optional<Department> findByOrganizationId(Long organizationId);
    Optional<Department> findByOrganizationIdAndEmployees(Long organizationId, List<Employee> employeeList);
}
