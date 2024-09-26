package pxl.be.employee.service;

import pxl.be.employee.api.data.EmployeeRequest;
import pxl.be.employee.api.data.EmployeeResponse;
import pxl.be.employee.domain.Employee;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse getEmployeeById(Long employeeId);

    void addEmployee(EmployeeRequest employeeRequest);

    void deleteEmployee(Long employeeId);

    void updateEmployeePosition(Long employeeId, String newPosition);
    EmployeeResponse getEmployeeByDepartmentId(Long departmentId);
    EmployeeResponse getEmployeeByOrganizationid(Long organizationid);
}
