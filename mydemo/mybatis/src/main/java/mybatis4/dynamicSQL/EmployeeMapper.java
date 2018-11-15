package mybatis4.dynamicSQL;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> getEmpsByConditionIf(Employee employee);

    List<Employee> getEmpsByConditionTrim(Employee employee);
}
