package com.memoire.dao;

import com.memoire.entity.Groupe;
import com.memoire.entity.ParamatrageAnnee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface ParamatrageAnneeRepository  extends JpaRepository<ParamatrageAnnee, String> {
    public ParamatrageAnnee findByAnneeEncours(String anneeEncours);
}
