package com.memoire.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Groupe implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String nomGrp;
    //	@OneToOne
//	private Sujet sujet;
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JsonIgnore
//	@JoinTable(name = "Demande",
//			joinColumns = @JoinColumn(name = "id_grupe"),
//			inverseJoinColumns = @JoinColumn(name = "titre_sujet"))
//	private Collection<Sujet> sujetsDemender = new ArrayList<>();
    @OneToMany()
    @JsonIgnore
    private Collection<Etudiant> etudiants = new ArrayList<>();
    @ManyToOne
    @JsonIgnore
    private Filliere filliere;
    @ManyToOne
    private Niveau niveau;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomGrp() {
        return nomGrp;
    }

    public void setNomGrp(String nomGrp) {
        this.nomGrp = nomGrp;
    }

    public Collection<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(Collection<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public Filliere getFilliere() {
        return filliere;
    }

    public void setFilliere(Filliere filliere) {
        this.filliere = filliere;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
}
