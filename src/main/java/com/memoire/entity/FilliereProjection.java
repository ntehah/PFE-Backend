package com.memoire.entity;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "s5",types = Filliere.class)
public interface FilliereProjection {
    public Long getId();
    public   String getNomfilliere();
    public String getCodefilliere();
    public Date getDebutperiodeProposesujet() ;
    public   Date getFinperiodeProposesujet() ;
    public Departement getDepartement();
    public Cordinateur gtCordinateur();
//    public  ParamatragePeriodePropose getParamatragePeriodePropose();
    public  PlanningSoutenance getPlanningSoutenance();
    public ParamatrageAnnee getParamatrageAnnee();
}
