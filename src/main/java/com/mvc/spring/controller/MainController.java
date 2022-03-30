package com.mvc.spring.controller;

import com.mvc.spring.entity.Employee;
import com.mvc.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "show-emp-details";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("emp", employee);
        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("emp") Employee employee) {

        employeeService.addEmployee(employee);

        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") Long id, Model model) {

        Employee employee = employeeService.get(id);
        model.addAttribute("emp", employee);
        return "employee-info";
    }
@RequestMapping("/deleteEmployee")
    public String delete(@RequestParam("empId") Long id){
        employeeService.delete(id);
        return "redirect:/";
    }
}
