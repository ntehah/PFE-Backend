package com.memoire.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Etudiant implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private String matriculeetudiant;
    private String nom;
    private String prenom;
    @JsonIgnore
    @ManyToOne
    private Groupe groupe;
    @JsonIgnore
    @ManyToOne
    private Filliere filliere;
    @JsonIgnore
    @ManyToOne
    private Niveau niveau;

    public String getMatriculeetudiant() {
        return matriculeetudiant;
    }

    public void setMatriculeetudiant(String matriculeetudiant) {
        this.matriculeetudiant = matriculeetudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
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
