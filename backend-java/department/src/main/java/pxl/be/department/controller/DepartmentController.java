package pxl.be.department.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pxl.be.department.domain.Department;
import pxl.be.department.service.DepartmentService;


@RestController
@RequestMapping("/employees")
public class DepartmentController {
    private final DepartmentService departmentService;


    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{departmentId}")
    public Department getEmployee(@PathVariable Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }
    @PostMapping
    public ResponseEntity<Long> addDepartment(@RequestBody @Validated Department department){
        Long id = departmentService.addDepartment(department);
        return new ResponseEntity<Long>(id, HttpStatus.CREATED);
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
