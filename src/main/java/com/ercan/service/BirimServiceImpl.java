package com.ercan.service;


import com.ercan.repository.BirimRepository;
import com.ercan.entity.Birim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BirimServiceImpl implements BirimService{
    @Autowired
    private BirimRepository birimRepository;

    @Override
    public List<Birim> findAll() {
        return birimRepository.findAll();
    }

    @Override
    public Birim getbyId(Long birimId) {
        return birimRepository.findById(birimId).get();
    }

    @Override
    public Birim saveBirim(Birim birim) {
        return birimRepository.save(birim);
    }

}
