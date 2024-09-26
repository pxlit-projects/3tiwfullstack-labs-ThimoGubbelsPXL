package pxl.be.organisation.domain;

import jakarta.persistence.*;
import lombok.Getter;
import pxl.be.department.domain.Department;
import pxl.be.employee.domain.Employee;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    private Long organizationId;
    @Getter
    private String name;
    @Getter
    @Transient
    private List<Employee> employees = new ArrayList<>();
    @Getter
    @Transient
    private List<Department> departments = new ArrayList<>();
    @Getter
    private String address;

    public Organization() {
    }


    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
