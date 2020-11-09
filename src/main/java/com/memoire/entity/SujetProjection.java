package com.memoire.entity;

import org.springframework.data.rest.core.config.Projection;

import javax.xml.crypto.Data;

@Projection(name = "s1",types = Sujet.class)
public interface SujetProjection {
//    @Query("select g from getGrp_propose g where g.idGrp !=null ")
//
    public String  getResultatsattendus();
    public Long getId();
    public String getDescription();
     public Groupe getGroupe();
     public  String getTitreSujet();
     public Ensigniant getEnsigniant();
     public Boolean getValider();
//   public  Entreprise getEntrepriseAcceuill(); i
     public  Filliere getFillieres();
     public  Boolean getDemendeEncadrant();
     public  Ensigniant getEncad_acadimique();
    public ParamatrageAnnee getParamatrageAnnee();
    public Entreprise getEntreprise();
    public  ParamatragePeriodePropose getParamatragePeriodePropose();

}
