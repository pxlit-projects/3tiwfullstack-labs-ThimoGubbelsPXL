package pxl.be.organisation.api.data;

import lombok.*;
import pxl.be.organisation.domain.Department;
import pxl.be.organisation.domain.Employee;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationResponse {

    private String name;

    private List<Employee> employees = new ArrayList<>();

    private List<Department> departments = new ArrayList<>();

    private String address;
}
