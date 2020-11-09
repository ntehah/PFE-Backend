package com.memoire.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private  long id;
	@Column(unique = true,name = "Email")
	private String username ;
	@Column(unique = true,name = "Username")
	private String Email ;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String  password ;
	private Boolean actived;
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection <Role> roles = new ArrayList<>();
   @OneToMany
	private  Collection<Etudiant> etudiants;
	@OneToMany
	private  Collection<Ensigniant> ensigniants;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActived() {
		return actived;
	}

	public void setActived(Boolean actived) {
		this.actived = actived;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public Collection<Ensigniant> getEnsigniants() {
		return ensigniants;
	}

	public void setEnsigniants(Collection<Ensigniant> ensigniants) {
		this.ensigniants = ensigniants;
	}
}
