package com.memoire.entity;

import org.springframework.data.rest.core.config.Projection;


@Projection(name = "s2",types = Sujet.class)
public interface SujetEtatProjection {

    public Boolean getValider();

}
