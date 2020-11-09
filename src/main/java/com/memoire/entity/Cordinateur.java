package com.memoire.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;



@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Cordinateur extends Ensigniant {
    private String Nomcordinateur;
    @OneToMany
    @JsonIgnore
    private Collection<Filliere> fillier_cordone;
    @OneToMany
    @JsonIgnore
    private Collection<Cordinateur> sujetValider;

    public String getNomcordinateur() {
        return Nomcordinateur;
    }

    public void setNomcordinateur(String nomcordinateur) {
        Nomcordinateur = nomcordinateur;
    }

    public Collection<Filliere> getFillier_cordone() {
        return fillier_cordone;
    }

    public void setFillier_cordone(Collection<Filliere> fillier_cordone) {
        this.fillier_cordone = fillier_cordone;
    }

    public Collection<Cordinateur> getSujetValider() {
        return sujetValider;
    }

    public void setSujetValider(Collection<Cordinateur> sujetValider) {
        this.sujetValider = sujetValider;
    }
}
