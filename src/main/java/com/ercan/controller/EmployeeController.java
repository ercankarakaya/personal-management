package com.ercan.controller;

import com.ercan.entity.Employee;
import com.ercan.entity.Izinler;
import com.ercan.service.EmployeeService;
import com.ercan.service.IzinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private IzinService izinService;

    @GetMapping("/list")
    public String getEmployeeList(Model model) {
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employeeList", employeeList);
        return "index";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployeeDetails(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") Long id) {
        ModelAndView modelView = new ModelAndView("edit_employee");
        Employee employee = employeeService.getbyId(id);
        modelView.addObject("employee", employee);
        return modelView;
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(name = "id") Long id) {
        employeeService.deleteEmployeDetails(id);
        return "redirect:/employee/list";
    }


    @GetMapping("/izin-al/{id}")
    public String izinAl(Model model, @PathVariable(name = "id") Long id) {
        Izinler izin = new Izinler();
        Employee employeeDetails = employeeService.getbyId(id);
        izin.setEmployee(employeeDetails);
        model.addAttribute("izin", izin);
        return "izin-al";
    }

    @PostMapping("/izin-save")
    public String saveIzin(@ModelAttribute("izin") Izinler izin, Model model) {
        Employee emp = employeeService.getIzinSayisiGuncelle(izin.getEmployee().getId(), izin.getGunSayisi());
        employeeService.saveEmployeeDetails(emp);
        izin.setDurum("Beklemede");
        izinService.saveIzin(izin);
        return "redirect:/user";
    }
}
