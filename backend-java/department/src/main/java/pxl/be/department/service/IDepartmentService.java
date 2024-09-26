package pxl.be.department.service;

import pxl.be.department.api.data.DepartmentRequest;
import pxl.be.department.api.data.DepartmentResponse;
import pxl.be.department.domain.Department;
import pxl.be.department.domain.Employee;

import java.util.List;

public interface IDepartmentService {
    List<DepartmentResponse> getAllDepartments();
    DepartmentResponse getDepartmentById(Long departmentId);

    DepartmentResponse getDepartmentByOrganizationIdAndEmployees(Long organizationId, List<Employee> employees);
    DepartmentResponse getDepartmentByOrganizationId(Long organizationId);
    void addDepartment(DepartmentRequest departmentRequest);

    void deleteDepartment(Long departmentId);

    void updateDepartmentPosition(Long departmentId, String newPosition);
}
