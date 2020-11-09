package com.memoire.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Jury implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idJury;
    private Date datePlanning;
    @OneToMany
    private Collection<Ensigniant> ensigniants = null;

    public long getIdJury() {
        return idJury;
    }

    public void setIdJury(long idJury) {
        this.idJury = idJury;
    }

    public Date getDatePlanning() {
        return datePlanning;
    }

    public void setDatePlanning(Date datePlanning) {
        this.datePlanning = datePlanning;
    }

    public void setEnsigniants(Collection<Ensigniant> ensigniants) {
        this.ensigniants = ensigniants;
    }

    public Collection<Ensigniant> getEnsigniants() {
        return ensigniants;
    }



    public void setEnsigniant(Ensigniant ensigniant) {

        if (this.ensigniants == null) this.ensigniants = new ArrayList<>();
        this.ensigniants.add(ensigniant);
    }
}