package pro.sky.List.service;

import org.springframework.stereotype.Service;
import pro.sky.List.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
public class DepartmentServiceImpl implements DepartmentService {


    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public Employee maxSalaryByDepartment(int id) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getId() == id)
                .max((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()))
                .orElseThrow(()-> new NoSuchElementException("No employee found in department with ID " + id));
    }

    @Override
    public Employee minSalaryByDepartment(int id) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getId() == id)
                .min((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()))
                .orElseThrow(()-> new NoSuchElementException("No employee found in department with ID " + id));
    }

    @Override
    public List<Employee> getAllEmployeesByDepartment(int id) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getId() == id)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesByDepartments() {
        return employeeService.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getId));
    }

}
