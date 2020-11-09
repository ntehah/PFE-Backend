package com.memoire.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class ParamatragePeriodePropose {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonFormat(pattern = "dd-MM-yyyy")

    private Date debutperiodeProposesujet;
    @JsonFormat(pattern = "dd-MM-yyyy")

    private Date finperiodeProposesujet;
    @OneToMany
    private Collection<Filliere> fillieres;
    @OneToMany
    private Collection<Sujet> sujets;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Collection<Filliere> getFillieres() {
        return fillieres;
    }

    public void setFillieres(Collection<Filliere> fillieres) {
        this.fillieres = fillieres;
    }

    public Collection<Sujet> getSujets() {
        return sujets;
    }

    public void setSujets(Collection<Sujet> sujets) {
        this.sujets = sujets;
    }
}