package com.memoire.dao;

import com.memoire.entity.Ensigniant;
import com.memoire.entity.Filliere;
import com.memoire.entity.Groupe;
import com.memoire.entity.Sujet;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
@RepositoryRestResource
public interface SujetRepository  extends JpaRepository<Sujet, Long> {
    public Sujet findBytitreSujet(  @Param("titre") String titreSujet);

//    @RestResource(path = "/ByTitreSujet")
//    public Page<Sujet> findBytitreSujet(@Param("tr") String tr, Pageable pageable);

    List<Sujet> findSujetsByGroupe(Groupe groupe);
    List<Sujet> findSujetsByFillieres(Filliere filliere);
    List<Sujet> findSujetsByEnsigniant(Ensigniant ensigniant);

    @RestResource(path = "/BytitreSujetContains")
    List<Sujet> findBytitreSujetContains( @Param("mc") String mc);
    @RestResource(path = "/BytitreSujetContainspage")
    Page<Sujet> findBytitreSujetContains( @Param("mc") String mc,Pageable pageable);
}
