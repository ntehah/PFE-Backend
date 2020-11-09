package com.memoire.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlanningSoutenance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "debutSoutenace")
    private Date dateSoutence;

    private int salle;
    private Time heure_debut;

    private Time heure_fin;
    @OneToOne
    private Sujet sujets;
    @OneToOne
    private Jury jury_planning;
    @OneToOne
    private Groupe groupe;
    @OneToOne
    private Filliere filliere;

    private boolean soutene;
    private int note;
    private String mention;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setHeure_debut(Time heure_debut) {
        this.heure_debut = heure_debut;
    }

    public void setHeure_fin(Time heure_fin) {
        this.heure_fin = heure_fin;
    }

    public boolean isSoutene() {
        return soutene;
    }

    public void setSoutene(boolean soutene) {
        this.soutene = soutene;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getMention() {
        return mention;
    }

    public void setMention(String mention) {
        this.mention = mention;
    }

    public Date getDateSoutence() {
        return dateSoutence;
    }

    public void setDateSoutence(Date dateSoutence) {
        this.dateSoutence = dateSoutence;
    }


    public int getSalle() {
        return salle;
    }

    public void setSalle(int salle) {
        this.salle = salle;
    }

    public Date getHeure_debut() {
        return heure_debut;
    }


    public Date getHeure_fin() {
        return heure_fin;
    }


    public Sujet getSujets() {
        return sujets;
    }

    public void setSujets(Sujet sujets) {
        this.sujets = sujets;
    }

    public Jury getJury_planning() {
        return jury_planning;
    }

    public void setJury_planning(Jury jury_planning) {
        this.jury_planning = jury_planning;
    }

    public Filliere getFilliere() {
        return filliere;
    }

    public void setFilliere(Filliere filliere) {
        this.filliere = filliere;
    }
}