package pro.sky.List.service;

import org.springframework.stereotype.Service;
import pro.sky.List.model.Employee;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class DepartmentServiceImpl implements DepartmentService {


    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee maxSalaryByDepartment(int id) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.getId() == id)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(()-> new NoSuchElementException("Не найден сотрудник: " + id));
    }

    @Override
    public Employee minSalaryByDepartment(int id) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.getId() == id)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(()-> new NoSuchElementException("Не найден сотрудник: " + id));
    }

    @Override
    public List<Employee> getAllEmployeesByDepartment(int id) {
        return employeeService
                .findAll()
                .stream()
                .filter(employee -> employee.getId() == id)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesByDepartments() {
        return employeeService
                .findAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getId));
    }

}
