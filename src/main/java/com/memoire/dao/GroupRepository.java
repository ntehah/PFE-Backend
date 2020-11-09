package com.memoire.dao;

import com.memoire.entity.Groupe;
import com.memoire.entity.Role;
import com.memoire.entity.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupRepository extends JpaRepository<Groupe, Long> {
   public Groupe findByNomGrp(String nomGrp);

   @Query(
           value="SELECT * FROM Groupe  WHERE Filliere_id = ?1",
           nativeQuery = true)
   public List<Groupe> findByFilliere(Long id);

    @Query(
            value="SELECT * FROM Groupe  WHERE Niveau_id = ?1",
            nativeQuery = true)
    public List<Groupe> findByNiveau(Long id);

}
