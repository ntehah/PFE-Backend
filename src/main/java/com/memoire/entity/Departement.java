package com.memoire.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Departement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nomDepartement;
    private String codeDepartement;
    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Ensigniant> ensigniantsapartient;
    @OneToMany
    @JsonIgnore
    private Collection<Filliere> fillieres;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public void setCodeDepartement(String codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    public Collection<Ensigniant> getEnsigniantsapartient() {
        return ensigniantsapartient;
    }

    public void setEnsigniantsapartient(Collection<Ensigniant> ensigniantsapartient) {
        this.ensigniantsapartient = ensigniantsapartient;
    }

    public Collection<Filliere> getFillieres() {
        return fillieres;
    }

    public void setFillieres(Collection<Filliere> fillieres) {
        this.fillieres = fillieres;
    }
}
