package com.memoire.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Date;

public class FinPerideProposeSujet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private  Date finperiodeProposesujet ;
//    @OneToMany
//    private Collection<Filliere> fillieres;
//    @OneToMany
//    private Collection<Sujet> sujets;
}
