package pxl.be.employee.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pxl.be.employee.api.data.EmployeeRequest;
import pxl.be.employee.api.data.EmployeeResponse;
import pxl.be.employee.domain.Employee;
import pxl.be.employee.exception.ResourceNotFoundException;
import pxl.be.employee.repository.EmployeeRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository;


    public List<EmployeeResponse> getAllEmployees() {
         List<Employee> employees = employeeRepository.findAll();
         return employees.stream().map(employee -> mapToEmployeeResponse(employee)).toList();
    }


    public void addEmployee(EmployeeRequest employeeRequest) {
        Employee employee = Employee.builder()
                .age(employeeRequest.getAge())
                .name(employeeRequest.getName())
                .position(employeeRequest.getPosition()).build();
        employeeRepository.save(employee);
    }

    public EmployeeResponse getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee with Id:" + employeeId + "not found"));
        return mapToEmployeeResponse(employee);
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public void updateEmployeePosition(Long id, String newPosition) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with Id:" + id + "not found"));
        employee.setPosition(newPosition);
        employeeRepository.save(employee);

    }

    @Override
    public EmployeeResponse getEmployeeByDepartmentId(Long departmentId) {
        Employee employee = employeeRepository.findEmployeeByDepartmentId(departmentId).orElseThrow(() -> new ResourceNotFoundException("Employee with department:" + departmentId + "not found"));
        return mapToEmployeeResponse(employee);
    }

    @Override
    public EmployeeResponse getEmployeeByOrganizationid(Long organizationid) {
        Employee employee = employeeRepository.findEmployeeByOrganizationId(organizationid).orElseThrow(() -> new ResourceNotFoundException("Employee with organizationId:" + organizationid + "not found"));
        return mapToEmployeeResponse(employee);
    }


    private EmployeeResponse mapToEmployeeResponse(Employee employee) {
        return EmployeeResponse.builder()
                .age(employee.getAge())
                .name(employee.getName())
                .position(employee.getPosition())
                .build();
    }

}
