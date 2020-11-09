package com.memoire.dao;

import com.memoire.entity.Ensigniant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnsigniantRepository extends JpaRepository<Ensigniant, Long> {
    public Ensigniant findByNomEnseigniant(String nomEnseigniant);
//    public String findByNomEnseigniant(String nomEnseigniant);
    public Ensigniant findBytelEnsegniant(Long telEnsegniant);
}

