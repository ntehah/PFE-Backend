package com.memoire.dao;

import com.memoire.entity.Ensigniant;
import com.memoire.entity.Etudiant;
import com.memoire.entity.Groupe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EnsigniantRepository extends JpaRepository<Ensigniant, Long> {
    public Ensigniant findByNomEnseigniant(String nomEnseigniant);
    //    public String findByNomEnseigniant(String nomEnseigniant);
    public Ensigniant findBytelEnsegniant(Long telEnsegniant);
    @Query(value="select n from Ensigniant n")
    public Page<Ensigniant> affichierEnsigniant(Pageable pageable);

    @Query(value="select a from Ensigniant a where a.nomEnseigniant like :x or a.prenom like :x "+ " or a.telEnsegniant like :x")

    public Page<Ensigniant>chercherEnsigniant(@Param("x") String motcle, Pageable pageable);



}

