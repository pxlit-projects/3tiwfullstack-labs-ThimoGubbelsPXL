package pxl.be.organisation.api.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pxl.be.organisation.domain.Department;
import pxl.be.organisation.domain.Employee;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentAndEmployeeFilter {

    List<Department> departments;
    List<Employee> employees;
}
