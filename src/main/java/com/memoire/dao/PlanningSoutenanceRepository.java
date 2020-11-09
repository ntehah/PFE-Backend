package com.memoire.dao;

import com.memoire.entity.ParamatragePeriodePropose;
import com.memoire.entity.PlanningSoutenance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface  PlanningSoutenanceRepository extends JpaRepository<PlanningSoutenance, Long> {
    List<PlanningSoutenance> findByDateSoutence(Date dateSoutence);
}