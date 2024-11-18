package pro.sky.List.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.List.model.Employee;
import pro.sky.List.service.DepartmentService;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/max-salary")
    public Employee getMaxSalaryByDepartment(@RequestParam int id) {
        return service.maxSalaryByDepartment(id);
    }

    @GetMapping("/min-salary")
    public Employee getMinSalaryByDepartment(@RequestParam int id) {
        return service.minSalaryByDepartment(id);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployeesByDepartment(@RequestParam int id) {
        return service.getAllEmployeesByDepartment(id);
    }

    @GetMapping("/all2")
    public Map<Integer, List<Employee>> getAllEmployeesByDepartments() {
        return service.getAllEmployeesByDepartments();
    }


}
