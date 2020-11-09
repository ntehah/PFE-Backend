package com.memoire.entity;
//

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;
//

//
@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//

public class Encad_acadimique extends Ensigniant {
	private String NomEncadrant;
	@OneToMany(mappedBy = "encad_acadimique")
	private Collection<Sujet> sujet_encadre;

}
