package com.memoire.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Niveau {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nomNiveou;

    private String annee;
    @OneToMany
    @JsonIgnore
    private Collection<Groupe> groupes;
    @JsonIgnore
    @ManyToOne
    private Filliere filliere;
    private String code;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomNiveou() {
        return nomNiveou;
    }

    public void setNomNiveou(String nomNiveou) {
        this.nomNiveou = nomNiveou;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public Collection<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(Collection<Groupe> groupes) {
        this.groupes = groupes;
    }

    public Filliere getFilliere() {
        return filliere;
    }

    public void setFilliere(Filliere filliere) {
        this.filliere = filliere;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
