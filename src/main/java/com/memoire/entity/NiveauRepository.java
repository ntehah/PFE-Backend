package com.memoire.entity;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "n1",types = Niveau.class)
public interface NiveauRepository {
    public Filliere getFilliere();
    public String getNomNiveou();

    public String getAnnee();
    public String getCode();
}
