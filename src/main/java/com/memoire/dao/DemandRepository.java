package com.memoire.dao;

import com.memoire.entity.Demande;
import com.memoire.entity.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandRepository extends JpaRepository<Demande, Long> {

    List<Demande> findDemandesBySujet_Ensigniant_Id(long id);
    Demande findDemandeByGroupe(Groupe groupe);
    List<Demande> findDemandesByEtat(int etat);


}
