package com.memoire.dao;

import com.memoire.entity.Etudiant;
import com.memoire.entity.ParamatrageAnnee;
import com.memoire.entity.ParamatragePeriodePropose;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface ParamatragePeriodeProposeRepository  extends JpaRepository<ParamatragePeriodePropose, Long> {
    public ParamatragePeriodePropose findByDebutperiodeProposesujet(Date debutperiodeProposesujet);
    public ParamatragePeriodePropose findByFinperiodeProposesujet(Date finperiodeProposesujet);
}

