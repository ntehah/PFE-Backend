package com.memoire.dao;

import com.memoire.entity.Etudiant;
import com.memoire.entity.Role;
import com.memoire.entity.Sujet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, String> {
    Etudiant findByNom(String nom);
    public Etudiant findByMatriculeetudiant(String matriculeetudiant);
    @RestResource(path = "/BymatriculeetudiantListe")
    public Page<Etudiant> findByMatriculeetudiant(@Param("mc") String mc,Pageable pageable);
//    public  Etudiant findByMatricule_etudiant(String matricule_etudiant);
}
