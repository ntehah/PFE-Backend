package com.memoire.entity;

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
public class ParamatrageAnnee {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;

    private String anneeEncours;
  @OneToMany
    private Collection<Sujet> sujets;
    private int nbrEtudiantMin;
    private int nbrEtudiantMax;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnneeEncours() {
        return anneeEncours;
    }

    public void setAnneeEncours(String anneeEncours) {
        this.anneeEncours = anneeEncours;
    }

    public Collection<Sujet> getSujets() {
        return sujets;
    }

    public void setSujets(Collection<Sujet> sujets) {
        this.sujets = sujets;
    }

    public int getNbrEtudiantMin() {
        return nbrEtudiantMin;
    }

    public void setNbrEtudiantMin(int nbrEtudiantMin) {
        this.nbrEtudiantMin = nbrEtudiantMin;
    }

    public int getNbrEtudiantMax() {
        return nbrEtudiantMax;
    }

    public void setNbrEtudiantMax(int nbrEtudiantMax) {
        this.nbrEtudiantMax = nbrEtudiantMax;
    }
}
