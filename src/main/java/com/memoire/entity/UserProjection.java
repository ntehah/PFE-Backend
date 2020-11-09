package com.memoire.entity;

import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;

@Projection(name = "s3",types = User.class)
public interface UserProjection {
    public  Long getId();
    public  String getUsername();
    public Collection<Etudiant> getEtudiants();
    public  Collection<Ensigniant>getEnsigniants();
}


