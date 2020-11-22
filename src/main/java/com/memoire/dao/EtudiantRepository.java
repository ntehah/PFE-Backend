package com.memoire.dao;

import com.memoire.entity.Etudiant;
import com.memoire.entity.Niveau;
import com.memoire.entity.Role;
import com.memoire.entity.Sujet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Etudiant findByNom(String nom);
    public Etudiant findByMatriculeetudiant(String matriculeetudiant);
    @RestResource(path = "/BymatriculeetudiantListe")
    public Page<Etudiant> findByMatriculeetudiant(@Param("mc") String mc,Pageable pageable);
//    public  Etudiant findByMatricule_etudiant(String matricule_etudiant);

    @Query(value="select n from Etudiant n")
    public Page<Etudiant>affichierEtudiant(Pageable pageable);




    @Query(value="select a from Etudiant a where a.matriculeetudiant like :x or a.nom like :x "+ " or a.prenom like :x")
    public Page<Etudiant>chercherEtudiant(@Param("x") String motcle,Pageable pageable);

}
