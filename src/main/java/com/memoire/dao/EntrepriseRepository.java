package com.memoire.dao;

import com.memoire.entity.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprise, String> {
    public Entreprise findByNomEntreprice(String nomEntreprice);
//    public Entreprise findByNomEntreprice(String nomEntreprice);
}
