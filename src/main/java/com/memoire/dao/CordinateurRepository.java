package com.memoire.dao;

import com.memoire.entity.Cordinateur;
import com.memoire.entity.Ensigniant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CordinateurRepository extends JpaRepository<Cordinateur, Long> {
    public Cordinateur findByTelEnsegniant(Long telEnsegniant);
    public Cordinateur findByNomEnseigniant(String nomEnseigniant);}
