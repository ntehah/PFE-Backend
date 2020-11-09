package com.memoire.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@ToString
public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String roleName;

	public Role(long id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}

	public Role() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
