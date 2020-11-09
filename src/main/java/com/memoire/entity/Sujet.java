package com.memoire.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Sujet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String titreSujet;

    private Date dateHeures = new Date();

    private String description;
    private String resultatsattendus;
    private String competances;
    private Boolean valider;
    private Boolean DemendeEncadrant;
    private int nbrEtudiantMin;
    private int nbrEtudiantMax;

    @ManyToOne
    @JoinColumn(name = "nomEnseignatProposer")
    private Ensigniant ensigniant;
    @OneToOne
    @JsonIgnore
    private Groupe groupe;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "AnneeEncours")
    private ParamatrageAnnee paramatrageAnnee;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cordintereValider")
    private Cordinateur cordinateur;
    @JsonIgnore
    @ManyToOne
    private Filliere fillieres;
    @JsonIgnore
    @ManyToOne
//@JoinColumn(name = "superviseur")
    private Superviseur superviseur;

    @ManyToOne
//	@JoinColumn(name = "entrepriseAcceuill")
    private Entreprise entreprise;
    @OneToMany
    private Collection<Fichier> fichiers = new ArrayList<>();
    @ManyToOne
//  @JoinColumn(name = "encad_acadimiquet")
    private Ensigniant encad_acadimique;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "periodePropose")
    private ParamatragePeriodePropose paramatragePeriodePropose;

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitreSujet() {
        return titreSujet;
    }

    public void setTitreSujet(String titreSujet) {
        this.titreSujet = titreSujet;
    }

    public Date getDateHeures() {
        return dateHeures;
    }

    public void setDateHeures(Date dateHeures) {
        this.dateHeures = dateHeures;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResultatsattendus() {
        return resultatsattendus;
    }

    public void setResultatsattendus(String resultatsattendus) {
        this.resultatsattendus = resultatsattendus;
    }

    public String getCompetances() {
        return competances;
    }

    public void setCompetances(String competances) {
        this.competances = competances;
    }

    public Boolean getValider() {
        return valider;
    }

    public void setValider(Boolean valider) {
        this.valider = valider;
    }

    public Boolean getDemendeEncadrant() {
        return DemendeEncadrant;
    }

    public void setDemendeEncadrant(Boolean demendeEncadrant) {
        DemendeEncadrant = demendeEncadrant;
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

    public Ensigniant getEnsigniant() {
        return ensigniant;
    }

    public void setEnsigniant(Ensigniant ensigniant) {
        this.ensigniant = ensigniant;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public ParamatrageAnnee getParamatrageAnnee() {
        return paramatrageAnnee;
    }

    public void setParamatrageAnnee(ParamatrageAnnee paramatrageAnnee) {
        this.paramatrageAnnee = paramatrageAnnee;
    }

    public Cordinateur getCordinateur() {
        return cordinateur;
    }

    public void setCordinateur(Cordinateur cordinateur) {
        this.cordinateur = cordinateur;
    }

    public Filliere getFillieres() {
        return fillieres;
    }

    public void setFillieres(Filliere fillieres) {
        this.fillieres = fillieres;
    }

    public Superviseur getSuperviseur() {
        return superviseur;
    }

    public void setSuperviseur(Superviseur superviseur) {
        this.superviseur = superviseur;
    }

    public Collection<Fichier> getFichiers() {
        return fichiers;
    }

    public void setFichiers(Collection<Fichier> fichiers) {
        this.fichiers = fichiers;
    }

    public Ensigniant getEncad_acadimique() {
        return encad_acadimique;
    }

    public void setEncad_acadimique(Ensigniant encad_acadimique) {
        this.encad_acadimique = encad_acadimique;
    }

    public ParamatragePeriodePropose getParamatragePeriodePropose() {
        return paramatragePeriodePropose;
    }

    public void setParamatragePeriodePropose(ParamatragePeriodePropose paramatragePeriodePropose) {
        this.paramatragePeriodePropose = paramatragePeriodePropose;
    }
}
