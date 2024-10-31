package pro.sky.List;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/add")
    public String add(@RequestParam("firstName") String firstName,
                      @RequestParam("lastName") String lastName) {

        Employee employee = new Employee(firstName, lastName);
        employeeService.addEmployee(employee);
        return "Добавлен новый сотрудник";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName) {

        Employee employee = new Employee(firstName, lastName);
        employeeService.removeEmployee(employee);
        return "Сотрудник удален";
    }

    @GetMapping("/find")
    public String find(@RequestParam("firstName") String firstName,
                       @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employeeService.findEmployee(employee);
        return "Сотрудник найден";
    }

}
