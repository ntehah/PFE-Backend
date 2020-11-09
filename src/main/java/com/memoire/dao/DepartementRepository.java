package com.memoire.dao;

import com.memoire.entity.Departement;
import com.memoire.entity.Etudiant;
import com.memoire.entity.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement, String> {
    public Departement findByNomDepartement(String nomDepartement);

}
