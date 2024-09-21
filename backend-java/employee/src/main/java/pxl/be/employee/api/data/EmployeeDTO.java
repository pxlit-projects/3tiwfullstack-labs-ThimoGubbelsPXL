package pxl.be.employee.api.data;

import org.antlr.v4.runtime.misc.NotNull;
import pxl.be.employee.domain.Employee;


public class EmployeeDTO {
    private Long id;

    private Long organizationId;

    private Long departmentId;
    @NotNull
    private String name;
    @NotNull
    private int age;
    @NotNull
    private String position;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.organizationId = employee.getOrganizationId();
        this.departmentId = employee.getDepartmentId();
        this.name = employee.getName();
        this.age = employee.getAge();
        this.position = employee.getPosition();
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }
}
