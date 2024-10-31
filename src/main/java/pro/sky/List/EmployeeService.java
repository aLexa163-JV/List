package pro.sky.List;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class EmployeeService{

    private static final int MAX_EMPLOYEES = 10;

    // Коллекция для хранения сотрудников
    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Иван", "Иванов"),
            new Employee("Петр", "Петров"),
            new Employee("Сергей", "Сидоров"),
            new Employee("Владимир", "Владимиров"),
            new Employee("Федор", "Федоров"),
            new Employee("Ирина", "Кузнецова"),
            new Employee("Елена", "Попова"),
            new Employee("Света", "Соколова"),
            new Employee("Мария", "Морозова"),
            new Employee("Юля", "Семенова")
    ));


    //Метод добавления сотрудника
    public void addEmployee(Employee employee) {
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAdded("Сотрудник уже существует");
        }
        if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Максимальное количество сотрудников достигнуто");
        }
        employees.add(employee);
    }

    //Метод удаления сотрудника
    public void removeEmployee(Employee employee) {
        if (employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        employees.remove(employee);
    }
    
    //Метод поиска сотрудника
    public Employee findEmployee(Employee i) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(i.getFirstName()) &&
                employee.getLastName().equals(i.getLastName())) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Не найден сотрудник: " + i.getFirstName() + " " + i.getLastName());
    }
}
