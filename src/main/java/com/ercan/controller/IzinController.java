package com.ercan.controller;

import com.ercan.entity.Employee;
import com.ercan.entity.Izinler;
import com.ercan.service.EmployeeService;
import com.ercan.service.IzinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/izin")
public class IzinController {

    @Autowired
    private IzinService izinService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public String izinler(@PathVariable("id") Long id, Model model) {
        Employee emp = employeeService.getbyId(id);
        List<Izinler> izinler = izinService.izinList(emp.getId());
        List<Izinler> taslakIzinler = izinService.taslakIzinler("Beklemede", emp.getId());
        model.addAttribute("izinList", izinler);
        model.addAttribute("employee_id", emp.getId());
        model.addAttribute("taslakIzinler", taslakIzinler);
        return "index";

    }

    @GetMapping("/onay-bekleyen/{id}")
    public String onayBekleyen(@PathVariable("id") Long id, Model model) {
        Employee emp = employeeService.getbyId(id);
        List<Izinler> onayIzinler = izinService.onaylanacakIzinler(emp.getBirim().getBirimName());
        model.addAttribute("onaylanacakIzinler", onayIzinler);
        model.addAttribute("employee_id", emp.getId());
        return "index";
    }

    @GetMapping("/onayla/{id}")
    public String onayla(@PathVariable("id") Long id, Model model) {
        Izinler izin = izinService.getbyId(id);
        izin.setDurum("Onaylandı");
        izinService.saveIzin(izin);
        return "redirect:/";
    }
}
