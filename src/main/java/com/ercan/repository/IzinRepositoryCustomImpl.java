package com.ercan.repository;

import com.ercan.entity.Izinler;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class IzinRepositoryCustomImpl implements IzinRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Izinler> izinlerList(Long id) {

        return entityManager.createQuery(
                "select i from Izinler i where i.employee.id= '" + id + "'", Izinler.class)
                .getResultList();
    }

    @Override
    public List<Izinler> taslakIzinler(String durum, Long id) {
        return entityManager.createQuery(
                "select i from Izinler i where i.durum= '" + durum + "'" +
                        " and" + " i.employee.id= '" + id + "'", Izinler.class)
                .getResultList();
    }

    @Override
    public List<Izinler> onaylanacakIzinler(String birimName) {
        return entityManager.createQuery(
                "select i from Izinler i where i.employee.birim.birimName= '" + birimName + "'"+
                " and i.durum='Beklemede'", Izinler.class)
                .getResultList();
    }

}
