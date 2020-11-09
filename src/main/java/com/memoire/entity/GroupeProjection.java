package com.memoire.entity;

import org.springframework.data.rest.core.config.Projection;

 @Projection(name = "s6",types = Groupe.class)
public interface GroupeProjection {
    public String  getNomGrp();
    public Filliere getFilliere();
public Niveau getNiveau();
}
