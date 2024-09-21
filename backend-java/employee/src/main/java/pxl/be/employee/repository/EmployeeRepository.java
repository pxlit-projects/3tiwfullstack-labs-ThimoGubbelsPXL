package pxl.be.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pxl.be.employee.domain.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
