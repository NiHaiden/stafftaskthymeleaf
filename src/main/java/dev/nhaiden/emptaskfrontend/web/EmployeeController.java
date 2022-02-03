package dev.nhaiden.emptaskfrontend.web;

import dev.nhaiden.emptaskfrontend.database.EmployeeRepository;
import dev.nhaiden.emptaskfrontend.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public String all(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "emp/overview";
    }

    @GetMapping("/tasks")
    public String allTasks(@RequestParam String id, Model model) {

        Employee employee = employeeRepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("Cant find employee");
        });

        model.addAttribute("tasks", employee.getTasks());

        return "emp/tasks";
    }
}
