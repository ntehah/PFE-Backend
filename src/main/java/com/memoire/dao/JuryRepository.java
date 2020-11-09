package com.memoire.dao;

import com.memoire.entity.Groupe;
import com.memoire.entity.Jury;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JuryRepository extends JpaRepository<Jury, String> {
    public Jury findByIdJury(String idJury);
}
