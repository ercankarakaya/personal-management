package com.ercan.rest;

import com.ercan.entity.Employee;
import com.ercan.entity.Izinler;
import com.ercan.service.EmployeeService;
import com.ercan.service.IzinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/izin")
public class IzinRestController {

    @Autowired
    private IzinService izinService;
    @Autowired
    private EmployeeService employeeService;

    public Employee employee() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employee employee = employeeService.findUserByUsername(auth.getName());
        return employee;
    }

    @GetMapping("/izinler")
    public List<Izinler> izinler() {
        List<Izinler> izin = izinService.izinList(employee().getId());
        return izin;
    }

    @RequestMapping(value = "/izin-al", method = {RequestMethod.GET, RequestMethod.POST})
    public Izinler izinAl(@RequestBody Izinler izin) {
        Employee employee = employeeService.getIzinSayisiGuncelle(izin.getEmployee().getId(), izin.getGun_sayisi());
        employeeService.saveEmployeeDetails(employee);
//        izin.setEmployee(employee);
//        izin.setDurum("Beklemede");
        izinService.saveIzin(izin);
        return izin;
    }

}
