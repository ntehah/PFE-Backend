package com.memoire.entity;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "s4",types = Ensigniant.class)
public interface EnsigniantProjection {
    public  String getTelEnsegniant();
    public String getNomEnseigniant();
    public String getPrenom();

    public Departement getDepartement();
}
