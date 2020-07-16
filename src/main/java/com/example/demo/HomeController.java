package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class HomeController {
    ArrayList<Employee> listOfEmployee = new ArrayList<>();
    @GetMapping("/welcome")
    public String welcomePage() {
        return "welcome";
    }
    @GetMapping("/addEmployee")
    public String loadEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employeeForm";
    }

    @PostMapping("/listAll")
    public String processEmployeeForm(@ModelAttribute Employee employee,
                                     BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "employeeForm";
        }

        listOfEmployee.add(employee);
        model.addAttribute("allEmployees", listOfEmployee);
        return "listAll";
    }

    @GetMapping("/listAll")
    public String listAllEmployee(Model model) {
        model.addAttribute("allEmployees", listOfEmployee);
        return "listAll";
    }

}

