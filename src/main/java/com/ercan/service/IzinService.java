package com.ercan.service;

import com.ercan.repository.IzinRepository;
import com.ercan.entity.Izinler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IzinService {
    @Autowired
    private IzinRepository izinRepository;

    public List<Izinler> findAll() {
        return izinRepository.findAll();
    }

    public Izinler getbyId(Long izin_id) {
        return izinRepository.findById(izin_id).get();
    }

    public Izinler saveIzin(Izinler izin) {
        return izinRepository.save(izin);
    }

    public void deleteIzin(Long izin_id) {
        izinRepository.deleteById(izin_id);
    }

    public List<Izinler> izinList(Long id) {

        return izinRepository.izinlerList(id);
    }

    public List<Izinler> taslakIzinler(String durum, Long id) {
        return izinRepository.taslakIzinler(durum, id);
    }


    public List<Izinler> onaylanacakIzinler(String birimName) {
        return izinRepository.onaylanacakIzinler(birimName);
    }
}
