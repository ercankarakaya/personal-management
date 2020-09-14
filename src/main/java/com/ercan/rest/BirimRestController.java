package com.ercan.rest;


import com.ercan.entity.Birim;
import com.ercan.service.BirimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/birim")
public class BirimRestController {

    @Autowired
    private BirimService birimService;

    @GetMapping("/birimler")
    public List<Birim> birimList() {
        return birimService.findAll();
    }

    @GetMapping("/{id}")
    public Birim birim(@PathVariable Long id) {
        return birimService.getbyId(id);
    }

    @PostMapping("/add-birim")
    public Birim add(@RequestBody Birim birim) {
        birimService.saveBirim(birim);
        return birim;
    }
    @PutMapping(value = "/update-birim")
    public Birim update(@RequestBody Birim birim) {
        birimService.saveBirim(birim);
        return birim;
    }


}
