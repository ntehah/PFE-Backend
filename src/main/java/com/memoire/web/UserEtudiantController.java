package com.memoire.web;

import com.memoire.dao.EtudiantRepository;
import com.memoire.dao.UserRepository;
import com.memoire.entity.Etudiant;
import com.memoire.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;


public class UserEtudiantController {
    @Autowired
    private UserRepository userRepository;
@Autowired
    EtudiantRepository etudiantRepository;

   @GetMapping (path = "/usersetudiants")
   public List <User> ListeUser() {
      return userRepository.findAll();
    }

}
