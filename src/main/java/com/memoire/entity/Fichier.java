package com.memoire.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Fichier implements Serializable {
    @Id
    @GeneratedValue
    private Long idFicher;
    private String emplacement;
    private String type;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Sujet sujet;
}