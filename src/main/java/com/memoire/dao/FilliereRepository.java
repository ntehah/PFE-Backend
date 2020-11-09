package com.memoire.dao;

import com.memoire.entity.Departement;
import com.memoire.entity.Fichier;
import com.memoire.entity.Filliere;
import com.memoire.entity.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilliereRepository extends JpaRepository<Filliere, Long> {
    public Filliere findByNomfilliere(String nomfilliere);
    @Query(
            value="SELECT * FROM Filliere  WHERE Departement_id = ?1",
            nativeQuery = true)
    public List<Filliere> findByDepartement(Long id);
}
