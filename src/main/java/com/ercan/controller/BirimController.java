package com.ercan.controller;

import com.ercan.entity.Birim;
import com.ercan.service.BirimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/birim")
public class BirimController {

    @Autowired
    private BirimService birimService;

    @GetMapping("/list")
    public String getBirimler(Model model) {
        List<Birim> birimList = birimService.findAll();
        model.addAttribute("birimList", birimList);
        return "index";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        Birim birim = new Birim();
        model.addAttribute("birim", birim);
        return "new_birim";
    }

    @PostMapping("/save")
    public String saveBirim(@ModelAttribute("birim") Birim birim) {
        birimService.saveBirim(birim);
        return "redirect:/birim/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") Long id) {
        ModelAndView modelView = new ModelAndView("edit_birim");
        Birim birim = birimService.getbyId(id);
        modelView.addObject("birim", birim);
        return modelView;
    }


}
