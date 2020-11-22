package com.memoire.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Filliere {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nomfilliere;
    private String Codefilliere;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Sujet> sujets = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "cordinateur_filliere")
    @JsonIgnore
    private Cordinateur cordinateur;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Groupe> groupes;

    @OneToMany
    @JsonIgnore
    private Collection<Niveau> niveaus;
    @ManyToOne

    private Departement departement;
    @JsonFormat(pattern = "dd-MM-yyyy")

    private Date debutperiodeProposesujet;

    @JsonFormat(pattern = "dd-MM-yyyy")

    private Date finperiodeProposesujet;
    @JsonFormat(pattern = "dd-MM-yyyy")

    private Date dateDebutSoutenance;

    @JsonFormat(pattern = "dd-MM-yyyy")

    private Date DateFinSoutenance;

    private String paramatrageAnnee;

    @ManyToOne
    @JsonIgnore
    private PlanningSoutenance planningSoutenance;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomfilliere() {
        return nomfilliere;
    }

    public void setNomfilliere(String nomfilliere) {
        this.nomfilliere = nomfilliere;
    }

    public String getCodefilliere() {
        return Codefilliere;
    }

    public void setCodefilliere(String codefilliere) {
        Codefilliere = codefilliere;
    }

    public Collection<Sujet> getSujets() {
        return sujets;
    }

    public void setSujets(Collection<Sujet> sujets) {
        this.sujets = sujets;
    }

    public Cordinateur getCordinateur() {
        return cordinateur;
    }

    public void setCordinateur(Cordinateur cordinateur) {
        this.cordinateur = cordinateur;
    }

    public Collection<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(Collection<Groupe> groupes) {
        this.groupes = groupes;
    }

    public Collection<Niveau> getNiveaus() {
        return niveaus;
    }

    public void setNiveaus(Collection<Niveau> niveaus) {
        this.niveaus = niveaus;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Date getDebutperiodeProposesujet() {
        return debutperiodeProposesujet;
    }

    public void setDebutperiodeProposesujet(Date debutperiodeProposesujet) {
        this.debutperiodeProposesujet = debutperiodeProposesujet;
    }

    public Date getFinperiodeProposesujet() {
        return finperiodeProposesujet;
    }

    public void setFinperiodeProposesujet(Date finperiodeProposesujet) {
        this.finperiodeProposesujet = finperiodeProposesujet;
    }
    public Date getDateDebutSoutenance() {
        return dateDebutSoutenance;
    }

    public void setDateDebutSoutenance(Date dateDebutSoutenance) {
        this.dateDebutSoutenance = dateDebutSoutenance;
    }

    public Date getDateFinSoutenance() {
        return DateFinSoutenance;
    }

    public void setDateFinSoutenance(Date dateFinSoutenance) {
        DateFinSoutenance = dateFinSoutenance;
    }

    public String getParamatrageAnnee() {
        return paramatrageAnnee;
    }

    public void setParamatrageAnnee(String paramatrageAnnee) {
        this.paramatrageAnnee = paramatrageAnnee;
    }
}
