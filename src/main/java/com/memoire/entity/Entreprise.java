package com.memoire.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Entreprise implements Serializable {
    @Id
    private String nomEntreprice;
    private String adresse;
    @OneToMany
    @JsonIgnore
    private Collection<Sujet> sujets;

    public String getNomEntreprice() {
        return nomEntreprice;
    }

    public void setNomEntreprice(String nomEntreprice) {
        this.nomEntreprice = nomEntreprice;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Collection<Sujet> getSujets() {
        return sujets;
    }

    public void setSujets(Collection<Sujet> sujets) {
        this.sujets = sujets;
    }
}