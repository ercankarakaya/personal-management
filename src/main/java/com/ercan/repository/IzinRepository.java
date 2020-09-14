package com.ercan.repository;

import com.ercan.entity.Izinler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IzinRepository extends JpaRepository<Izinler,Long>,IzinRepositoryCustom {
}
