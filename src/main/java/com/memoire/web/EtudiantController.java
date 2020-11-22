package com.memoire.web;

import com.memoire.dao.SujetRepository;
import com.memoire.dao.UserRepository;
import com.memoire.entity.*;
import com.memoire.service.AccountService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EtudiantController {
    @Autowired

    private AccountService accountService;
    @Autowired
    SujetRepository sujetRepository;
    @Autowired
    UserRepository userRepository;

//        @PostMapping("/ProposeSujetParGrp")
//        public Sujet ProposeSujetParGrp(@RequestBody EtudiantForme etudiantForme){
//            return  accountService.ProposeSujetParGrp(etudiantForme.getTitreSujet(),
//                    etudiantForme.getNomEntreprice(),etudiantForme.getIdGrp());
//
//        }

    @GetMapping("/SoumisionEtudiant")
    public List<Sujet> ListSoumission() {
        List<Sujet> sujetList = new ArrayList<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        System.out.println("USERNAME: "+name);
        User user = userRepository.findByUsername(name);
        Collection<Etudiant> etudiants = user.getEtudiants();
        if (etudiants != null) {
            etudiants.forEach(etudiant -> {
                if (etudiant.getGroupe() != null) {
                    List<Sujet> list = sujetRepository.findSujetsByGroupe(etudiant.getGroupe());
                    list.forEach(sujet -> {
                        if(sujet.getValider())
                            sujetList.add(sujet);
                    });
                }

            });
        }

        return sujetList;
    }


    @GetMapping("/EtudiantListeSujetPropose")
    public List<Sujet> ListeSujet() {
        List<Sujet> sujetList = new ArrayList<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        System.out.println("USERNAME: "+name);
        User user = userRepository.findByUsername(name);
        Collection<Etudiant> etudiants = user.getEtudiants();
        if (etudiants != null) {
            etudiants.forEach(etudiant -> {
                if (etudiant.getGroupe() != null) {
                    List<Sujet> list = sujetRepository.findSujetsByGroupe(etudiant.getGroupe());
                    list.forEach(sujet -> {
                        if(!sujet.getValider())
                        sujetList.add(sujet);
                    });
                }

            });
        }

        return sujetList;
    }

    @GetMapping("/GroupeEtuduant")
    public Groupe getGroupe() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        System.out.println("USERNAME: "+name);
        User user = userRepository.findByUsername(name);

        Optional<Etudiant> etudiantOptional=user.getEtudiants().stream().findFirst();
        if (etudiantOptional.isPresent()){
            return etudiantOptional.get().getGroupe();
        }
        return null;
    }
}

@Data
class EtudiantForme {
    private String titreSujet;
    private String nomEntreprice;
    private String idGrp;
}
