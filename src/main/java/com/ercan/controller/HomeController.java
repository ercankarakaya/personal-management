package com.ercan.controller;


import com.ercan.entity.Employee;
import com.ercan.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public String show(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employee employee = employeeService.findUserByUsername(auth.getName());
        model.addAttribute("employee_id", employee.getId());
        System.out.println(employee.getId());
        return "index";
    }

    @GetMapping(value = "/user")
    public ModelAndView emp(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employee employee = employeeService.findUserByUsername(auth.getName());
        // modelAndView.addObject("username", "Welcome " + user.getUsername()+"/"+user.getId());
        model.addAttribute("employee", employee);
        model.addAttribute("employee_id", employee.getId());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /*

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }
     */

}
