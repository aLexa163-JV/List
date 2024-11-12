package pro.sky.List.service;

import org.springframework.stereotype.Service;
import pro.sky.List.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final List<Employee> employees;

    public DepartmentServiceImpl(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Employee maxSalaryByDepartment(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .max((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()))
                .orElse(null);
    }

    @Override
    public Employee minSalaryByDepartment(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .min((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()))
                .orElse(null);
    }

    @Override
    public List<Employee> getAllEmployeesByDepartment(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesByDepartments() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getId));
    }

}
