package pxl.be.department.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pxl.be.department.api.data.DepartmentRequest;
import pxl.be.department.api.data.DepartmentResponse;
import pxl.be.department.domain.Department;
import pxl.be.department.domain.Employee;
import pxl.be.department.exception.ResourceNotFoundException;
import pxl.be.department.repository.DepartmentRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DepartmentService implements IDepartmentService {

    private final DepartmentRepository departmentRepository;


    public void addDepartment(DepartmentRequest departmentRequest) {
        Department department = Department.builder()
                .name(departmentRequest.getName())
                .employees(departmentRequest.getEmployees())
                .position(departmentRequest.getPosition())
                .build();
        departmentRepository.save(department);

    }


    public List<DepartmentResponse> getAllDepartments() {
        return departmentRepository.findAll().stream().map(department -> mapToDepartmentResponse(department)).toList();
    }

    public DepartmentResponse getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("Department with Id:" + departmentId + "not found"));
        return mapToDepartmentResponse(department);
    }

//    @Override
//    public DepartmentResponse getDepartmentByOrganizationIdAndEmployees(Long organizationId, List<Employee> employees) {
//        Department department = departmentRepository.findByOrganizationIdAndEmployees(organizationId, employees).orElseThrow(() -> new ResourceNotFoundException("Department with organizationId and employees: " + organizationId + employees +"not found"));
//        return mapToDepartmentResponse(department);
//    }

    @Override
    public DepartmentResponse getDepartmentByOrganizationId(Long organizationId) {
        Department department = departmentRepository.findByOrganizationId(organizationId).orElseThrow(() -> new ResourceNotFoundException("Department with organizationId: "  + organizationId + "not found"));
        return mapToDepartmentResponse(department);

    }

    private DepartmentResponse mapToDepartmentResponse(Department department) {
        return DepartmentResponse.builder()
                .name(department.getName())
                .position(department.getPosition())
                .employees(department.getEmployees())
                .build();
    }

    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    public void updateDepartmentPosition(Long id, String newPosition) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department with Id:" + id + "not found"));
        department.setPosition(newPosition);
        departmentRepository.save(department);

    }
}
