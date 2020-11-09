package com.memoire.entity;

import javax.persistence.ManyToOne;

import org.springframework.data.rest.core.config.Projection;


@Projection(name = "s3",types = Etudiant.class)
public interface EtudiantProjection {
      public  String getMatriculeetudiant();
    public String getNom();
    public String getPrenom();
    public Groupe getGroupe();
    public Filliere getFilliere();
    public Niveau getNiveau();


}
