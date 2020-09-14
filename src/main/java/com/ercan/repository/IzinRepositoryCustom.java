package com.ercan.repository;


import com.ercan.entity.Izinler;

import java.util.List;

public interface IzinRepositoryCustom {
    List<Izinler> izinlerList(Long id);
    List<Izinler> taslakIzinler(String durum,Long id);

    List<Izinler> onaylanacakIzinler(String birimName);
}
