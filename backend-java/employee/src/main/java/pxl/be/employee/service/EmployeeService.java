package pxl.be.employee.service;

import org.springframework.stereotype.Service;
import pxl.be.employee.api.data.EmployeeDTO;
import pxl.be.employee.domain.Employee;
import pxl.be.employee.exception.ResourceNotFoundException;
import pxl.be.employee.repository.EmployeeRepository;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Long addEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee(employeeDTO);
        employeeRepository.save(employee);
        return employee.getId();
    }
    public EmployeeDTO getEmployeeById(Long employeeId){
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee with Id:" + employeeId + "not found"));
        return new EmployeeDTO(employee);
    }

    public void deleteEmployee(Long employeeId){
        employeeRepository.deleteById(employeeId);
    }

    public void updateEmployeePosition(Long id, String newPosition){
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee with Id:" + id + "not found"));
        employee.setPosition(newPosition);
        employeeRepository.save(employee);

    }
}
