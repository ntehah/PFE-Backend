package com.memoire.dao;

import com.memoire.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilliereRepository extends JpaRepository<Filliere, Long> {
    public Filliere findByNomfilliere(String nomfilliere);
    @Query(
            value="SELECT * FROM Filliere  WHERE Departement_id = ?1",
            nativeQuery = true)
    public List<Filliere> findByDepartement(Long id);
    @Query(value="select n from Filliere n")
    public Page<Filliere> affichierFilliere(Pageable pageable);

    @Query(value="select a from Filliere a where a.nomfilliere like :x or a.Codefilliere like :x ")
    public Page<Filliere>chercherFilliere(@Param("x") String motcle,Pageable pageable);



}
