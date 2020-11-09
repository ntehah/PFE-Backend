package com.memoire.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@SequenceGenerator(sequenceName="SEQ_INHERITANCE_TABLE_PER_CLASS",
//		name="seqTPC", initialValue=0, allocationSize=1)

public class Ensigniant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqTPC")
    private Long telEnsegniant;
    private String nomEnseigniant, prenom, specialiter;
    @OneToMany
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Collection<Sujet> sujets_proposer;

    @ManyToOne

    private Departement departement;
//	@JsonIgnore
//	@ManyToOne
//	@JoinColumn(name = "compte")
//	private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getTelEnsegniant() {
        return telEnsegniant;
    }

    public void setTelEnsegniant(Long telEnsegniant) {
        this.telEnsegniant = telEnsegniant;
    }

    public String getNomEnseigniant() {
        return nomEnseigniant;
    }

    public void setNomEnseigniant(String nomEnseigniant) {
        this.nomEnseigniant = nomEnseigniant;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSpecialiter() {
        return specialiter;
    }

    public void setSpecialiter(String specialiter) {
        this.specialiter = specialiter;
    }

    public Collection<Sujet> getSujets_proposer() {
        return sujets_proposer;
    }

    public void setSujets_proposer(Collection<Sujet> sujets_proposer) {
        this.sujets_proposer = sujets_proposer;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}





