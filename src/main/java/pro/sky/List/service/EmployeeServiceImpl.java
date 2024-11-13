package pro.sky.List.service;

import org.springframework.stereotype.Service;
import pro.sky.List.exception.EmployeeAlreadyAddedException;
import pro.sky.List.exception.EmployeeNotFoundException;
import pro.sky.List.model.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;


    public EmployeeServiceImpl() {
        this.employees = new HashMap();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        return null;
    }

    //добавить
    @Override
    public Employee add(String firstName, String lastName, int id, int salary) {
        Employee employee = new Employee(firstName, lastName, id, salary);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        return null;
    }

    //удалить
    @Override
    public Employee remove(String firstName, String lastName, int id, int salary) {
        Employee employee = new Employee(firstName, lastName, id, salary);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    //найти
    @Override
    public Employee find(String firstName, String lastName, int id, int salary) {
        Employee employee = new Employee(firstName, lastName, id, salary);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }

        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
