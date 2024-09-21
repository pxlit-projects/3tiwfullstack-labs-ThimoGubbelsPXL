package pxl.be.employee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pxl.be.employee.api.data.EmployeeDTO;
import pxl.be.employee.service.EmployeeService;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }
    @PostMapping
    public ResponseEntity<Long> addEmployee(@RequestBody @Validated EmployeeDTO employeeDTO){
        Long id = employeeService.addEmployee(employeeDTO);
        return new ResponseEntity<Long>(id, HttpStatus.CREATED);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee with id: " + employeeId + " deleted");
    }

    @PutMapping("/{employeeId}/position")
    public ResponseEntity<String> updateEmployeePosition(@PathVariable Long employeeId, @RequestBody String newPosition){
        employeeService.updateEmployeePosition(employeeId,newPosition);
        return ResponseEntity.ok("Employee with id: " + employeeId + " position updated to: "+ newPosition);
    }
}
