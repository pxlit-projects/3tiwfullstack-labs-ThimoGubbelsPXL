package pxl.be.employee.api.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import pxl.be.employee.domain.Employee;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
    private Long id;

    private Long organizationId;

    private Long departmentId;

    private String name;

    private int age;

    private String position;



}
