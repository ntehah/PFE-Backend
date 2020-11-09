package com.memoire.dao;

import com.memoire.entity.Cordinateur;
import com.memoire.entity.Encad_acadimique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  Encad_acadimiqueRepository extends JpaRepository<Encad_acadimique, Long> {
    public Encad_acadimique findByTelEnsegniant(Long telEnsegniant);
    public Encad_acadimique findByNomEnseigniant(String nomEnseigniant);}
