package com.memoire.dao;

import com.memoire.entity.Filliere;
import com.memoire.entity.Groupe;
import com.memoire.entity.Niveau;
import com.memoire.entity.Sujet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface NiveouRepository extends JpaRepository<Niveau, Long> {
    public Niveau findByNomNiveou(String nomNiveou);
    @Query(
            value="SELECT * FROM Niveau  WHERE Filliere_id = ?1",
            nativeQuery = true)
    public List<Niveau> findByFilliere(Long id);


    @Query(value="select n from Niveau n")
    public Page<Niveau>affichierNiveau(Pageable pageable);




    @Query(value="select a from Niveau a where a.nomNiveou like :x or a.code like :x ")
    public Page<Niveau>chercherNiveau(@Param("x") String motcle,Pageable pageable);


//    @RestResource(path = "/BytitreNiveauContainspage")
//    Page<Niveau> BytitreNiveauContainspage(@Param("mc") String mc, Pageable pageable);


}
