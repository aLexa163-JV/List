package pro.sky.List.service;

import pro.sky.List.model.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee add(String firstName, String lastName);

    //добавить
    Employee add(String firstName, String lastName, int id, int salary);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    //удалить
    Employee remove(String firstName, String lastName, int id, int salary);

    //найти
    Employee find(String firstName, String lastName, int id, int salary);

    Collection<Employee> findAll();
}
