package pxl.be.department.service;

import org.springframework.stereotype.Service;
import pxl.be.department.domain.Department;
import pxl.be.department.repository.DepartmentRepository;
import pxl.be.employee.exception.ResourceNotFoundException;


@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;


    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Long addDepartment(Department department){

        departmentRepository.save(department);
        return department.getId();
    }
    public Department getDepartmentById(Long departmentId){
        Department department = departmentRepository.findById(departmentId).orElseThrow(()-> new ResourceNotFoundException("Department with Id:" + departmentId + "not found"));
        return department;
    }

    public void deleteDepartment(Long departmentId){
        departmentRepository.deleteById(departmentId);
    }

    public void updateDepartmentPosition(Long id, String newPosition){
        Department department = departmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department with Id:" + id + "not found"));
        department.setPosition(newPosition);
        departmentRepository.save(department);

    }
}
