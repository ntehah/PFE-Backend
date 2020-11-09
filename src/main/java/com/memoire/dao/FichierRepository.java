package com.memoire.dao;

import com.memoire.entity.Etudiant;
import com.memoire.entity.Fichier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichierRepository extends JpaRepository<Fichier, Long> {
    public Fichier findByIdFicher(Long idFicher);
}
