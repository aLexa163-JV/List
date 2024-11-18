package pro.sky.List.service;

import jakarta.annotation.PostConstruct;
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

    @PostConstruct
    public void init() {
        Employee employee = new Employee("Иванов", "Иван", 1, 1000);
        employees.put(employee.getFullName(), employee);
        Employee employee1 = new Employee("Петров", "Петр", 2, 2000);
        employees.put(employee1.getFullName(), employee1);
        Employee employee2 = new Employee("Сидоров", "Сергей", 3, 3000);
        employees.put(employee2.getFullName(), employee2);
        Employee employee3 = new Employee("Васильев", "Владимир", 4, 4000);
        employees.put(employee3.getFullName(), employee3);
        Employee employee4 = new Employee("Федоров", "Федор", 5, 5000);
        employees.put(employee4.getFullName(), employee4);
        Employee employee5 = new Employee("Кузнецова", "Ирина", 1, 6000);
        employees.put(employee5.getFullName(), employee5);
        Employee employee6 = new Employee("Попова", "Елена", 2, 7000);
        employees.put(employee6.getFullName(), employee6);
        Employee employee7 = new Employee("Соколова", "Светлана", 3, 8000);
        employees.put(employee7.getFullName(), employee7);
        Employee employee8 = new Employee("Морозова", "Мария", 4, 9000);
        employees.put(employee8.getFullName(), employee8);
        Employee employee9 = new Employee("Семенова", "Юлия", 5, 10000);
        employees.put(employee9.getFullName(), employee9);
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
        if (employees.containsKey(firstName + " " + lastName)) {
            return employees.remove(firstName + " " + lastName);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        if (!employees.containsKey(firstName + " " + lastName)) {
            throw new EmployeeAlreadyAddedException();
        }
        Employee employee = new Employee(firstName, lastName);
        return employees.put(employee.getFullName(), employee);
    }


    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
