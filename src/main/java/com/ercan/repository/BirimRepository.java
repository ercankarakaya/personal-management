package com.ercan.repository;

import com.ercan.entity.Birim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirimRepository extends JpaRepository<Birim,Long> {
}
