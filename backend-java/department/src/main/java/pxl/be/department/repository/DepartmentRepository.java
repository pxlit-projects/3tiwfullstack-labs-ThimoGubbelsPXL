package pxl.be.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pxl.be.department.domain.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
