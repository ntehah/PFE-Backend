package com.memoire.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Superviseur implements Serializable {
    @Id
    private int tel_superviseur;
    private String nom;
    private String prenom;
    private String specialite;
    //    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    //@JoinColumn(name = "nom_entreprise")
//    private Entreprise entreprise;
    @OneToMany(fetch = FetchType.EAGER)
    private Collection <Sujet> sujets = new ArrayList<>();
}