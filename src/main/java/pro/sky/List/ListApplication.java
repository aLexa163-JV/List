package pro.sky.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pro.sky.List.model.Employee;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ListApplication {

    public static void main(String[] args) {
        SpringApplication.run(ListApplication.class, args);
    }

    @Bean
    public List<Employee> employees() {
        return Arrays.asList(
                new Employee("Иван", "Иванов", 1, 1000),
                new Employee("Петр", "Петров", 2, 2000),
                new Employee("Сергей", "Сидоров", 3, 3000),
                new Employee("Владимир", "Васильев", 4, 4000),
                new Employee("Федор", "Федоров", 5, 5000),
                new Employee("Ирина", "Кузнецова", 1, 1100),
                new Employee("Елена", "Попова", 2, 1200),
                new Employee("Светлана", "Соколова", 3, 1300),
                new Employee("Мария", "Морозова", 4, 1400),
                new Employee("Юлия", "Семенова", 5, 1500)
        );
    }
}
