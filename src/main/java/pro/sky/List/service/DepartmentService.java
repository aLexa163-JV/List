package pro.sky.List.service;

import pro.sky.List.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Employee maxSalaryByDepartment(int id);

    Employee minSalaryByDepartment(int id);

    List<Employee> getAllEmployeesByDepartment(int id);

    Map<Integer, List<Employee>> getAllEmployeesByDepartments();
}
