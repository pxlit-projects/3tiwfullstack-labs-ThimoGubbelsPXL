package pxl.be.department.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pxl.be.department.api.data.DepartmentRequest;
import pxl.be.department.api.data.DepartmentResponse;
import pxl.be.department.domain.Department;
import pxl.be.department.domain.Employee;
import pxl.be.department.service.DepartmentService;
import pxl.be.department.service.IDepartmentService;
import pxl.be.employee.api.data.EmployeeRequest;

import java.util.List;


@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final IDepartmentService departmentService;


    @GetMapping
    public ResponseEntity getDepartments(){
        return new ResponseEntity(departmentService.getAllDepartments(), HttpStatus.OK);
    }

    @GetMapping("/{departmentId}")
    public DepartmentResponse getDepartmentById(@PathVariable Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @GetMapping("/organization/{organizationId}")
    public DepartmentResponse getDepartmentByOrganizationId(@PathVariable Long organizationId){
        return departmentService.getDepartmentByOrganizationId(organizationId);

    }

//    @GetMapping("/organization/{organizationId}/with-employees")
//    public DepartmentResponse getDepartmentByOrganizationId(@PathVariable Long organizationId, @RequestBody List<Employee> employees){
//        return departmentService.getDepartmentByOrganizationIdAndEmployees(organizationId, employees);
//
//    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addDepartment(@RequestBody @Validated DepartmentRequest departmentRequest){
        departmentService.addDepartment(departmentRequest);

    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Department with id: " + departmentId + " deleted");
    }

    @PutMapping("/{employeeId}/position")
    public ResponseEntity<String> updateEmployeePosition(@PathVariable Long departmentId, @RequestBody String newPosition){
        departmentService.updateDepartmentPosition(departmentId,newPosition);
        return ResponseEntity.ok("Department with id: " + departmentId + " position updated to: "+ newPosition);
    }
}
